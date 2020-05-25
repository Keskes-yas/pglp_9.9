package Prog.gl.OutilDeDessin;

import java.sql.Connection;

public class DAOFactory {
	
	
	public static DAO<Carre> getSquareDAO(Connection connect){
		
		return new CarreDAO(connect);
	}
	
	public static DAO<Cercle> getCircleDAO(Connection connect){
		
		return new CercleDAO(connect);
	}
	
	public static DAO<Rectangle> getRectangleDAO(Connection connect){
		
		return new RectangleDAO(connect);
	}
	
	public static DAO<Triangle> getTriangleDAO(Connection connect){
		
		return new TriangleDAO(connect);
	}
	
	
	
}
