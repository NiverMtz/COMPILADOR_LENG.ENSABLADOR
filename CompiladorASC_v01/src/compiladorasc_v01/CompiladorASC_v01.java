package compiladorasc_v01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
/* @author niver */

public class CompiladorASC_v01 {

    public static void main(String[] args) {

        /*File file = new File("EXEMPLO.ASC");
        int i = 1;

        //String input = " LDAA #$25";
        LinkedList lnporln = new LinkedList();

        try {
            FileProcessor process = new FileProcessor(file);
            process.manipularLineapoorLinea(lnporln);
            
            for(Object e : lnporln){
                System.out.println(i++);
                Inmediato.reconocerIMM((String) e);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompiladorASC_v01.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file couldn't found");
        }*/
        
        File file = new File("S_I_MC68.txt");
        
        try {
            FileProcessor process = new FileProcessor(file);
            
            /*Se van probando comandos uno a uno para ver que se valide que se encuentran dentro del archivo,
            con esto ya tenemos la parte del error 004: Mnemonico inexistente*/
            System.out.println("¿Está 'aba'? R: "+process.processBuffer_containsMnemo("aba",file));
            System.out.println("¿Está 'jmp'? R: "+process.processBuffer_containsMnemo("jmp",file));
            System.out.println("¿Está 'ldaa'? R: "+process.processBuffer_containsMnemo("ldaa",file));
            System.out.println("¿Está 'sbca'? R: "+process.processBuffer_containsMnemo("sbca",file));
            System.out.println("¿Está 'xgdy'? R: "+process.processBuffer_containsMnemo("xgdy",file));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file couldn't found");
        }
    }
    
    /*public static boolean validarIMM(String linea){
        return linea.matches("^[ ]{1,}[A-Za-z]{1,5}[ ]{1,}\\#\\$([A|B|C|D|E|F]|[0-9]){1,4}$");
        //return linea.matches("[^#]*\\#[^#]*\\$([A|B|C|D|E|F]|[0-9]){1,4}");
    }*/

}
