package schoolLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main( String args[] ) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " +
	                        "VALUES (1, 'Amy', 'A for apple', 00101 );"; 
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " +
                     "VALUES (2, 'Billy', 'B for boy', 00102 );"; 
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " +
                     "VALUES (3, 'Carlos', 'C for cat', 00103 );"; 
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " +
                     "VALUES (4, 'David', 'D for Dog', 00104 );"; 
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }
	}