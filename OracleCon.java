import java.sql.*;

class OracleCon {
  
    public static void main( String...  args ) throws Exception {
        
          //step-1: load the jdbc driver (optional)
        Class.forName("oracle.jdbc.driver.OracleDriver");
          System.out.println("Driver is loaded......");

         
         //step-2: establish connection
         String databaseURL = "jdbc:oracle:thin:@localhost:1521:XE";
         String username = "system";
         String password = "123456789";
         Connection conn = DriverManager.getConnection(databaseURL, username, password);
         System.out.println("connection is established.......");
  
         //step-3: create Statement object
         Statement  stmt = conn.createStatement();
         System.out.println("Staement object is created..........");

         // step-4: execute the sql query
         
         String query = "DELETE FROM STUDENT  VALUES( 7818, 'JACK', 'A')";
         int count = stmt.executeUpdate(query);
         System.out.println("insert query is executed ");
       
         //step-5: process the result
         System.out.println( count + " row inserted...........");
         
         String query1 = "SELECT * FROM STUDENT";
         
          ResultSet resultSet = stmt.executeQuery(query1);
          
          System.out.println("\nResult set:");
          while(resultSet.next()) {
             int id = resultSet.getInt("ROLL_NO");
             String name = resultSet.getString("STUDENT_NAME");
             String grade = resultSet.getString("SECTION");
             System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
          }
          
          
          
          System.out.println();
         //step-6: close the connection
         stmt.close();
         conn.close();
         resultSet.close();
         System.out.println("connection is closed..........");
    }

	
}
