import java.sql.*;
import java.util.Scanner;

public class SelectQuery {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded......");

		String databseUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "123456789";

		Connection con = DriverManager.getConnection(databseUrl, username, password);

		System.out.println("connection is established.....");

		Statement st = con.createStatement();

		System.out.println("ststement obj is created.....");

//		String query1 = "DELETE FROM STUDENT WHERE ROLL_NO = 103";
//
//		int count = st.executeUpdate(query1);
//
//		System.out.println(count + " rows is effected..");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter rollno :");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("enter student name: ");
		String sname = sc.nextLine();
		
		
		System.out.println("enter section: ");
		String section = sc.nextLine();
		
		
		
		
		String query1 = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		
		PreparedStatement ps = con.prepareStatement(query1);
        ps.setInt(1, id);
        ps.setString(2, sname);
        ps.setString(3, section);
        
        
        ps.executeQuery();
		
		String query = "SELECT * FROM STUDENT";

		ResultSet rs = st.executeQuery(query);

		/*
		 * rs.next(); System.out.println(rs.getInt("ROLL_NO"));
		 * System.out.println(rs.getString("STUDENT_NAME"));
		 * System.out.println(rs.getString("SECTION"));
		 * 
		 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
		 * System.out.println(rs.getString(3));
		 * 
		 * rs.next();
		 * 
		 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
		 * System.out.println(rs.getString(3));
		 */

		while (rs.next()) {

			int rno = rs.getInt("ROLL_NO");
			String name = rs.getString("student_name");
			String sec = rs.getString("section");

			System.out.println("ROLLNO: " + rno + ", NAME: " + name + ", SECTION: " + sec);

		}
		
		st.close();
        con.close();
        ps.close();
        

	}

}
