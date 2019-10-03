/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorasc_v01;
import java.util.regex.*;

/**
 *
 * @author niver
 */
public class Inmediato {
    
    public static void reconocerIMM(String input){
        Pattern p;
        Matcher m;
        p = Pattern.compile("#");
        m = p.matcher(input);

        if (m.find()) {
            System.out.println("Modo inmediato");
        }
    } 
    
}
