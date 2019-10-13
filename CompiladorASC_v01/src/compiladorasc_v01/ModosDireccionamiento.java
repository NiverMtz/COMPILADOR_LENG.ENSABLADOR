/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiladorasc_v01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RojasCastilloOscar-RocoElWuero
 */
public class ModosDireccionamiento {
    //http://tutorials.jenkov.com/java-regex/index.html#escaping-characters
    static String comentario="\\ {0,}\\*.{1,}";
    public static int devolverComent(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile(comentario);
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        if(mat_1.matches()) {
            return 0;
        }
    return -1;
    }
    /*
        2) Inmediata (IMM) -------------- # y operando 8 o 16 bits
            LDAA #$25
            LDX  #$1789
    */
    public static int devolverImm(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5}[ ]{1,}\\#\\$[A-F|a-f|0-9]{1,4}"+comentario+"[ ]{0,}$");
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5}[ ]{1,}\\#\\$[A-F|a-f|0-9]{1,4}[ ]{0,}$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()) {
            return 1;
        }
    return -1;
    }
    /*
        3) Directo (DIR) ---------------- operando de 8 bits
            LDAA $25
    */
    public static int devolverDir(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Z]{1,5}[ ]{1,}[$][A-Z|0-9]{1,2}[ ]{0,}$");
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Z]{1,5}[ ]{1,}[$][A-Z|0-9]{1,2}"+comentario+"$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()){
        return 2;
        }
    return -1; 
    }
    /*
        5) Indexado (IND, X) o (IND, Y) - operando de 8 bits, seguido de una ',' y una 'x' o 'y'
            LDAA $25,X
            LDY $2C,Y
    */
    public static int devolverIndX(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {1,}\\$[a-f|A-F|0-9]{1,4}\\,[X|x] {0,}$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {1,}\\$[a-f|A-F|0-9]{1,4}\\,[X|x]"+comentario+"$");
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()) {
            return 3;
        }
    return -1;
    }
    public static int devolverIndY(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {1,}\\$[a-f|A-F|0-9]{1,4}\\,[Y|y] {0,}$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {1,}\\$[a-f|A-F|0-9]{1,4}\\,[Y|y]"+comentario+"$");
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()) {
            return 4;
        }
    return -1;
    }
    /*
        4) Extendido (EXT) -------------- operando de 16 bits
            LDAA $257C
    */
    public static int devolverExt(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Z]{1,5}[ ]{1,}[$][A-Z|0-9]{1,4}[ ]{0,}$");
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Z]{1,5}[ ]{1,}[$][A-Z|0-9]{1,4}"+comentario+"$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()){
        return 5;
        }
    return -1; 
    }
    /*
        Inherente (INH) -------------- carece de signo operando
            NOP
    */
    public static int devolverInh(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {0,}$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5}"+comentario+"$");
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        Pattern pat_3 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {0,}[$][A-Z|0-9]{1,4}[ ]{0,}$");
        Pattern pat_4 = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5} {0,}[$][A-Z|0-9]{1,4}[ ]{0,}"+comentario+"$");
        Matcher mat_3 = pat_3.matcher(lineaArchivo);
        Matcher mat_4 = pat_4.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()) {
            return 6;//Todo en orden
        }else if(mat_3.matches() || mat_4.matches()){
            return 600;// Error: 006. Instrucción no lleva operandos
        }
    return -1;//El usuario está pendejo "No sirves para nada"
    }
    public static int devolverRel(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[ ]{1,}[A-Z|a-z]{1,5}[ ]{1,}[A-Z|a-z|0-9]{1,}[ ]{0,}$");
        Pattern pat_2 = Pattern.compile("^[ ]{1,}[A-Z|a-z]{1,5}[ ]{1,}[A-Z|a-z|0-9]{1,}"+comentario+"$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()){
            return 7;
        }
    return -1;
    }
    public static int devolverEtiq(String lineaArchivo) {
        Pattern pat_1 = Pattern.compile("^[A-Z|a-z|0-9]{1,}[ ]{0,}$");
        Pattern pat_2 = Pattern.compile("^[A-Z|a-z|0-9]{1,}[ ]{0,}$"+comentario+"$");
        Matcher mat_1 = pat_1.matcher(lineaArchivo);
        Matcher mat_2 = pat_2.matcher(lineaArchivo);
        if(mat_1.matches() || mat_2.matches()){
            return 8;
        }
    return -1;
    }
}
