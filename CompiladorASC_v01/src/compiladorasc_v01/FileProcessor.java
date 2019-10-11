
package compiladorasc_v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* @author Edward Hunter */
public class FileProcessor { // THIS CLASS IS GOING TO BE USED AT THE MAIN FUNCT, SO WE CAN PROCESSS OUR FILE, AND PROCESS IT ACORDING TO ITS FORM.

    BufferedReader bufferFile;
    FileReader source;
    
    public FileProcessor(File sourceCode) throws FileNotFoundException { // CREATES THE OBJECT FOR FILE READING AND PROCESSING 
      this.source=new FileReader(sourceCode);
      this.bufferFile = new BufferedReader(new FileReader(sourceCode));
    }

    public void processBuffer() {

        try {
            String line;
            try (PrintWriter writer = new PrintWriter("temp.asc", "UTF-8")) {
                while ((line = this.bufferFile.readLine()) != null) {

                    writer.println(line.toUpperCase());

                }

            }
            
            this.bufferFile= new BufferedReader(this.source);
            
            while ((line = this.bufferFile.readLine()) != null) {
                String s = line;
                if (s.contains("EQU")) {
                    String[] words = s.split("\\W+");
                    String key = words[0];
                    //String address = '$' + words[2];
                    String address = words[2];
                    System.out.println("REPLACING: " + key + " BY: " + address);
                    modifyFile(key, address);

                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }

    }

    static void modifyFile(String key, String address) throws FileNotFoundException, IOException {  // THIS METHOD REPLACE ALL THE KEYWORDS BY THE ADDRESS OF EACHV VARIABLE 

        // Path path = Paths.get("/Users/UsuarioInvitado/pro.asc");
        Path path = Paths.get("temp.asc");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll(key, "\\$" + address);
        Files.write(path, content.getBytes(charset));

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
    
            /*
                Son los índices a los que correspone cada modo de ireccionamiento, una vez que se convierte
                la cadena del archivo 'file_1', que contiene todos los opCodes de cada modo de direccionamiento
                para cada mnemónico. El nemónico sirve como una llave para acceder a lo demás
            
                mnemo (Key)    = 0
                opCode (IMM)   = 1
                opCode (DIR)   = 2
                opCode (IND,X) = 3
                opCode (IND,Y) = 4
                opCode (EXT)   = 5
                opCode (INH)   = 6
                opCode (REL)   = 7 
            */
    
    
    /*Convierte en un array de String cada linea para poder acceder a cada índice como si fuera un diccionario y
    obtener el Opcode y los Bytes permitidos para cada modo por mnemónico*/
    public static String convertLineToArray (String line, int index_mod) {
            String[] aux = line.split("[|]");//Separa la linea cada que encuentra el símbolo "|" y los que está antes y después lo convierte en una posición del arreglo.
    return aux[index_mod];//regresa la palabra en la posición especificada, tal que podemos acceder como si fuera un diccionario.
    }
    
    /*
        Este método valida que al pasarle el nemónico que se está buscando, el archivo y un índice, tal que este
        último se refiere al índice del arreglo en que se convierte cada cadena que vamos leyendo del archivo que
        contiene los mnemónicos y sus respectivos opCode's por cada modo de direccionamiento
    */
    public String processBuffer_opCode(String mnemo, File fileMnemos, int index)  throws FileNotFoundException {
        String aux = null;//variable auxiliar
        try {
            String line;
            while ((line = this.bufferFile.readLine()) != null) {
                if(mnemo.equals(convertLineToArray(line,0))){//valida que la llave o mnemónico sea igual al que se solicita en el argumento del método
                    aux = convertLineToArray(line,index);//Si es igual, guarda la palabra que correponda al modo de direccionamiento, según su índice en el arreglo.
                } 
            }
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }
    return aux;//retorno de variable auxiliar con la palabra de nuestro diccionario de mnemónicos y sus códigos.
    }
    
    
    /*public String processBuffer_Bytes(String mnemo, File fileMnemos) {
        
    }*/
    
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
