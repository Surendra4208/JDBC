import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Date; 
class Register extends Frame implements ActionListener
{
  Label l1,l2,l3,l4;
  TextField t1,t2,t3,t4;
  Button b;
 Register() 
 {
  setSize(300,300);
  setVisible(true);
  setLayout(new FlowLayout());

l1=new Label("Enter Roll No");
l2=new Label("Enter Name");
l3=new Label("Enter Branch");
l4=new Label("Enter DOB");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(20);
t4=new TextField(20);

b=new Button("Register");

add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(l4);
add(t4);
add(b);
b.addActionListener(this);
 }
public void actionPerformed(ActionEvent e)
{
 try
 {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  PreparedStatement stm=con.prepareStatement("insert into Student4208 values(?,?,?,?)");

 String Roll_No=t1.getText();
String Name=t2.getText();
String Branch=t3.getText();
String dob=t4.getText();

Date date=Date.valueOf(dob);

 stm.setString(1,Roll_No);
 stm.setString(2,Name);
 stm.setString(3,Branch);
 stm.setDate(4,date);

stm.executeUpdate();

System.out.println("Records Inserted");
}
catch(Exception ex)
 {
 System.out.println(ex);
 }
}
public static void main(String args[])
{
  new Register();
  }
}