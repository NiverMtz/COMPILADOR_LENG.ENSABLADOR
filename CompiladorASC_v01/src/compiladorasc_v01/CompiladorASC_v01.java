package compiladorasc_v01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author niver */

public class CompiladorASC_v01 {

   
    public static void main(String[] args) {
        
        File file = new File("/Users/UsuarioInvitado/pro.asc");
        try {
            
            fileProcessor process= new fileProcessor(file);
            process.processBuffer();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompiladorASC_v01.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file couldn't found");
        }
        
    }
    
}
