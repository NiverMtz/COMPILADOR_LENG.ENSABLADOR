
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorasc_v01;

/**
 *
 * @author RojasCastilloOscar-RocoElWuero
 */
//import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
//import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        String regex=null;
        //File file = new File(args[0]);
        /*
        Tomemos un ejemplo - que usted desea convertir el número decimal 453 en hexadecimal.
        Paso 1 - Divide 453 por 16. El resultado es dos valores como: relación resto = 5 y = 28.
        Paso 2 - ¿Cómo residuo que es menor que 5 a 9. Tomando el dígito menos significativo como 5.
        Paso 3 - Divide 28 por 16. El resultado es dos valores: resto y cociente = 12 = 1.
        Paso 4 - ¿Cómo residuo es de entre 10 y 15, entonces el dígito significativo penúltima es C.
        Paso 5 - Divide 1 a 16. Es el resultado de dos valores como: resto y cociente = 1 = 0.
        Paso 6 - ¿Cómo cociente es 0 paradas proceso de división y resto es 1. Por lo tanto, el número hexadecimal se evalúa resto a la inversa. En este caso, el resto de evaluación fue de 5 -> C -> 1. Por lo tanto, en nuestro ejemplo es el hexadecimal 453 1C5.
        */
        Map<String, Integer> coleccionInherente = new HashMap<>();
        coleccionInherente.put("aba", 27);
        coleccionInherente.put("abx", 58);
        coleccionInherente.put("aby", 6202);
        coleccionInherente.put("asla", 72);
        coleccionInherente.put("aslb", 88);
        coleccionInherente.put("asld", 5);
        coleccionInherente.put("asra", 71);
        coleccionInherente.put("asrb", 87);
        coleccionInherente.put("cba", 17);
        coleccionInherente.put("clc", 12);
        coleccionInherente.put("cli", 14);
        coleccionInherente.put("clra", 79);
        coleccionInherente.put("clrb", 95);
        coleccionInherente.put("clv", 10);
        coleccionInherente.put("coma", 67);
        coleccionInherente.put("comb", 83);
        coleccionInherente.put("daa", 25);
        coleccionInherente.put("deca", 74);
        coleccionInherente.put("decb", 90);
        coleccionInherente.put("des", 52);
        coleccionInherente.put("dex", 9);
        coleccionInherente.put("dey", 6153);
        coleccionInherente.put("fdiv", 3);
        coleccionInherente.put("idiv", 2);
        coleccionInherente.put("inca", 76);
        coleccionInherente.put("incb", 92);
        coleccionInherente.put("ins", 49);
        coleccionInherente.put("inx", 8);
        coleccionInherente.put("iny", 6152);
        coleccionInherente.put("lsla", 72);
        coleccionInherente.put("lslb", 88);
        coleccionInherente.put("lsld", 5);
        coleccionInherente.put("lsra", 68);
        coleccionInherente.put("lsrb", 84);
        coleccionInherente.put("lsrd", 4);
        coleccionInherente.put("mul", 61);
        coleccionInherente.put("nega", 64);
        coleccionInherente.put("negb", 80);
        coleccionInherente.put("nop", 1);
        coleccionInherente.put("psha", 54);
        coleccionInherente.put("pshb", 55);
        coleccionInherente.put("pshx", 60);
        coleccionInherente.put("pshy", 6204);
        coleccionInherente.put("pula", 50);
        coleccionInherente.put("pulb", 51);
        coleccionInherente.put("pulx", 56);
        coleccionInherente.put("puly", 6200);
        coleccionInherente.put("rola", 73);
        coleccionInherente.put("rolb", 89);
        coleccionInherente.put("rora", 70);
        coleccionInherente.put("rorb", 86);
        coleccionInherente.put("rti", 59);
        coleccionInherente.put("rts", 57);
        coleccionInherente.put("sba", 16);
        coleccionInherente.put("sec", 13);
        coleccionInherente.put("sei", 15);
        coleccionInherente.put("sev", 11);
        coleccionInherente.put("stop", 207);
        coleccionInherente.put("swi", 63);
        coleccionInherente.put("tab", 22);
        coleccionInherente.put("tap", 6);
        coleccionInherente.put("tba", 23);
        coleccionInherente.put("tets", 0);
        coleccionInherente.put("tpa", 7);
        coleccionInherente.put("tsta", 77);
        coleccionInherente.put("tstb", 93);
        coleccionInherente.put("tsx", 48);
        coleccionInherente.put("tsy", 6192);
        coleccionInherente.put("txs", 53);
        coleccionInherente.put("tys", 6197);
        coleccionInherente.put("wai", 62);
        coleccionInherente.put("xgdx", 143);
        coleccionInherente.put("xgdy", 6287);
        Map<String, Integer> coleccionInmediata = new HashMap<>();
        Map<String, Integer> coleccionDirecto = new HashMap<>();
        Map<String, Integer> coleccionExtendido = new HashMap<>();
        Map<String, Integer> coleccionIndexado = new HashMap<>();
        Map<String, Integer> coleccionRelativo = new HashMap<>();

        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String lineaFuenteArchivo;
            int i=0;
            while((lineaFuenteArchivo = br.readLine()) != null) { //Leyendo el archivo
                i++;
                /*
                    0) Comentario al inicio
                        *vedsvsaevdsdev
                        *LDAA $25,X   
                        *LDAA $257C
                */
                /*
                    1) Inherente (INH) -------------- carece de signo operando
                        NOP
                */
                for (Map.Entry<String, Integer> entry : coleccionInherente.entrySet()) { //http://www.instanceofjava.com/2018/01/java-8-stream-foreach-array-examples.html
                    //EN MINUSCULAS
                    regex=entry.getKey();
                    if(lineaFuenteArchivo.matches("^ {1,}"+regex+"$") == true) { //La sintáxis más sencilla
                        System.out.println(i+lineaFuenteArchivo);//LISTO
                    }
                    if (lineaFuenteArchivo.matches("^ {1,}"+regex+" {1,}$") == true) { //Puede haber espacio(s) que haya escrito por accidente al final
                        System.out.println(i+lineaFuenteArchivo);//LISTO
                    }
                    if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\*$") == true) { //Puede haber solamente un * despues de la instrucción
                        System.out.println(i+lineaFuenteArchivo);//ERROR, no lo reconoce
                    }
                    //http://tutorials.jenkov.com/java-regex/index.html#escaping-characters
                    if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\*[A-Za-z0-9_]{1,}$") == true) { //Puede haber un comentario despues de la instrucción
                        System.out.println(i+lineaFuenteArchivo);//ERROR, falta los caracteres especiales en un comentario
                    }
                    if (lineaFuenteArchivo.matches("^ {1,}"+regex+"\\ {1,}\\*[A-Za-z0-9_]{1,}$") == true) { //Puede haber un espacio(s) y luego el comentario despues de la instrucción
                        System.out.println(i+lineaFuenteArchivo); //ERROR, no reconoce el espacio
                    }
                    //EN MAYUSCULAS
                    regex = regex.toUpperCase(); //https://techlandia.com/reemplazar-minusculas-mayusculas-java-como_252901/
                    if(lineaFuenteArchivo.matches("^ {1,}"+regex+"$") == true) {
                        System.out.println(i+lineaFuenteArchivo);
                    }
                    if (lineaFuenteArchivo.matches("^ {1,}"+regex+" {1,}$") == true) { //Puede haber espacios que haya escrito por accidente al final
                        System.out.println(i+lineaFuenteArchivo);
                    }
                    //System.out.println(regex);
                    regex=null;//Vaciar la expresión regular, por si acaso
                }    //https://jarroba.com/map-en-java-con-ejemplos/        pero para HashMap<Integer, String>
                /*
                    2) Inmediata (IMM) -------------- # y operando 8 o 16 bits
                        LDAA #$25
                        LDX  #$1789
                */
                /*
                    3) Directo (DIR) ---------------- operando de 8 bits
                        LDAA $25
                    4) Extendido (EXT) -------------- operando de 16 bits
                        LDAA $257C
                    5) Indexado (IND, X) o (IND, Y) - operando de 8 bits, seguido de una ',' y una 'x' o 'y'
                        LDAA $25,X
                    6) Relativo (REL) --------------- operando en su etiqueta
                */
            }
            fr.close();
        } catch(Exception e) {
            System.out.println("Error");
        }
    }
}