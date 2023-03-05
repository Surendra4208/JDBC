import java.sql.*;
class Select
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
 //String sql1="update Student4208 set Name='Virat' where Roll_No='4212'";
//String sql1="select * from Student4208";
String sql1="delete from Student4208 where Name='sss'";

 ResultSet rs=st.executeQuery(sql1);
//getting the record of thirst row
//to fetch records
/*while(rs.next())
{
  System.out.println(rs.getString(1));
  System.out.println(rs.getString(2));
  System.out.println(rs.getString(3));
 
}*/
}
 catch(Exception e)
 {
 System.out.println(e);
 }
}
}