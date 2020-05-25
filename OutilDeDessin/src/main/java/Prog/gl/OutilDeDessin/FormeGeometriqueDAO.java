package Prog.gl.OutilDeDessin;

import java.sql.Connection;

public abstract class  FormeGeometriqueDAO extends DAO<FormeGeometrique>{

	public FormeGeometriqueDAO(Connection c) {
		super(c);
	}

	
	/*CRUD METHOD*/
	
	public abstract boolean create(FormeGeometrique obj) ;

	public abstract boolean delete(FormeGeometrique obj);

	
	public abstract boolean update(FormeGeometrique obj) ;

	
	public abstract FormeGeometrique find(String name) ;

}
