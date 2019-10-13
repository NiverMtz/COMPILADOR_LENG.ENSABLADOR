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

        File file = new File("temp.asc");
        LinkedList lnporln = new LinkedList();
        int i = 1;
        //fghjgfghj
        /*String input = "       LDAA  ORDEN             * NEW LINE ";
        System.out.println("Es IMM?: ");
        System.out.println(input);
        System.out.println(ModosDireccionamiento.devolverImm(input));*/
        
        //LinkedList lnporln = new LinkedList();
        /*try {
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
        
        //File file_1 = new File("mnemos_opCode.txt");
        //File file_2 = new File("mnemos_bytes.txt");
        
        try {
            FileProcessor process = new FileProcessor(file);
            //LinkedList aux = process.manipularLineapoorLinea(lnporln);
            //System.out.println("Que es?: "+ aux.get(60).toString());
            //int t = ModosDireccionamiento.devolverImm(aux.get(60).toString());
            //System.out.println("Q s?: "+ t);
            /*Se van probando comandos uno a uno para ver que se valide que se encuentran dentro del archivo,
            con esto ya tenemos la parte del error 004: Mnemonico inexistente*/
            /*System.out.println("¿Está 'aba'? R: "+process.processBuffer_containsMnemo("aba",file_1));
            System.out.println("¿Está 'jmp'? R: "+process.processBuffer_containsMnemo("jmp",file_1));
            System.out.println("¿Está 'ldaa'? R: "+process.processBuffer_containsMnemo("ldaa",file_1));
            System.out.println("¿Está 'sbca'? R: "+process.processBuffer_containsMnemo("sbca",file_1));
            System.out.println("¿Está 'xgdy'? R: "+process.processBuffer_containsMnemo("xgdy",file_1));
            
            System.out.println("¿Está 'aba'? R: "+process.processBuffer_containsMnemo("aba",file_2));
            System.out.println("¿Está 'jmp'? R: "+process.processBuffer_containsMnemo("jmp",file_2));
            System.out.println("¿Está 'ldaa'? R: "+process.processBuffer_containsMnemo("ldaa",file_2));
            System.out.println("¿Está 'sbca'? R: "+process.processBuffer_containsMnemo("sbca",file_2));
            System.out.println("¿Está 'xgdy'? R: "+process.processBuffer_containsMnemo("xgdy",file_2));*/
            
            /*
                Convierte la cadena en un array que va separando las palabras mediante el símbolo "|",
                luego te regresa la palabra que se encuentra en la posición del índice especificado
            */
            //String aux = FileProcessor.convertLineToArray("tba|-|-|-|-|-|16|-", 2);
            //System.out.println("opCode: "+aux);
            
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
            //System.out.println("opCode: " + process.processBuffer_opCode("ldab",file_1,4));
            process.manipularLineapoorLinea(lnporln);
            for(Object e : lnporln){
                System.out.println(i++);
                String tempS = e.toString();
                System.out.println(tempS);
                int result = ModosDireccionamiento.devolverExt(tempS);
                System.out.println(result);
                
                
                //System.out.println("-------------------");
                
                //process.processBuffer();
                
                
            }
            
            
            
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
