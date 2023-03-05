import java.sql.*;
class Connect
{
 public static void main(String args[])
{
 try
 {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  System.out.println("Driver Loaded\n");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  System.out.println("Connection Established");
  Statement st=con.createStatement();
 //st.executeUpdate("create table Student4208(Roll_No varchar(20),Name varchar(20),Branch varchar(10),DOB date)");
 //System.out.println("Table Created");
  //st.executeUpdate("drop table Student4208");
  st.executeUpdate("insert into Student4208 values('4211','Nani','CSM','11-March-2021')");
  //System.out.println("Insertion 1 Done");
 String sql1="insert into Student4208 values('4212','Sai Pallavi','CSE','22-June-2023')";
  st.executeUpdate(sql1);
//System.out.println("Insertion 2 Done");
  String sql2="insert into Student4208 values('4213','Anasawara','CSM','19-March-2020')";
  st.executeUpdate(sql2);
  //System.out.println("Insertion 3 Done");
 }
 catch(Exception e)
 {
 System.out.println(e);
 }
}
}