package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedTest {
    public static void main(String[] args) throws Exception {
        Connection con = ConnectionFactory.getDbConnection();

        Scanner sc = new Scanner(System.in);
        PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");

        String req = "Y";
        while(req.equalsIgnoreCase("Y")){
            System.out.println("enter empno: ");
            int eno = sc.nextInt();
            System.out.println("enter name: ");
            String name = sc.next();
            System.out.println("enter salary: ");
            float sal = sc.nextFloat();

            try{
                pst.setInt(1,eno);
                pst.setString(2,name);
                pst.setFloat(3,sal);

                int n = pst.executeUpdate();
                System.out.println("employee saved");
                pst.clearParameters();
            }catch(Exception e){
                System.out.println(e.toString());
            }
            System.out.println("do you want to save more employees[y/n]");
            req = sc.next();
        }
        sc.close();
        con.close();

    }
}
