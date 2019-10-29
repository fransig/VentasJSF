/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.VentasJSF.bean;

import com.VentasJSF.DAO.PersonaDao;
import com.VentasJSF.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;



/**
 *
 * @author fran
 */

@ManagedBean
@ViewScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> lstPersonas;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void operar() throws Exception{
        switch (accion){
            case "Registrar": 
                this.registrar();
                this.limpiar();
                break;
                
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
                
             
        }
    }
        
        public void limpiar(){
            
            this.persona.setCodigo(0);
            this.persona.setNombre("");
            this.persona.setSexo("");
        }
    
    
     private void modificar() throws Exception{
        
        PersonaDao dao;
        
        try {
            dao= new PersonaDao();
            dao.modificar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    public void registrar() throws Exception{
        
        PersonaDao dao;
        
        try {
            dao= new PersonaDao();
            dao.registrar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception{
        
        PersonaDao dao;
        
        try {
            dao= new PersonaDao();
            lstPersonas= dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    public void leerID(Persona per) throws Exception{
        PersonaDao dao;
        Persona temp;
        
        try {
            dao= new PersonaDao();
            temp=dao.leerId(per);
            
            if(temp !=null){
                this.persona= temp;
                this.accion="Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
   
    
    public void eliminar(Persona per) throws Exception{
        
        PersonaDao dao;
        
        try {
            dao= new PersonaDao();
            dao.eliminar(per);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
