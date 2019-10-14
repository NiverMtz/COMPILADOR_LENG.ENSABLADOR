package compiladorasc_v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
/* @author niver */

public class CompiladorASC_v01 {
    public static void main(String[] args) {
        File file = new File("mnemos_bytes.txt");
        LinkedList lnporln = new LinkedList();
        //int i = 1; //Variable no utilizada
        try {
            FileProcessor process = new FileProcessor(file);
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
            process.manipularLineapoorLinea(lnporln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file couldn't found");
        }
    }
}
