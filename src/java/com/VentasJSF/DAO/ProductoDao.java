/*
 * To change this license header, choose License Headers in Project Proproties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.VentasJSF.DAO;

import com.VentasJSF.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fran
 */
public class ProductoDao extends DAO{
 
    public void registrar(Producto pro) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st= this.getCn().prepareStatement("INSERT INTO productos (nombre, precio) values(?,?)");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
    public List <Producto> listar() throws Exception{
        List <Producto> lista = null;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st= this.getCn().prepareStatement("SELECT codigo,nombre, precio FROM productos");
            rs= st.executeQuery();
            lista= new ArrayList();
            
            while(rs.next()){
                
                Producto pro= new Producto();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                
                lista.add(pro);
            }
            
        } catch (Exception e) {
        }finally{
             
            this.cerrar();
        }
        return lista;
       
    }
    
    
    public Producto leerId(Producto pro) throws Exception{
        Producto pros = null;
        ResultSet rs;
       try {
            this.Conectar();
            PreparedStatement st= this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM productos where codigo=?");
            st.setInt(1, pro.getCodigo());
            
            rs= st.executeQuery();
            
            while(rs.next()){
                pros = new Producto();
                pros.setCodigo(rs.getInt("codigo"));
                pros.setNombre(rs.getString("nombre"));
                pros.setPrecio(rs.getDouble("precio"));
            }
            
            
            
        } catch (Exception e) {
            
            throw e;
        }finally{
            this.cerrar();
        }
       return pros;
    }
    
    public void modificar(Producto pro) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st= this.getCn().prepareStatement("UPDATE  productos SET nombre=?, precio=? WHERE codigo=?");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.setInt(3, pro.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            
            throw e;
        }finally{
            this.cerrar();
        }
    }
        
      public void eliminar(Producto pro) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st= this.getCn().prepareStatement("DELETE FROM productos WHERE codigo=?");
            st.setInt(1, pro.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
                       throw e;
        }finally{
            this.cerrar();
        }
    }
    
}
