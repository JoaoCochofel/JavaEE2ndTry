/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author João
 */
@ManagedBean
@SessionScoped
public class ManagePergunta implements Serializable{

    private Map<String, List<String>> perguntasRespostas;
    private List<String> respostas;
    private List<String> dummy;
    private String pergunta;
    private String resposta;
    
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
        System.out.println("tamanho de respostas:"+respostas.size());
        for (String resposta1 : respostas) {
            System.out.println(resposta1);
        }
    }
    
    public void addMap(){
        for (String resposta1 : respostas) {
            if(resposta1.isEmpty()){
                respostas.remove(resposta1);
            }
        }
        perguntasRespostas.put(pergunta, respostas);
        respostas = new ArrayList();
        resposta = "";
        pergunta = "";
    }

}
