/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Algoritmos.NewClass;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Altran
 */

@ManagedBean
@ViewScoped
@Named(value = "controlBackup")

public class ControlBackup {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    Toolkit toolkit;
    Timer timer;
    
    static Connection con = null;
    static Statement stmt = null;
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/stocks";
    static final String USER = "app";
    static final String PASS = "app";
    
       
    @NotEmpty
    private String tipoTempo;
    
    @NotEmpty
    private String tempo;

    /**
     * @return the tipoTempo
     */
    public String getTipoTempo() {
        return tipoTempo;
    }

    /**
     * @param tipoTempo the tipoTempo to set
     */
    public void setTipoTempo(String tipoTempo) {
        this.tipoTempo = tipoTempo;
    }

    /**
     * @return the tempo
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    
    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("Time's up!");
            NewClass nc = new NewClass();
            

            
            //Faz backup
          //  String sucess = "Guardado com Sucesso";
        //FileOutputStream fout = new FileOutputStream("clientesBin.bin");
        //ObjectOutputStream oos = new ObjectOutputStream(fout);

            System.exit(0); //Stops the AWT thread (and everything else)
        }
    }
    
    public String makeBackup(){

        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), Integer.parseInt(this.getTempo()) * 1000);
        
        
        //System.out.println(this.getTipoTempo());
        //System.out.println(this.getTempo());
        
        return "success";
    }
    
    
    
}
