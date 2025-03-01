package com.identity.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileMgr {

    private static Properties properties = null;
    private static final String data_dir = "data_bank.properties";

    public static String getSettings(String keyName) {
        if(properties != null)
            return properties.getProperty(keyName);
        properties = new Properties();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/"+ data_dir;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(keyName);

    }
}
