package Test;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class Employee {
	private Connection con=null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
	Employee()throws IOException,SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reshma","root","Reshma@123");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		for(;;)
		{
		System.out.println("\n **Menu** \n 1. Create \n 2. Insert \n 3. Update \n4. Selection \n 5. Delete \n");
		System.out.println("Enter Your choice :");
		int ch = Integer.parseInt(br.readLine());
		switch(ch)
		{
		case 1:
		{
			System.out.println("enter Query to create table:");
			String q1 = br.readLine();
			st=con.createStatement();
			st.execute(q1);
			System.out.println("query executed successfully");
			break;
			
		}
		case 2:
		{
			System.out.println("Enter query to insert table :");
			String q2 = br.readLine();
			pst = con.prepareStatement(q2);
			pst.executeUpdate();
			System.out.println("query executed successfully");
			break;

		}
		case 3:
		{
			System.out.println("Enter query for update :");
			String q3 = br.readLine();
			st = con.createStatement();
			st.executeUpdate(q3);
			System.out.println("query executed successfully");
			break;
		}
		case 4:
		{
			System.out.println("Enter query to delete :");
			String q4 = br.readLine();
			st = con.createStatement();
			st.executeUpdate(q4);
			System.out.println("query executed successfully");

			break;
		}
		case 5:
		{
			System.out.println("Enter query for selection:");
			String q5 = br.readLine();
			st= con.createStatement();
			rs=st.executeQuery(q5);
			displayResult(rs);
			
		}
		default :
			System.out.println(0);
		}
		
	}
	}
	public static void main(String args[]) throws ClassNotFoundException, IOException, SQLException, NullPointerException {
		final Employee em = new Employee();
		System.out.println("Menu \n 1. Create \n 2.Insert \n 3. Delete \n");
		
	}
	private void displayResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		 ResultSet rs1 = rs;
		 ResultSetMetaData rsm = rs1.getMetaData();
		 int col= rsm.getColumnCount();
		 int count =1 ;
		 boolean b = rs1.next();
		 if(!b) {
			 System.out.println("Data not founs ");
		 }
		 else
			 do {
				 System.out.println("Record " + (count++) + "=>");
				 for(int i=0;i<col;i++) {
				 System.out.println(rs1.getString(i+1));
				 System.out.println(" ");
				 }
			 }while(rs1.next());
		 
		 
		  
	}
	

}
