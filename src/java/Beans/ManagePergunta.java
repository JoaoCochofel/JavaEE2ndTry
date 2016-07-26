/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author João
 */
@ManagedBean
@ViewScoped
public class ManagePergunta {

    private Map<String, List<String>> perguntasRespostas;
    private Map<String, String> respostas;
    private String pergunta;
    private String resposta;
    private int i=1;

    /**
     * Creates a new instance of ManagePergunta
     */
    public ManagePergunta() {
        respostas = new HashMap<>();
        perguntasRespostas = new HashMap<>();
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
    

    public Map<String, List<String>> getPerguntasRespostas() {
        return perguntasRespostas;
    }

    public void setPerguntasRespostas(Map<String, List<String>> perguntasRespostas) {
        this.perguntasRespostas = perguntasRespostas;
    }

    public Map<String, String> getRespostas() {
        return respostas;
    }

    public void setRespostas(Map<String, String> respostas) {
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
        respostas.put(i+"" ,resposta);
        i++;
    }
    
    public void addMap(){
        List<String> l = new ArrayList();
        l.addAll(respostas.values());
        perguntasRespostas.put(pergunta, l);
        for (List<String> res : perguntasRespostas.values()) {
            System.out.println(res);
        }
    }

}
