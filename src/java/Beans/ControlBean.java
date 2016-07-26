/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityBeans.UtilizadorFacade;
import java.io.Serializable;
import javax.ejb.EJB;
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
//@RequestScoped
@ViewScoped

@Named(value = "ControlBean")
public class ControlBean implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Size(min = 1, max = 10)
    @NotEmpty
    private String username;
    
    @Size(min = 1, max = 10)
    @NotEmpty
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String checkUser(String userName, String passWord) {

        
/*
        String ret = null;
        String user = this.getUsername();
        String pass = this.getPassword();

        //Variáveis criadas para teste, sendo que vão ser alimentadas com informação
        // proveniente da bd
        String valUser = "user";
        String valPass = "pass";
        String valPerfil = "admin";

        System.out.println("User inserido: " + user);
        System.out.println("Pass inserida: " + pass);

        if (user.equals(valUser)) {
            if (pass.equals(valPass)) {

                if (valPerfil.equals("admin")) {
                    ret = "adminPage";
                } else if (valPerfil.equals("gestor")) {
                    ret = "managePage";
                } else {
                    ret = "userPage";
                }

            } else { //password errada
                ret = "error";
                //addMessage("Password inexistente");
            }

        } else { //user inexistente
            
            ret = "error";
        }

*/
        return "";
    }
    
    public String createUser(){
        return "newUser";
    }
    
    public String viewUser() {
        return "viewUser";
    }

    public String editUser() {
        return "editUser";
    }

    public String viewUserType() {
        return "viewUserType";
    }

    public String createUserType() {
        return "createUserType";
    }

    public String editUserType() {
        return "editUserType";
    }
    
    
}
