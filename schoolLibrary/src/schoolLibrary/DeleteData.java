package schoolLibrary;
import java.sql.*;
public class DeleteData {

	 public static void main( String args[] ) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "DELETE from LIBRARY where ID=2;";
	         stmt.executeUpdate(sql);
	         c.commit();

	         ResultSet rs = stmt.executeQuery( "SELECT * FROM LIBRARY;" );
	         
	         while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         String  book = rs.getString("book");
	         int isbn = rs.getInt("isbn");
	         
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "BOOK = " + book );
	         System.out.println( "ISBN = " + isbn );
	         System.out.println();
	         
	         ResultSet a;
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }
	}