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
    public static int devolverImm(String lineaArchivo) {
        Pattern pat = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5}[ ]{1,}\\#\\$[A-F|a-f|0-9]{1,4}[ ]{0,}\\*[ ]{0,}[A-Z|a-z|0-9| ]*[ ]{0,}$");
        Matcher mat = pat.matcher(lineaArchivo);
        if(mat.matches()) {
            return 1;
        }
    return -1;  
    }
    public static int devolverDir(String lineaArchivo) {
    return -1; 
    }
    public static int devolverIndX(String lineaArchivo) {
    return -1;
    }
    public static int devolverIndY(String lineaArchivo) {
    return -1;
    }
    public static int devolverExt(String lineaArchivo) {
    return -1;
    }
    public static int devolverInh(String lineaArchivo) {
    return -1;
    }
    public static int devolverRel(String lineaArchivo) {
    return -1;
    }
}
