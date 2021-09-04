package assignment1;
import java.sql.*;

public class Surgeon {
	Connection con = null;
	public Surgeon() {
		System.out.println("**********Surgeon**********");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_assignment","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void addSurgeon(String name,String spclty) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into surgeon value('"+name+"','"+spclty+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void display() {
		try {
			Statement st = con.createStatement();
			String qry = "select * from surgeon;";
			ResultSet rs= st.executeQuery(qry);
			System.out.println("*******************************");
			while(rs.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Specialty: "+rs.getString(2));
				System.out.println("*******************************");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void removeSurgeon(String name) {
		try {
			Statement st = con.createStatement();
			String qry = "delete from surgeon where name='"+name+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
