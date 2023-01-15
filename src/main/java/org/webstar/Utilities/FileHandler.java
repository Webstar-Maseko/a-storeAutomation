package org.webstar.Utilities;

import java.io.File;
import java.io.FileWriter;

public class FileHandler {

    public static void writeToFile(String path,String data){
        try {
            File file = new File(path);
            FileWriter fr = new FileWriter(file,true);
            fr.write(data);
            fr.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
