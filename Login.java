import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends Frame implements ActionListener
{
int x;
  Label l1,l2;
  TextField t1,t2;
  Button b;
 Login() 
 {
  setSize(300,300);
  setVisible(true);
  setLayout(new FlowLayout());

l1=new Label("Enter Username:");
l2=new Label("Enter Password");

t1=new TextField(20);
t2=new TextField(20);

b=new Button("Login");

add(l1);
add(t1);
add(l2);
add(t2);

add(b);
b.addActionListener(this);
 }
public void actionPerformed(ActionEvent e)
{
 try
 {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  PreparedStatement stm=con.prepareStatement("select * from login_08 where Username=? and Password=? ");

 String Username=t1.getText();
String Password=t2.getText();

 stm.setString(1,Username);
 stm.setString(2,Password);
stm.execute();
ResultSet rs=stm.executeQuery();
while(rs.next())
{

  System.out.println("Login Successful");
x++;
 }

if(x==0)
{
 System.out.println("Login Unsuccessful");
 }
}


catch(Exception ex)
 {
 System.out.println(ex);
 }
}
public static void main(String args[])
{
  new Login();
  }
}