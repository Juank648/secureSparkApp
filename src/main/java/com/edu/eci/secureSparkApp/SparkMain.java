package com.edu.eci.secureSparkApp;

import static spark.Spark.*;

public class SparkMain {
    public static void main(String[] args) {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), "123456", null, null);
        //port(5000);
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku!!!");
        //Spark get method
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    static String getKeyStore() {
        if (System.getenv("PORT") != null) {
            return String.valueOf(Integer.parseInt(System.getenv("KEYSTORE")));
        }
        return "keystore/ecikeystore.p12"; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}
