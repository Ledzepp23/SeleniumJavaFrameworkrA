import java.sql.*;

public class DbConnection {

    String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
    String user = "root";
    String password = "password";

    public void testConnection() {
        try {
            Connection myConn = DriverManager.getConnection(url,user,password);
            Statement myStat = myConn.createStatement();
            String sql = "select * from test.t_user";
            ResultSet rs = myStat.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("USERNAME   "));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}
