package assignment1;
import java.sql.*;

public class Referral {
	Connection con = null;
	public Referral() {
		System.out.println("**********Referral List**********");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_assignment","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void addRef(String pname,String date,int priority,String sname,String appDate) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into referral value('"+pname+"','"+date+"',"+priority+",'"+sname+"','"+appDate+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void display() {
		try {
			Statement st = con.createStatement();
			String qry = "select * from referral;";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("*******************************");
			while(rs.next()) {
				System.out.println("Patient Name: "+rs.getString(1));
				System.out.println("Date: "+rs.getString(2));
				System.out.println("Priority: "+rs.getInt(3));
				System.out.println("Surgeon Name: "+rs.getString(4));
				System.out.println("Appointment Date: "+rs.getString(5));
				System.out.println("*******************************");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void removeRef(String pname) {
		try {
			Statement st = con.createStatement();
			String qry = "delete from referral where pname='"+pname+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	void updateAppDate(String pname,String appDate) {
		try {
			Statement st = con.createStatement();
			String qry = "update referral set appdate='"+appDate+"'where pname='"+pname+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
