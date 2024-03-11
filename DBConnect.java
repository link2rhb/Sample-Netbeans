/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sahil
 */
public class DBConnect {
    Connection con=null;
    
    public Connection getConnect(){
        try {
            String url="jdbc:mysql://localhost:3306/Sample?autoReconnect=true&useSSL=false";
            String user="root";
            String password="1234";
            con = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public int getCount(){
        int total=0;
        try {            
            Statement st;
            Connection cn;
            cn = getConnect();
            st = cn.createStatement();
            String str ="select Count(Sid) from students";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                total = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (total+1);
    }
}
