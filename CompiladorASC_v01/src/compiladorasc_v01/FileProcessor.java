
package compiladorasc_v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* @author Edward Hunter */

public class FileProcessor { // THIS CLASS IS GOING TO BE USED AT THE MAIN FUNCT, SO WE CAN PROCESSS OUR FILE, AND PROCESS IT ACORDING TO ITS FORM.
    
    BufferedReader bufferFile;
            
    public FileProcessor (File sourceCode) throws FileNotFoundException{ // CREATES THE OBJECT FOR FILE READING AND PROCESSING 
        this.bufferFile = new BufferedReader(new FileReader(sourceCode));
    }
    
    //Este sólo lee el el archivo linea por linea
    public void processBuffer(){
        
        try {
            String line;
            while ((line = this.bufferFile.readLine()) != null) { 
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }
    
    }
    
    //Valida el patrón de los mnemónicos con una regex
    public static boolean mnemoPattern(String line) {
        Pattern pat = Pattern.compile("[a-z]{1,5}.*");//Se propone el patrón a buscar en las lineas
        Matcher mat = pat.matcher(line);//valida que ese patrón esté ne la cadena
    return mat.matches();//regresa un booleano si la encontró ese patrón
    }
    
    //Valida que dentro de el archivo fileMnemos exista el nemónico
    public boolean processBuffer_containsMnemo(String mnemo, File fileMnemos) throws FileNotFoundException {
        BufferedReader bufferFile_Mnemos = new BufferedReader(new FileReader(fileMnemos));//Se crea una valiable local para el archivo porque sino marcaba error
        boolean p = false;//bandera
            try {
            String line;
            while ((line = bufferFile_Mnemos.readLine()) != null) { 
                p = true;//Si encuentra el nemonico va a modificar la bandera
            }
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }
    return p;//retorno de bandera
    }
    
    //Este puede quedar inutlizado, pero valida se trata de convertir cada linea del archivo a un indice dentro de una lista
    public LinkedList manipularLineapoorLinea(LinkedList l){
        try {
            String line;
            while ((line = this.bufferFile.readLine()) != null) { 
                l.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }
        return l;
    }
    
}
