package org.webstar.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    Properties prop;
    public Properties init_Prop(){
        try{
            FileInputStream file = new FileInputStream("./src/test/resources/Config/config.properties");
            prop = new Properties();
            prop.load(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return prop;
    }
}
