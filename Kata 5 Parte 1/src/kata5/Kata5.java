package kata5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marcos del Cristo Díaz Gil
 * Ingeniería del Software 2, Universidad de Las Palmas de Gran Canaria
 */
public class Kata5 {
    public static void main(String[] args){
        String fileRoute = "C:\\Users\\Usuario\\Desktop\\Proyectos IS2 GitHub\\Kata-5-parte-1\\Kata 5 Parte 1\\email.txt";
        String url = "jdbc:sqlite:Prueba.db";
        // Como el ID es autoincremental, sólo se destaca el campo "Correo".
        String sql = "INSERT INTO EMAIL(Correo) VALUES(?)";
        // Se leen los valores del fichero de texto plano
        MailListReader lectorFichero = new MailListReader();

        List<String> listOfMails; // Puede generar IOException
        Connection conn;
        
        try{
            listOfMails = lectorFichero.read(fileRoute);
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conectado a la base de datos.");
            PreparedStatement sentence = conn.prepareStatement(sql);
            Iterator<String> lector = listOfMails.iterator();
            System.out.println("Introduciendo valores de correos.");
            while (lector.hasNext()){
                sentence.setString(1, lector.next());
                sentence.executeUpdate();
            }
            System.out.println("Tareas completadas.");
                    
        } catch (SQLException e){
            System.out.println("Error al trabajar en la BD: " + e.getMessage());
        } catch (IOException error) {
            System.out.println("Fallo de entrada/Salida: " + error.getMessage());
        } 
    }
}
