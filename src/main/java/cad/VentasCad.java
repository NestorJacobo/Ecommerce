/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cad;

import JavaBeans.Producto;
import JavaBeans.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author REDEN MUSIC
 * 
 * 
 */
public class VentasCad {
    public static ArrayList<Venta> listarHistorial(String usuario){        
        try {
            String sql="select * from sp_historial(?);";
            Connection c=Conexion.conectar();
            CallableStatement sentencia=  (CallableStatement) c.prepareCall(sql);
            sentencia.setString(1, usuario);

            System.out.println("antes result");
            ResultSet res= sentencia.executeQuery();
            ArrayList<Venta> lista=new ArrayList<>();
            System.out.println("antes while");
            while(res.next()){
                System.out.println("Entro a while");
                Venta v=new Venta();
                System.out.println("Id Venta: "+res.getInt("id_venta"));
                v.setIdventa(res.getInt("id_venta"));
                v.setIdproducto(res.getInt("id_producto"));
                //System.out.println("Antes nombre");
                v.setNombreproducto(res.getString("nombre_producto"));
                //System.out.println("despuesnombre");
                v.setCantidad(res.getInt("cantidad"));
                v.setPreciounitario(res.getFloat("precio_unitario"));
                System.out.println(res.getFloat("precio_unitario"));
                v.setPreciototal(res.getFloat("precio_total"));
                v.setUsuario("luis");
                v.setFecha(res.getDate("fecha").toString());
                
                v.setEstado(res.getString("estado"));
                lista.add(v);
                //System.out.println(v);
            }
            System.out.println("TERMINO EXITOSO");
            return lista;
        } catch (SQLException ex) {
            System.out.println("ERRO********\n" + ex);
            return null;
        } 
    }
    
    public static void main(String[] args) {
        System.out.println(VentasCad.listarHistorial("omar"));
    }
}


