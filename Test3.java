package Test;

import java.sql.*;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement state = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载成功");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ddt","root","123456");
            System.out.println("链接成功");

            state = con.createStatement();//用与将SQL语句发送到数据库中
            String sql = "select * from bbt";
            ResultSet res = state.executeQuery(sql);

            while(true){
                String id = res.getString("id");
                System.out.println("id"+id);
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
