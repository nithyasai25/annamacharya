import java.sql.*;
class JDBCSelect{
public static void main(String[] args){
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=
 DriverManager.getConnection(
 "jdbc:oracle:thin:@localhost:1521:XE","system","admin");
Statement stmt=con.createStatement();
String sQuery="select *from aitsgoogle";
ResultSet rs=stmt.executeQuery(sQuery);
int i=1;
while(rs.next()){
System.out.println("Google Employee:"+i);
System.out.println("********************");
 System.out.print("ID:"+rs.getString("empid")+"\t");
 System.out.print("Name:"+rs.getString("empname")+"\t");
 System.out.print("Designation:"+rs.getString("empdes")+"\n");
i++;
}
}
 catch(ClassNotFoundException e){
e.printStackTrace();
}
 catch(SQLException e){
 e.printStackTrace();
}
}
}