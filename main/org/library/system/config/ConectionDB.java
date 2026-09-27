package org.library.system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {

    private static final String URL =
            "jdbc:mysql://" + Enviroment.LOCAL_HOST + "/" + Enviroment.DATA_BASE
                    + "?useSSL=false"
                    + "&serverTimezone=UTC"
                    + "&allowPublicKeyRetrieval=true";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, Enviroment.USER, Enviroment.PASSWORD);
    }
}