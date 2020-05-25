package Prog.gl.OutilDeDessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD {
	
	 Connection connection ;

	public BDD() throws SQLException {
		this.connection = getConnection();
	}
	/*fermeture de la BDD*/
	public void Deconnexion() throws SQLException
	{
		 DriverManager.getConnection("jdbc:hsqldb:file:BDD/Outil;shutdown=true", "ufr", "ufr");

	}
	 /*configuration*/
	private static Connection getConnection() throws SQLException {
	    	return DriverManager.getConnection("jdbc:hsqldb:file:BDD/Outil", "ufr", "ufr");   
	    }
	    
	 /*créer toutes les tables*/
	public void bddTables() throws SQLException
	{
	    Statement statement = connection.createStatement();
	    statement.execute("CREATE TABLE IF NOT EXISTS  dessin (nom VARCHAR(50))");
	    statement.execute("CREATE TABLE IF NOT EXISTS cercle (nom VARCHAR(50), x INT, y INT, rayon INT, dessin_id VARCHAR(50))");
	    statement.execute("CREATE TABLE IF NOT EXISTS  triangle (nom VARCHAR(50), x1 INT, y1 INT,x2 INT, y2 INT,x3 INT, y3 INT, dessin_id VARCHAR(50))");
	    statement.execute("CREATE TABLE IF NOT EXISTS rectangle (nom VARCHAR(50), x INT, y INT, a INT, b INT, dessi_id VARCHAR(50))");
	    statement.execute("CREATE TABLE IF NOT EXISTS  carre ( nom VARCHAR(50), x INT, y INT, a INT, dessin_id VARCHAR(50))");
	  
	        
	}
	/*suppr toutes les tables*/
	public void supprTables() throws SQLException
	{
		Statement statement = connection.createStatement();
		statement.execute("DROP TABLE dessin");
		statement.execute("DROP TABLE cercle");
		statement.execute("DROP TABLE triangle");
		statement.execute("DROP TABLE rectangle");
		statement.execute("DROP TABLE carre");   
	        
	}
	

	
	

}
