package cad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author fgb
 */
public class InsercionDatos {
    public Connection conn;
    
    public InsercionDatos() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
    }

    /**
     * inicio de conexion de la base de datos con postgres
     * @throws SQLException
     */
    public void openDB() throws SQLException {
        Properties connProp = new Properties();
        connProp.put("user", "postgres");
        connProp.put("password", "root");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce_db", connProp);
    }
        

    /**
    * Cierra la conexión con la base de datos
    * @throws SQLException
    */    
    public void closeDB() throws SQLException {
        conn.close();
    }
    /**
     * 
     * @param campos
     * @param tabla
     * @param valores
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Integer insertar(String campos, String tabla, String valores) throws SQLException, ClassNotFoundException {        
        openDB();
        PreparedStatement ps;
        ps=conn.prepareStatement("INSERT INTO "+tabla+" ("+campos+") VALUES ("+valores+")");
        Integer rs = ps.executeUpdate();
        closeDB();
        return rs;
    }
    
   /**
     * 
     * @param campos
     * @param tabla
     * @param condicion
     * @param cantidad
     * @return
     * @throws SQLException 
     */
    public ArrayList consulta(String campos, String tabla, String condicion, int cantidad) throws SQLException {
        openDB();
        ArrayList r=new ArrayList();
        PreparedStatement ps;
        ps=conn.prepareStatement("SELECT "+campos+" FROM "+tabla+" WHERE "+condicion);
        ResultSet rs= ps.executeQuery();        
            while(rs.next()){
                for(int i = 1 ; i <= cantidad ; i++){
                    r.add(rs.getObject(i));
                }
            }        
        closeDB();        
        return r;
    }
    
}
