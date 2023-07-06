package com.bookstoreui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Helper {

    public Properties propertyReader(String path){
        try {
            FileInputStream ip=new FileInputStream(new File(path));
            Properties prop=new Properties();
            prop.load(ip);
            return prop;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String createFolder(String direc){
//        String reportFolder=System.getProperty("user.dir")+direc;
        File f=new File(direc);
        if(!f.exists()){
            System.out.println(f.mkdirs());
        }
        return direc;
    }

    public String getCurrentTimestamp(){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        return timeStamp;
    }
}
