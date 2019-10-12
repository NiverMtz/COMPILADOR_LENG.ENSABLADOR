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
        /*if(lineaFuenteArchivo.matches("^ {1,}"+regex+"$") == true) {
            System.out.println(i+lineaFuenteArchivo);//LISTO, ya reconoce la expresión shida
        }
        //Puede haber espacio(s) que haya escrito por accidente al final
        if (lineaFuenteArchivo.matches("^ {1,}"+regex+" {1,}$") == true) {
            System.out.println(i+lineaFuenteArchivo);//LISTO, ya reconoce la expresión no tan shida
        }
        //Asterisco pegado a la instrucción
        //http://tutorials.jenkov.com/java-regex/index.html#escaping-characters
        if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\*") == true) {
            System.out.println(i+lineaFuenteArchivo);//Listo, ya encuentra el * pegado
        }
        //Asterisco separado con un(os) espacio(s) a la instrucción
        if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\ {1,}\\*") == true) {
            System.out.println(i+lineaFuenteArchivo);//Listo, ya encuentra el * separado (espacio(s))
        }
        //Comentario pegado
        if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\*[A-Z|a-z|0-9||\\!|\"|\\#|\\$|\\%|\\&|\\/|\\(|\\)|\\=|\\?|\\¡|\\°|\\¨|\\´|\\+|\\*|\\{|\\[|\\}|\\]|\\,|\\;|\\.|\\:|\\-|\\_|\\ ]{1,}") == true) {
            System.out.println(i+lineaFuenteArchivo);//LISTO, ya reconoce el comentario pegado y los caracteres especiales
        }
        //Comentario con un espacio antes
        if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\ {1,}\\*[A-Z|a-z|0-9||\\!|\"|\\#|\\$|\\%|\\&|\\/|\\(|\\)|\\=|\\?|\\¡|\\°|\\¨|\\´|\\+|\\*|\\{|\\[|\\}|\\]|\\,|\\;|\\.|\\:|\\-|\\_|\\ ]{1,}") == true) {
            System.out.println(i+lineaFuenteArchivo); //LISTO, ya reconoce el espacio
        }*/
        Pattern pat = Pattern.compile("^[ ]{1,}[A-Za-z]{1,5}[ |[\\*(|A-Z|a-z|0-9||\\!|\"|\\#|\\$|\\%|\\&|\\/|\\(|\\)|\\=|\\?|\\¡|\\°|\\¨|\\´|\\+|\\*|\\{|\\[|\\}|\\]|\\,|\\;|\\.|\\:|\\-|\\_|\\ ){0,}]]{0,}$");
        Matcher mat = pat.matcher(lineaArchivo);
        if(mat.matches()) {
            return 1;
        }
    return -1;
    }
    public static int devolverRel(String lineaArchivo) {
    return -1;
    }
}
