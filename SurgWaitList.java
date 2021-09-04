package assignment1;
import java.sql.*;

public class SurgWaitList {
	Connection con = null;
	public SurgWaitList() {
		System.out.println("**********Surgical Waiting List**********");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_assignment","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void addPatient(String pname,String opType,int priority,String sname,String opDate,String disDate) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into waitlist value('"+pname+"','"+opType+"',"+priority+",'"+sname+"','"+opDate+"','"+disDate+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void display() {
		try {
			Statement st = con.createStatement();
			String qry = "select * from waitlist;";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("*******************************");
			while(rs.next()) {
				System.out.println("Patient Name: "+rs.getString(1));
				System.out.println("Type of Operation: "+rs.getString(2));
				System.out.println("Priority: "+rs.getInt(3));
				System.out.println("Surgeon Name: "+rs.getString(4));
				System.out.println("Operation Date: "+rs.getString(5));
				System.out.println("Discharge Date: "+rs.getString(6));
				System.out.println("*******************************");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void removePatient(String pname) {
		try {
			Statement st = con.createStatement();
			String qry = "delete from waitlist where pname='"+pname+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
