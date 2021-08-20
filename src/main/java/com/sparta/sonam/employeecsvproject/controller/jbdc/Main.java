package com.sparta.sonam.employeecsvproject.controller.jbdc;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger("Main");
    public static void main( String[] args ) {
        Loader.readFile();
        Loader.writeFile();
    }
}
