package Prog.gl.OutilDeDessin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UdessinDAO extends DAO<Udessin>{

	public UdessinDAO(Connection c) {
		super(c);
	}
	


	public boolean create(Udessin c) {
		
		boolean bool = false ;
		int res = 0 ;
		
		PreparedStatement ps;
		try {
				
				Udessin sq= find(c.nomDessin);
				
				if(sq == null )
				{
					ps = connectDB.prepareStatement(" INSERT INTO dessin VALUES (?) ");
					ps.setString(1, c.nomDessin);
					res = ps.executeUpdate();
			
				}
					
				/* sauvegerder tout les element d'un dessin*/
				
				for (FormeGeometrique formeGeometrique : c.getFormes()) {
					
					
					
					if(	formeGeometrique.Type().equals("Cercle") ) 
						{	
							CercleDAO cd = new CercleDAO(connectDB);
							
							if ( cd.find(((Cercle)formeGeometrique).getNom() ) == null  )
								cd.create(((Cercle)formeGeometrique));
							else
								cd.update(((Cercle)formeGeometrique));
						
							
							
						}else if(formeGeometrique.Type().equals("Carre"))
						{
							CarreDAO cd = new CarreDAO(connectDB);
								
							if ( cd.find(((Carre)formeGeometrique).getNom() ) == null  )
								cd.create(((Carre)formeGeometrique));
							else
								cd.update(((Carre)formeGeometrique));
							
						}else if(formeGeometrique.Type().equals("Rectangle"))
						{
							RectangleDAO cd = new RectangleDAO(connectDB);
								
							if ( cd.find(((Rectangle)formeGeometrique).getNom() ) == null  )
								cd.create(((Rectangle)formeGeometrique));
							else
								cd.update(((Rectangle)formeGeometrique));
							
						}else if(formeGeometrique.Type().equals("Triangle"))
						{
							TriangleDAO cd = new TriangleDAO(connectDB);
								
							if ( cd.find(((Triangle)formeGeometrique).getNom() ) == null  )
								cd.create(((Triangle)formeGeometrique));
							else
								cd.update(((Triangle)formeGeometrique));
							
						}
				}
	
				} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}
	
	

	public boolean delete(Udessin t) {
		boolean bool = false ; 
		int res = 0 ;
		
		PreparedStatement ps;
		try {
			ps = connectDB.prepareStatement("DELETE FROM dessin WHERE nom = ? ");
			ps.setString(1, t.nomDessin);
			res = ps.executeUpdate();
			if (! t.getFormes().isEmpty() )
			{
				for (FormeGeometrique formeGeometrique : t) {
					
					if(	formeGeometrique.Type().equals("Cercle") ) 
					{	
						CercleDAO cd = new CercleDAO(connectDB);
						
						if ( cd.find(((Cercle)formeGeometrique).getNom() ) != null  )
							cd.delete(((Cercle)formeGeometrique));
						
						
					}else if(formeGeometrique.Type().equals("Carre"))
					{
						CarreDAO cd = new CarreDAO(connectDB);
							
						if ( cd.find(((Carre)formeGeometrique).getNom() ) != null  )
							cd.delete(((Carre)formeGeometrique));
						
						
					}else if(formeGeometrique.Type().equals("Rectangle"))
					{
						RectangleDAO cd = new RectangleDAO(connectDB);
							
						if ( cd.find(((Rectangle)formeGeometrique).getNom() ) != null  )
							cd.delete(((Rectangle)formeGeometrique));
						
						
					}else if(formeGeometrique.Type().equals("Triangle"))
					{
						TriangleDAO cd = new TriangleDAO(connectDB);
							
						if ( cd.find(((Triangle)formeGeometrique).getNom() ) != null  )
							cd.delete(((Triangle)formeGeometrique));
						
						
					}
	

				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}
	

	public boolean update(Udessin t) throws SQLException {
		boolean bool = false ;
		int res = 0 ;
		
		for (FormeGeometrique formeGeometrique : t) {
			
			if(	formeGeometrique.Type().equals("Cercle") ) 
			{	
				CercleDAO cd = new CercleDAO(connectDB);
				
				if ( cd.find(((Cercle)formeGeometrique).getNom() ) != null  )
					cd.update(((Cercle)formeGeometrique));
				
				
			}else if(formeGeometrique.Type().equals("Carre"))
			{
				CarreDAO cd = new CarreDAO(connectDB);
					
				if ( cd.find(((Carre)formeGeometrique).getNom() ) != null  )
					cd.update(((Carre)formeGeometrique));
				
				
			}else if(formeGeometrique.Type().equals("Rectangle"))
			{
				RectangleDAO cd = new RectangleDAO(connectDB);
					
				if ( cd.find(((Rectangle)formeGeometrique).getNom() ) != null  )
					cd.update(((Rectangle)formeGeometrique));
				
				
			}else if(formeGeometrique.Type().equals("Triangle"))
			{
				TriangleDAO cd = new TriangleDAO(connectDB);
					
				if ( cd.find(((Triangle)formeGeometrique).getNom() ) != null  )
					cd.update(((Triangle)formeGeometrique));
				
			}

			
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	public Udessin  find(String nom) {
		Udessin form = null ;
		
		
		PreparedStatement ps;
		
		try {
			
			ps = connectDB.prepareStatement("SELECT * FROM dessin WHERE nom = ? ");
			ps.setString(1, nom);
			ResultSet res = ps.executeQuery();
						
			
			if(res.next()) {
				System.out.println();
				
				form =  new Udessin(nom);
				
				ps = connectDB.prepareStatement("SELECT * FROM cercle WHERE dessin_id = ? ");
				ps.setString(1, nom);
				ResultSet res2 = ps.executeQuery();
				
				while (res2.next() ) {
						
					int x = res.getInt("x") ; 
					int y = res.getInt("y") ;
					int rayon = res.getInt("rayon") ;
					String dessin_id = res.getString("dessin_id");					
					Cercle c = new Cercle(nom, x, y, rayon, dessin_id) ;
					form.ajoutForme(c);
	
					}
				
				
				ps = connectDB.prepareStatement("SELECT * FROM carre WHERE dessin_id = ? ");
				ps.setString(1, nom);
				res2 = ps.executeQuery();
				
				while (res2.next() ) {
					
					int x = res.getInt("x") ; 
					int y = res.getInt("y") ;
					int a = res.getInt("a");
					String dessin_id = res.getString("dessin_id");
					Carre s = new Carre(nom, x, y, a, dessin_id);
					form.ajoutForme(s);
		
				}
				
				ps = connectDB.prepareStatement("SELECT * FROM rectangle WHERE dessin_id = ? ");
				ps.setString(1, nom);
				res2 = ps.executeQuery();
				
				while (res2.next() ) {
					
					int x = res.getInt("x");
					int y = res.getInt("point_y");
					int a = res.getInt("side");
					int b = res.getInt("secondSide");
					String dessin_id = res.getString("dessin_id");
					Rectangle r = new Rectangle(nom, x, y, a, b, dessin_id);
					
					form.ajoutForme(r);
					
		
				}
				
				ps = connectDB.prepareStatement("SELECT * FROM triangle WHERE dessin_id = ? ");
				ps.setString(1, nom);
				res2 = ps.executeQuery();
				
				while (res2.next() ) {
					
					int x1 = res.getInt("x1") ; 
					int x2 = res.getInt("x2") ; 
					int x3 = res.getInt("x") ; 
					int y1 = res.getInt("y1") ; 
					int y2 = res.getInt("y2") ; 
					int y3 = res.getInt("y3") ; 
					String dessin_id = res.getString("dessin_id") ; 
					Triangle r = new Triangle(nom, x1, x2, x3, y1, y2, y3, dessin_id);
			
					
					form.ajoutForme(r);
					
		
				} 
				

					
						
					
			}
			
	
			
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return form;
	}

}
