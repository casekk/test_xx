package Test;

import java.sql.*;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement state = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("���سɹ�");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ddt","root","123456");
            System.out.println("���ӳɹ�");

            state = con.createStatement();//���뽫SQL��䷢�͵����ݿ���
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
