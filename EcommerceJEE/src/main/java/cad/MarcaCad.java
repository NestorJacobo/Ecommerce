/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cad;

import JavaBeans.Marca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author REDEN MUSIC
 */
public class MarcaCad {
    public static ArrayList<Marca> listarTodoDeMarcas(){
        try {
            String sql="{call sp_listartododeMarca()}";
            Connection c=Conexion.conectar();
            CallableStatement sentencia=  (CallableStatement) c.prepareCall(sql);
            //sentencia.setInt(1, catSuperior);
            ResultSet resultado=sentencia.executeQuery();
            ArrayList<Marca> lista=new ArrayList<>();
            while (resultado.next()) {                
                Marca m=new Marca();
                m.setCodigo(resultado.getInt("codigo"));
                m.setNombre(resultado.getString("nombre"));
                lista.add(m);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        } 
    }
    
    public static int contarMarcas(int co){
        try {
            String sql="{call sp_contarProductosMarca(?)}";
            Connection c=Conexion.conectar();
            CallableStatement sentencia=  (CallableStatement) c.prepareCall(sql);
            sentencia.setInt(1, co);
            ResultSet resultado=sentencia.executeQuery();
            resultado.next();
           return resultado.getInt(1);
        } catch (SQLException ex) {
            return 0;
        } 
    }
}
