
package database;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private String	driverName	= "com.mysql.jdbc.Driver";
	private String	url		= "jdbc:mysql://localhost:3306/";
	private String	database	= "gelato";
	private String	username	= "root";
	private String	password	= "";
   private static DBConnection instance;
        
        public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    private static Connection connect;

    public static void initialize() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gelato"; //insert schema name
        String user = "root";
        String pass = "password";
        connect = null;

        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, pass);
            System.out.println("SUCCESSFULLY CONNECTED");
        } catch (Exception ex) {
            System.out.println("ERROR CONNECT");
        }

    }

    public static Connection getConnection() {
    	if (connect == null){
    		initialize();
    	}
        return connect;
    }
}