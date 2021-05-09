import java.sql.*;

public class JDBCDaoDemo {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        FriendsDAO Dao = new FriendsDAO();
        Friend friend = Dao.getFriend("jay");
        System.out.println(friend.name + " " + friend.userName + " " + friend.password);

    }
}

class FriendsDAO {
    Friend friend = new Friend();
    String url = "jdbc:mysql://localhost:3306/ADMINS";
    String user = "root";
    String password = "vnhmhJi#7ms"; 

    Friend getFriend(String name) throws ClassNotFoundException, SQLException {
        String query = "select * from users where userName = ?;";
        // com.mysql.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stm = con.prepareStatement(query);
        stm.setString(1, name);
        ResultSet rs = stm.executeQuery();
        rs.next();
        friend.name = rs.getString(1);
        friend.userName = name;
        friend.password = rs.getString(3);
        return friend;
    }
}

class Friend {
    String userName;
    String name;
    String password;
}
