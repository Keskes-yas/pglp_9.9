package Prog.gl.OutilDeDessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDAO extends DAO<Carre>{
	


	public CarreDAO(Connection c) {
		super(c);
	}


	public boolean create(Carre s) {
		
		boolean bool = false ;
		int res = 0 ;
		
		PreparedStatement ps;
		try {
				Carre sq= find(s.getNom());
				
				if(sq == null )
				{
					ps = connectDB.prepareStatement(" INSERT INTO Carre VALUES (?, ?, ?, ?, ?) ");
					ps.setString(1, s.getNom());
					ps.setInt(2, s.getX());
					ps.setInt(3, s.getY());
					ps.setInt(4, s.getA());
					ps.setString(5, s.getDessin_Id());
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
	

	public boolean delete(Carre s) {
		boolean bool = false ; 
		int res = 0 ;
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("DELETE FROM Carre WHERE nom = ? ");
			ps.setString(1, s.getNom());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	public boolean update(Carre s) {
		boolean bool = false ;
		int res = 0 ;
		PreparedStatement ps;
		try {
				ps = connectDB.prepareStatement("UPDATE Carre SET x = ?, y = ?, a = ?, dessin_id = ? WHERE name = ? ");
				ps.setString(5, s.getNom());
				ps.setInt(1, s.getX());
				ps.setInt(2, s.getY());
				ps.setFloat(3, s.getA());
				ps.setString(4, s.getDessin_Id());
				

				res = ps.executeUpdate();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	public Carre  find(String nom) {
		Carre form = null ;
		
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("SELECT * FROM Carre WHERE name = ? ");
			ps.setString(1, nom);
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				int x = res.getInt("x") ; 
				int y = res.getInt("y") ;
				int a = res.getInt("a");
				String dessin_id = res.getString("dessin_id");				
				form = new Carre(nom, x, y, a, dessin_id);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return form;

	}


}