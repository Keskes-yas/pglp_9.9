package Prog.gl.OutilDeDessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDAO extends DAO<Cercle> {

	public CercleDAO(Connection c) {
		super(c);
	}
	

/*C R U D   C O M M A N D*/
	public boolean create(Cercle c) {
		
		boolean bool = false ;
		int res = 0 ;	
		PreparedStatement ps;
		try {
				Cercle cc= find(c.getNom());
				
				if(cc == null )
				{
					ps = connectDB.prepareStatement(" INSERT INTO cercle VALUES (?, ?, ?, ?, ?) ");
					ps.setString(1, c.getNom());
					ps.setInt(2, c.getX());
					ps.setInt(3, c.getY());
					ps.setInt(4, c.getRayon());
					ps.setString(5, c.getDessin_Id());
					
					res = ps.executeUpdate();
				}else {
					return false ;
				}

			
			} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}
	

	public boolean delete(Cercle c) {
		boolean bool = false ; 
		int res = 0 ;
		PreparedStatement ps;
		try {
			/*SQL REQUETE*/
			ps = connectDB.prepareStatement("DELETE FROM cercle WHERE name = ? ");
			ps.setString(1, c.getNom());
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		return bool;
	}
	
	
	/*
	 * UPDATE 
	 * */

	public boolean update(Cercle c) {
		boolean bool = false ;
		int res = 0 ;
		PreparedStatement ps;
		try {
				ps = connectDB.prepareStatement("UPDATE cercle SET x = ?, y = ?, rayon = ?, dessin_id = ? WHERE nom = ? ");
				ps.setString(5, c.getNom());
				ps.setInt(1, c.getX());
				ps.setInt(2, c.getY());
				ps.setInt(3, c.getRayon());
				ps.setString(4, c.getDessin_Id());
				

				res = ps.executeUpdate();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}
	/*
	 * READ
	 */
	
	public Cercle  find(String nom) {
		Cercle form = null ;
		
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("SELECT * FROM cercle WHERE nom = ? ");
			ps.setString(1, nom);
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				int x = res.getInt("x") ; 
				int y = res.getInt("y") ;
				int rayon = res.getInt("rayon") ;
				String dessin_id = res.getString("dessin_id");				
				form = new Cercle(nom, x, y, rayon, dessin_id) ;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return form;

	}



	


}
