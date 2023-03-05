import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Search extends Frame implements ActionListener
{
  Label l1;
  TextField t1;
  Button b;
int x;
 Search() 
 {
  setSize(300,300);
  setVisible(true);
  setLayout(new FlowLayout());

l1=new Label("Enter Roll No");

t1=new TextField(20);

b=new Button("Search");

add(l1);
add(t1);

add(b);
b.addActionListener(this);
 }
public void actionPerformed(ActionEvent e)
{
 try
 {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  PreparedStatement stm=con.prepareStatement("select * from Student4208 where Roll_No=?");

 String Roll_No=t1.getText();

 stm.setString(1,Roll_No);

ResultSet rs=stm.executeQuery();
while(rs.next())
{
  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4) );
x++;
 }

if(x==0)
{
 System.out.println("Record Not Found");
 }
}
catch(Exception ex)
 {
 System.out.println(ex);
 }
}
public static void main(String args[])
{
  new Search();
  }
}