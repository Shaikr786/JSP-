package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Metadata {
	public static void main(String args[]) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reshma","root","Reshma@123");
			Statement st = con.createStatement();
			String sql = "Select * from people";
			
			ResultSet rs =st.executeQuery(sql);
			ResultSetMetaData rsm = rs.getMetaData();
			int rowCount = rsm.getColumnCount();
			System.out.println("Table name:"+rsm.getTableName(1));
			System.out.println("\nField \t size \t DataType \t");
			for(int i=0;i<rowCount;i++) {
				System.out.print(rsm.getColumnName(i+1)+"\t");
				System.out.print(rsm.getColumnDisplaySize(i+1)+"\t");
				System.out.println(rsm.getColumnTypeName(i+1)+"\t");
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
