package Prog.gl.OutilDeDessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDAO extends DAO<Triangle>{

	public TriangleDAO(Connection c) {
		super(c);
	}
	/*C R U D  COMMAND*/
	public boolean create(Triangle t) {
		
		boolean bool = false ;
		int result = 0 ;
		
		PreparedStatement ps;
		try {
				
				Triangle tr= find(t.getNom());
				
				if(tr == null )
				{
					ps = connectDB.prepareStatement(" INSERT INTO triangle VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
					ps.setString(1, t.getNom());
					ps.setInt(2, t.getX1());
					ps.setInt(3, t.getY1());
					ps.setInt(4, t.getX2());
					ps.setInt(5, t.getY2());
					ps.setInt(6, t.getX3());
					ps.setInt(7, t.getY3());
					ps.setString(8, t.getDessin_id());
					result = ps.executeUpdate();
				}else {
					return false ;
				}

			} catch (SQLException e) {
			e.printStackTrace();
		} 
			
		if(result == 1)
			bool = true ;
		return bool;
	}
	
/*DELETE*/
	public boolean delete(Triangle t) {
		boolean bool = false ; 
		int result = 0 ;
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("DELETE FROM triangle WHERE nom = ? ");
			ps.setString(1, t.getNom());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			
		if(result == 1)
			bool = true ;
		
		return bool;
	}

	/*UPDATE*/
	public boolean update(Triangle t) {
		boolean bool = false ;
		int result = 0 ;
		PreparedStatement ps;
		try {
				ps = connectDB.prepareStatement("UPDATE triangle SET x1 = ?, y1 = ?, x2 = ?, y2 = ?, x3 = ?, y3 = ?, dessin_id = ? WHERE nom = ? ");
				ps.setString(8, t.getNom());
				ps.setInt(1, t.getX1());
				ps.setInt(2, t.getY1());
				ps.setInt(3, t.getX2());
				ps.setInt(4, t.getY2());
				ps.setInt(5, t.getX3());
				ps.setInt(6, t.getY3());
				ps.setString(7, t.getDessin_id());
				
				result = ps.executeUpdate();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(result == 1)
			bool = true ;
		
		return bool;
	}
/*FIND*/
	public Triangle  find(String nom) {
		Triangle form = null ;

		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("SELECT * FROM triangle WHERE nom = ? ");
			ps.setString(1, nom);
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				int x1 = result.getInt("x1") ; 
				int y1 = result.getInt("y1") ;
				int x2 = result.getInt("x2") ; 
				int y2 = result.getInt("y2") ;
				int x3 = result.getInt("x3") ; 
				int y3 = result.getInt("y3") ;
				String dessin_id = result.getString("dessin_Id") ; 
		
				form = new Triangle(nom, x1, x2, x3, y1, y2, y3, dessin_id );
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return form;

	}

	

	











}
