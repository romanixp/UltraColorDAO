package test.compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
 
 
public class ObtenerFechaHora {
 
 public static void main ( String args[] ) {
   
  Date fecha1 = new Date ();
   
  System.out.println(fecha1.toString());
   
  // Segun la versión utilizada de Java, los dos siguientes
  // metodos pueden estar deprecated
  System.out.println(fecha1.toLocaleString());
  System.out.println(fecha1.toGMTString());
     System.out.println(fecha1.getDate());
   
  Calendar cal1 = Calendar.getInstance();
     System.out.println(cal1.toString());
    System.out.println(""+cal1.get(Calendar.DATE)+"/"+cal1.get(Calendar.MONTH)
    +"/"+cal1.get(Calendar.YEAR)+" "+cal1.get(Calendar.HOUR)
    +":"+cal1.get(Calendar.MINUTE)+":"+cal1.get(Calendar.SECOND)
    +":"+cal1.get(Calendar.MILLISECOND));   
    
    float total = 0;
    total+=12.3443;
     System.out.println(total);
    
    /****OTRO EJEMPLO ****/
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
       // Class.forName("com.mysql.jdbc.Driver");
    //    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "pauloguerra");
         
        java.util.Date dtc = new java.util.Date();
        java.text.SimpleDateFormat sdfc = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String yyyymmdd = sdf.format(dtc);
         
//        PreparedStatement ps = cn.prepareStatement("insert into Factura(fecha,fechaCorta) values(?,?)");
//        ps.setString(1, fechaHora);
//        ps.setString(2, yyyymmdd);
//        ps.executeUpdate();
    
    
    
    
    
 }
}