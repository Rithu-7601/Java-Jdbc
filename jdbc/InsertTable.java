package jdbc;


import java.sql.Connection;
import java.sql.Statement;

public class InsertTable {
    public static void main(String[] args) throws Exception {
        Connection con = ConnectionFactory.getDbConnection();

        Statement st = con.createStatement();

        //String sql ="insert into emp(empno,ename,salary) values(105,'Jojo',4578.98)";
        String sql ="insert into emp(empno,ename,salary) values(102,'Mojo',888.98),(103,'Hojo',788.98),(106,'Vojo',688.98)";

        try {
            st.executeUpdate(sql);
            System.out.println("Database table created!");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }

        st.close();
        con.close();



    }
}
