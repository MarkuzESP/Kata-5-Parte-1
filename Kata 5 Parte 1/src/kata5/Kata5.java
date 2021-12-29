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
        String sql = "SELECT * FROM PEOPLE";
        Connection conn;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado a la base de datos");
            Statement sentence = conn.createStatement();
            ResultSet rs = sentence.executeQuery(sql);
            
            while (rs.next()){
                System.out.println(rs.getInt("Id") + "\t" +
                        rs.getString("Nombre") + "\t" +
                        rs.getString("Apellidos") + "\t" +
                        rs.getString("Depto") + "\t");
            }
            
        } catch (SQLException e){
            System.out.println("Error al trabajar en la BD: " + e.getMessage());
        }
    }
}
