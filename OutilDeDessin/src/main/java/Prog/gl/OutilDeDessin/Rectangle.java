package Prog.gl.OutilDeDessin;


public class Rectangle implements FormeGeometrique
{
	private String nom ; 
	private int x ;
	private int y ;
	private int a ;
	private int b ;
	private String dessin_id;
	private String type = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
	
	
	
    public Rectangle(String nom, int x, int y, int a, int b, String dessin_id) {
		super();
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
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



	public int getB() {
		return b;
	}



	public void setB(int b) {
		this.b = b;
	}



	
    public String toString() 
    {
		return "Rectangle "+nom+" : ( p( "+x+", "+y+" ), "+"a : "+a+"b : "+b+", Dessin : "+dessin_id;

    }


	public void glisser(int a, int b) {
		this.x = this.x + a ;
		this.y = this.y + b ;
	}



	
	public String Type() {
		return type;
	}



	public String getDessin_Id() {
		return dessin_id;
	}

}
