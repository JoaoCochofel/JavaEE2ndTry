/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Inquerito;
import Entities.Pergunta;
import Entities.Resposta;
import Entities.Utilizador;
import EntityBeans.InqueritoFacade;
import EntityBeans.PerguntaFacade;
import EntityBeans.RespostaFacade;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;



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

    public Map<Pergunta, List<Resposta>> getPerguntasRespostas() {
        return perguntasRespostas;
    }

    public void setPerguntasRespostas(Map<Pergunta, List<Resposta>> perguntasRespostas) {
        this.perguntasRespostas = perguntasRespostas;
    }
    
    
    
    public Inquerito getInquerito(){
        List<Pergunta> tmpPergunta = new ArrayList();
        List<Resposta> tmpResposta = new ArrayList();
        tmpPergunta = perFac.findAll();
        tmpResposta = resFac.findAll();
        List<Resposta> resTmp2;
        perguntasRespostas = new HashMap();
        inquerito = inqueritos.get((int)idInq);
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
        inquerito = getInquerito();
        this.idInq = idInq;
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
    
    public String deploy(){
        return "yes!";
    }

    
}
