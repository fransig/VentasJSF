/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.VentasJSF.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fran
 */
public class DAO {
    
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    String url= "jdbc:mysql://localhost:3306/ventas";
        String user= "blog";
        String password="1234";
    
    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
                throw e;
        }
        
        
    }
    
    public void cerrar() throws Exception{
        if(cn != null){
            try {
                if (cn.isClosed()== false){
                    cn.close();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }
    
}
