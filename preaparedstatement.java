import java.util.Scanner;
import java.sql.*;
import java.sql.Date;  
class preaparedstatement
{
 public static void main(String args[])
{
 try
 {

   String Roll_No;
   String Name;
   String Branch;
   String dd;
Scanner sc=new Scanner(System.in);
System.out.println("Enter roll no");
Roll_No=sc.next();
System.out.println("Enter Name");
Name=sc.next();
System.out.println("Enter Branch");
Branch=sc.next();
System.out.println("Enter DOB");
dd=sc.next();
Date date=Date.valueOf(dd);//converting string into sql date 
  Class.forName("oracle.jdbc.driver.OracleDriver");
  System.out.println("Driver Loaded\n");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  System.out.println("Connection Established");
   String sql1="insert into Student4208 values(?,?,?,?)";
 //Create object for PreparedStatement by callin
 //connection.preparedStatement
  PreparedStatement stm=con.prepareStatement(sql1);
 stm.setString(1,Roll_No);
 stm.setString(2,Name);
 stm.setString(3,Branch);
 stm.setDate(4,date);
int i=stm.executeUpdate();
System.out.println(i+"Records Inserted");
con.close();
}
 catch(Exception e)
 {
 System.out.println(e);
 }
}
}