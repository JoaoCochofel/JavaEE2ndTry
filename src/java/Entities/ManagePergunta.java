/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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

    /**
     * Creates a new instance of ManagePergunta
     */
    public ManagePergunta() {
        items1 = new ArrayList<>();
        items = new HashMap<>();
    }
    
    private Map<Item, List<Item>> items;
    private List<Item> items1;

    @PostConstruct
    public void init() {
        
    }

    public void add1() {
        Item item = new Item();
        item.setLabel("label" + items.size());
        List<Item> lst = new ArrayList();
        items.put(item, lst);
    }

    public Map<Item, List<Item>> getItems() {
        return items;
    }

    public void setItems(Map<Item, List<Item>> items) {
        this.items = items;
    }

    public void remove1(Item item) {
        items1.remove(item);
    }

    public List<Item> getItems1() {
        return items1;
    }
    
    public void add2(String label) {
        Item i = null, i2= new Item();
        for (Item item : items.keySet()) {
            if(item.getLabel().matches(label)){
                i = item;
            }
        }
        items.get(i).add(i2);
    }

    public void remove2(Item item) {
        items.remove(item);
    }

//    public List<Item> getItems2() {
//        return items;
//    }
    
}
