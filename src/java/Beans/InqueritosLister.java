/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Inquerito;
import EntityBeans.InqueritoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> listaInqueritos;
    private int selectedIndex;
    long idInq;
    
    @EJB
    InqueritoFacade incFac;

    public List<String> getListaInqueritos() {
        fetchInqueritos();
        listaInqueritos = new ArrayList();
        for (Inquerito inc : inqueritos) {
            listaInqueritos.add(inc.getTituloInquerito());
        }
        return listaInqueritos;
    }

    public void setListaInqueritos(List<String> listaInqueritos) {
        this.listaInqueritos = listaInqueritos;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public String selectInq(long idInq){
        this.idInq = idInq;
        return("View");
    }
    
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    
    
    public List<Inquerito> getInqueritos() {
        fetchInqueritos();
        return inqueritos;
    }

    public void setInqueritos(List<Inquerito> inqueritos) {
        this.inqueritos = inqueritos;
    }
    
    public List<String> listaInqueritos(){
        fetchInqueritos();
        List<String> lstInc = new ArrayList();
        for (Inquerito inc : inqueritos) {
            lstInc.add(inc.getTituloInquerito());
        }
        return lstInc;
    }
    
    private void fetchInqueritos(){
        inqueritos = incFac.findAll();
    }
    
}
