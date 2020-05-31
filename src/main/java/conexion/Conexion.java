
package conexion;

import java.sql.*;

public class Conexion {

    private Connection con = null;

    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce_db", "postgres", "root");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return con;
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
