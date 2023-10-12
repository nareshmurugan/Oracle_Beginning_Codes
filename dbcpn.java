import java.sql.*;  
class dbcpn{  
    public static void main(String args[]){  
        try{  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","oracle");  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from employee");  
        System.out.println(rs.getClass().getSimpleName()+"      "+rs.next());

        while(rs.next())  System.out.println(rs.getInt("emp_id")+"  "+rs.getString("emp_name"));  
            
        con.close();  
        
        }catch(Exception e){ System.out.println(e);}  
  
    }  
}  