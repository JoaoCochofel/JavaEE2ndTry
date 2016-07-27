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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author João
 */
@ManagedBean
@SessionScoped
public class ManagePergunta implements Serializable {

    private String inquerito;
    private Map<String, List<String>> perguntasRespostas;
    private List<String> respostas;
    private List<String> dummy;
    private String pergunta;
    private String resposta;

    private Date dataInit;
    private Date dataFim;

    @EJB
    InqueritoFacade incFac;
    @EJB
    PerguntaFacade perFac;
    @EJB
    RespostaFacade resFac;

    /**
     * Creates a new instance of ManagePergunta
     */
    public ManagePergunta() {
        respostas = new ArrayList<>();
        dummy = new ArrayList<>();
        perguntasRespostas = new HashMap<>();
    }

    public List<String> getDummy() {
        return dummy;
    }

    public void setDummy(List<String> dummy) {
        this.dummy = dummy;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Map<String, List<String>> getPerguntasRespostas() {
        return perguntasRespostas;
    }

    public void setPerguntasRespostas(Map<String, List<String>> perguntasRespostas) {
        this.perguntasRespostas = perguntasRespostas;
    }

    public List<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<String> respostas) {
        this.respostas = respostas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void remove(String str) {
        respostas.remove(str);
    }

    public void add() {
        respostas.add("");
    }

    public String addMap() {
        for (String resposta1 : respostas) {
            if (resposta1.isEmpty()) {
                respostas.remove(resposta1);
            }
        }
        perguntasRespostas.put(pergunta, respostas);
        respostas = new ArrayList();
        resposta = "";
        pergunta = "";
        return "inquerito";
    }

    public void deploy() {
        Inquerito inq = new Inquerito();
        Pergunta per ;
        Resposta res ;

        inq.setTituloInquerito(inquerito);
        inq.setDataInicio(dataInit.toString());
        inq.setDataFim(dataFim.toString());
        incFac.create(inq);
        for (String perguntaq : perguntasRespostas.keySet()) {
            per = new Pergunta();
            per.setInquerito(inq);
            per.setTextoPergunta(perguntaq);
            perFac.create(per);
            for (String respostaq : perguntasRespostas.get(per.getTextoPergunta())) {
                res=new Resposta();
                res.setTexto(respostaq);
                res.setPergunta(per);
                res.setRespCerta(null); //TODO - implementar possibilidade de ser resposta certa ou nao
                resFac.create(res);
            }
        }

    }

}
