import java.sql.*;

import java.util.*;
import java.io.*;
import java.awt.*;

public class DBConnection {
	private String	driverName	= "com.mysql.jdbc.Driver";
	private String	url		= "jdbc:mysql://localhost:3306/";
	private String	database	= "gelato";
	private String	username	= "root";
	private String	password	= "";
        
        public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

	public static Connection getConnection(){
            
                if (instance == null) {
                    instance = new DBConnection();
                }
                
		try{
                        Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(instance.getUrl()
                                                        + instance.getDatabase(),
                                                         instance.getUsername(),
                                                            instance.getPassword());
		}catch( Exception e){
			System.out.println("Can't Connect");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String getUrl() {
        return url;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public boolean isCorrectPassword(String password) {
        return password.equals(this.password);
    }

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
