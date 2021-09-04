package assignment1;
import java.sql.*;

public class Patient {
	Connection con = null;
	public Patient() {
		System.out.println("**********Patient**********");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_assignment","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void addPatient(String name,String dob,String gender) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into patient value('"+name+"','"+dob+"','"+gender+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void display() {
		try {
			Statement st = con.createStatement();
			String qry = "select * from patient;";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("*******************************");
			while(rs.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("DOB: "+rs.getString(2));
				System.out.println("Gender: "+rs.getString(3));
				System.out.println("*******************************");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void removePatient(String name) {
		try {
			Statement st = con.createStatement();
			String qry = "delete from patient where name='"+name+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
