package edu.eci.cvds.beans;

import java.io.IOException;
import java.util.logging.Level;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.google.inject.Inject;

import edu.eci.cvds.security.ExceptionLogin;
import edu.eci.cvds.security.Logger;




@ManagedBean(name = "shiroBean")
@SessionScoped
public class ShiroBean extends BasePageBean{

    private static final long serialVersionUID = -5223360388656378877L;
    /*
     * @Inject private UserService service;
     */
    @Inject
    private Logger logger;
    private String email;
    private String password;
    private Boolean remember;
    private String message;
    private String redirectUrl = "/faces/paginaWeb.xhtml";

    public void login() throws IOException, ExceptionLogin{
        System.out.println("Hola entre en el login");
        System.out.println(email);
        System.out.println(password);
        boolean isLogger = logger.isLogged();
        if(!isLogger){
            System.out.println("Hola entre 2");
            logger.login(email, password, false);
            redirectHomeUser();
        } else{
            existingSession();
        }
    }

    public void redirectHomeUser() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(logger.isAdmin()){
            System.out.println("Entre a admin");
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
            facesContext.getExternalContext().redirect("../admin.xhtml");
        }
        if(logger.isUser()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
            facesContext.getExternalContext().redirect("../usuario.xhtml");
        }
    }

    public void existingSession() throws IOException{
        this.message = "Another user with those credentials already exists";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
    

    public void logout() throws IOException{
        SecurityUtils.getSubject().logout();         
        try {             
        	FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);         
        	} catch (IOException ex) 
        {             
        		java.util.logging.Logger.getLogger(ShiroBean.class.getName()).log(Level.SEVERE, null, ex);         }
    }

    public void comeBack() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(logger.isAdmin()){
            facesContext.getExternalContext().redirect("../admin.xhtml");
        }
        if(logger.isUser()){
            facesContext.getExternalContext().redirect("../usuario.xhtml");
        }
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean getRemember(){
        return remember;
    }

    public void setRemember(boolean remember){
        this.remember = remember;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
