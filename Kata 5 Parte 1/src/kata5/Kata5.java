package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Marcos del Cristo Díaz Gil
 * Ingeniería del Software 2, Universidad de Las Palmas de Gran Canaria
 */
public class Kata5 {
    public static void main(String[] args){
        String url = "jdbc:sqlite:Prueba.db";
        // Es conveniente comprobar que una tabla NO exista antes de crearla
        String sql = "CREATE TABLE IF NOT EXISTS Email (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT, \n"
                + " correo text NOT NULL);";
        
        
        Connection conn;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado a la base de datos.");
            Statement sentence = conn.createStatement();
            sentence.execute(sql);
            System.out.println("Tabla Email registrada.");
                    
        } catch (SQLException e){
            System.out.println("Error al trabajar en la BD: " + e.getMessage());
        }
    }
}
