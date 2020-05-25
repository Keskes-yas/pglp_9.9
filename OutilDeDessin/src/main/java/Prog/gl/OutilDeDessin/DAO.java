package Prog.gl.OutilDeDessin;
import java.sql.Connection;
import java.sql.SQLException;


public abstract class DAO<T> {
	
	protected Connection connectDB = null;
	
	  public DAO(Connection c){
	    this.connectDB = c;
	  }
	  
	 
	  	public abstract boolean create(T obj);
	  	
	 
	  	public abstract boolean delete(T obj);
	  	
	  
	  	public abstract boolean update(T obj) throws SQLException;
	  	
	  	
	  	public abstract T find(String name) throws SQLException;


}
