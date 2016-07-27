/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Inquerito;
import EntityBeans.InqueritoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author João
 */
@ManagedBean
@ViewScoped
public class InqueritosLister {
    private List<Inquerito> inqueritos;
    private List<String> listaInqueritos;
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

    
    
    public List<Inquerito> getInqueritos() {
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
