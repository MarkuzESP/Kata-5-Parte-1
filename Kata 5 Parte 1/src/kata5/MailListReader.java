package kata5;

/**
 * Se toma esta clase de Kata 4 y se hacen ligeros cambios 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<String> read (String fileName) throws FileNotFoundException,
            IOException{
        List<String> listOfMails = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader
        (new FileReader(new File(fileName)))){
            String correo;
            // Mientras se puedan leer correos
            while((correo=reader.readLine()) != null){
                // Si una entrada carece de '@' puede descartarse como posible
                // dirección de correo
                if(!correo.contains("@")){
                    continue;
                }
                listOfMails.add(new String(correo));
            }
        }
        return listOfMails;
    }
}
