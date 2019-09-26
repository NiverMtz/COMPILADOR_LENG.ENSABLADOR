
package compiladorasc_v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Edward Hunter */

public class fileProcessor { // THIS CLASS IS GOING TO BE USED AT THE MAIN FUNCT, SO WE CAN PROCESSS OUR FILE, AND PROCESS IT ACORDING TO ITS FORM.
    
    BufferedReader bufferFile;
            
    public fileProcessor (File sourceCode) throws FileNotFoundException{ // CREATES THE OBJECT FOR FILE READING AND PROCESSING 
        this.bufferFile = new BufferedReader(new FileReader(sourceCode));
    }
    
    
    public void processBuffer(){
        
        try {
            String line;
            while ((line = this.bufferFile.readLine()) != null) { 
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(fileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print("The file is damaged");
        }
    
    }
    
}
