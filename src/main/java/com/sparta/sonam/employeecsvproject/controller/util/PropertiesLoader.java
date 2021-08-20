package com.sparta.sonam.employeecsvproject.controller.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties(){
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/database.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
