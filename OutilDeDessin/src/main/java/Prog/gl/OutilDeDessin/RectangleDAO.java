package Prog.gl.OutilDeDessin;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDAO extends DAO<Rectangle>{
	

	public RectangleDAO(Connection c) {
		super(c);
	}


	public boolean create(Rectangle r) {
		
		boolean bool = false ;
		int res = 0 ;
		
		PreparedStatement ps;
		
		try {
				Rectangle rectangle = find(r.getNom());
				if(rectangle == null )
				{
					ps = connectDB.prepareStatement(" INSERT INTO rectangle VALUES (?, ?, ?, ?, ?, ?) ");
					ps.setString(1, r.getNom());
					ps.setInt(2, r.getX());
					ps.setInt(3, r.getY());
					ps.setInt(4, r.getA());
					ps.setInt(5,  r.getB());
					ps.setString(6, r.getDessin_Id());
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
	

public boolean delete(Rectangle r) {
		boolean bool = false ; 
		int res = 0 ;
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("DELETE FROM rectangle WHERE nom = ? ");
			ps.setString(1, r.getNom());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	public boolean update(Rectangle r) {
		boolean bool = false ;
		int res = 0 ;
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("UPDATE rectangle SET x = ?, y = ?, a = ?, b = ?, dessin_id = ? WHERE nom = ? ");
			ps.setString(6, r.getNom());
			ps.setInt(1, r.getX());
			ps.setInt(2, r.getY());
			ps.setInt(3, r.getA());
			ps.setInt(4,  r.getB());
			ps.setString(5, r.getDessin_Id());

			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	public Rectangle  find(String nom) {
		Rectangle form = null ;
		
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("SELECT * FROM rectangle  WHERE nom = ? ");
			ps.setString(1, nom);
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				int x = res.getInt("x");
				int y = res.getInt("y");
				int a = res.getInt("a");
				int b = res.getInt("b");
				String dessin_id = res.getString("dessin_id");
				form = new Rectangle(nom, x, y, a, b, dessin_id);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return form;

	}


}
