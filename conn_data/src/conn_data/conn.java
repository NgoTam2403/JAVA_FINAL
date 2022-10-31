package conn_data;

import java.sql.*;
public class conn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/music";
            String user      = "root";
            String password  = "24032002";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null)
                {
                    System.out.println("connect");
                    conn.close();
                }

            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    
	}

}
