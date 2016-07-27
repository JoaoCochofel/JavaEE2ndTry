/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Inquerito;
import Entities.Pergunta;
import Entities.Resposta;
import EntityBeans.InqueritoFacade;
import EntityBeans.PerguntaFacade;
import EntityBeans.RespostaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author João
 */
@ManagedBean
@ViewScoped
public class InqueritosLister implements Serializable{
    private List<Inquerito> inqueritos;
    private Map<Pergunta, List<Resposta>> perguntasRespostas;
    private List<Resposta> respostasDadas;
    long idInq;
    
    private Inquerito inquerito;
    
    @EJB
    InqueritoFacade incFac;
    @EJB
    PerguntaFacade perFac;
    @EJB
    RespostaFacade resFac;
    

    public List<Resposta> getRespostasDadas() {
        return respostasDadas;
    }

    public void setRespostasDadas(List<Resposta> respostasDadas) {
        this.respostasDadas = respostasDadas;
    }
    
    public void setInquerito(Inquerito inquerito){
        this.inquerito = inquerito;
    }
    
    public Inquerito getInquerito(){
        List<Pergunta> tmpPergunta = new ArrayList();
        List<Resposta> tmpResposta = new ArrayList();
        tmpPergunta = perFac.findAll();
        tmpResposta = resFac.findAll();
        List<Resposta> resTmp2;
        perguntasRespostas = new HashMap();
        inquerito =  incFac.findAll().get((int)idInq);
        for (Pergunta per : tmpPergunta) {
            resTmp2 = new ArrayList();
            if(per.getInquerito().getIdInquerito() == idInq){
                for (Resposta resposta : tmpResposta) {
                    if(resposta.getPergunta().getIdPergunta().equals(per.getIdPergunta())){
                        resTmp2.add(resposta);
                    }
                }
            }
            perguntasRespostas.put(per, resTmp2);
        }
        return inquerito;
    }
    
    public String selectInq(long idInq){
        this.idInq = idInq;
        this.inquerito= getInquerito();
        return("View");
    }
    
    public List<Inquerito> getInqueritos() {
        fetchInqueritos();
        return inqueritos;
    }

    public void setInqueritos(List<Inquerito> inqueritos) {
        this.inqueritos = inqueritos;
    }
    
    private void fetchInqueritos(){
        inqueritos = incFac.findAll();
    }
    
    public List<Resposta> getRespostasPergunta(Pergunta p){
        return perguntasRespostas.get(p);
    }
    
    
}
