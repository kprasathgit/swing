package com.mkp.hotelroombooking.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DatabaseConnection {

	public static Connection dbconn;
	public static Connection tranconn;

	private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

	public DatabaseConnection() {

		try {

			String masterDbConnectionUrl ="jdbc:sqlserver://krish.database.windows.net:1433;database=mkp;user=adminkrish@krish;password=Danger@#4321;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=15;";
			String tranDbConnectionUrl = "jdbc:sqlserver://krish.database.windows.net:1433;database=transac;user=adminkrish@krish;password=Danger@#4321;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=15;";
			dbconn = dbCOnnection(masterDbConnectionUrl);
			logger.info("master connection established");
//			masterConn.close();
//			logger.info("master connection closed");

			tranconn = dbCOnnection(tranDbConnectionUrl);
			logger.info("transaction connection established");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	private Connection dbCOnnection(String dBConnectionUrl) {

		try {

			return DriverManager.getConnection(dBConnectionUrl);

		} catch (SQLException e) {
			
			if (isInternetConnectionIssue(e)) {	
				JOptionPane.showMessageDialog(null, "Internet Connection issue: Check Internet connection");
				
				System.exit(0);

			} else {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.exit(0);
			}
		}
		return null;

	}


	private static boolean isInternetConnectionIssue(SQLException e) {
		// Check if the SQLException message or SQLState indicates a network-related
		// issue
		String sqlState = e.getSQLState();
		String errorMessage = e.getMessage();

		// Example: Azure SQL Server error code for no internet connection is "08S01"
		return "08S01".equals(sqlState) || errorMessage.toLowerCase().contains("no route to host");
	}

}