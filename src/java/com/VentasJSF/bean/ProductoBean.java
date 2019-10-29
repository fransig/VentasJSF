/*
 * To change this license header, choose License Headers in Project Proproties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.VentasJSF.bean;

import com.VentasJSF.DAO.ProductoDao;
import com.VentasJSF.model.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;



/**
 *
 * @author fran
 */

@ManagedBean
@ViewScoped
public class ProductoBean {
    private Producto producto = new Producto();
    private List<Producto> lstProductos;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
            
            this.producto.setCodigo(0);
            this.producto.setNombre("");
            this.producto.setPrecio(0);
        }
    
    
     private void modificar() throws Exception{
        
        ProductoDao dao;
        
        try {
            dao= new ProductoDao();
            dao.modificar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    public void registrar() throws Exception{
        
        ProductoDao dao;
        
        try {
            dao= new ProductoDao();
            dao.registrar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception{
        
        ProductoDao dao;
        
        try {
            dao= new ProductoDao();
            lstProductos= dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }
    
    public void leerID(Producto pro) throws Exception{
        ProductoDao dao;
        Producto temp;
        
        try {
            dao= new ProductoDao();
            temp=dao.leerId(pro);
            
            if(temp !=null){
                this.producto= temp;
                this.accion="Modificar";
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
   
    
    public void eliminar(Producto pro) throws Exception{
        
        ProductoDao dao;
        
        try {
            dao= new ProductoDao();
            dao.eliminar(pro);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
