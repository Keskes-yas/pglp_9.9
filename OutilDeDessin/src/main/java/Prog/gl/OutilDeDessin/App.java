package Prog.gl.OutilDeDessin;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Hello world!
 *
 */
public class App 
{
	
  
	public static void main( String[] args ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		/*init DB*/
		BDD plug_db = new BDD() ;
		plug_db.bddTables();
		
		/*Test*/
		Udessin d1 = new Udessin("dessin1");
		Udessin d2 = new Udessin("dessin2");
		Udessin d3 = new Udessin("dessin3");
		
		
        Triangle t1 =  new Triangle("tri1", 2 , 1 , 2 , 5 , 7 , 8 , "dessin1");
        Carre cr1 = new Carre("car1", 50, 70, 5, "");
        Cercle c1 = new Cercle("c1", 10, 9, 10, "dessin2");
        Rectangle r1 = new Rectangle("r1", 78, 23, 12, 8, "dessin1");
        Cercle c2 = new Cercle("c2", 100, 90, 1, "dessin1");
        
        d1.ajoutForme(c2);
        d1.ajoutForme(t1);
        d1.ajoutForme(r1);
        
        
     
       UdessinDAO dao = new UdessinDAO(plug_db.connection);
       CercleDAO co = new CercleDAO(plug_db.connection);
      
       
       dao.create(d1);  
       
      
       System.out.println(co.find("c2").toString());
       plug_db.connection.commit();
	  
        plug_db.Deconnexion();
    }
}
