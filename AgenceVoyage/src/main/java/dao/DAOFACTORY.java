package dao;

import java.sql.*;

public class DAOFACTORY {
DAOFACTORY() {	
		
    }

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agence?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String mdp = "Mhafidi2000:";
			conn=DriverManager.getConnection(url,user,mdp);
			System.out.println("connexion établie !!! ");
		}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
}
		return conn;
	}
}
