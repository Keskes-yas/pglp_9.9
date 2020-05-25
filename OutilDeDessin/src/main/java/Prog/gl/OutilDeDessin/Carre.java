package Prog.gl.OutilDeDessin;


public class Carre implements FormeGeometrique
{
	private String nom ; 
	private int x ;
	private int y ;
	private int a ;
	private String dessin_id;
	private String type = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);

	
   
	
	public Carre(String nom, int x, int y, int a, String dessin_id) {
		super();
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.a = a;
		this.dessin_id = dessin_id;
	}
	
	


	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public int getA() {
		return a;
	}




	public void setA(int a) {
		this.a = a;
	}




	public void glisser(int a, int b) {
		this.x = this.x + a ;
		this.y = this.y + b ;
	}
	
	public String toString() {
		return "Carré "+nom+" : ( p( "+x+", "+y+" ), "+"a : "+a+", Dessin : "+dessin_id;
		
	}


	public String Type() {
		return type;
	}

	
	public String getDessin_Id() {
		return dessin_id;
	}
}
