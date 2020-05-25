package Prog.gl.OutilDeDessin;

public class Triangle implements FormeGeometrique 
{
	private String nom;
	private String type = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
    private int x1,	x2, x3;
    private int y1, y2, y3;
    private String dessin_id = "" ;
    

  
	
    public Triangle(String nom, int x1, int x2, int x3, int y1, int y2, int y3, String dessin_id) {

		this.nom = nom;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.dessin_id = dessin_id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getX2() {
		return x2;
	}


	public void setX2(int x2) {
		this.x2 = x2;
	}


	public int getX3() {
		return x3;
	}


	public void setX3(int x3) {
		this.x3 = x3;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getY2() {
		return y2;
	}


	public void setY2(int y2) {
		this.y2 = y2;
	}


	public int getY3() {
		return y3;
	}


	public void setY3(int y3) {
		this.y3 = y3;
	}


	public String getDessin_id() {
		return dessin_id;
	}


	public void setDessin_id(String dessin_id) {
		this.dessin_id = dessin_id;
	}


	public void glisser(int a, int b) 
    {
		this.x1 = this.x1 + a ;
		this.x2 = this.x2 + a ;
		this.x3 = this.x3 + a ;
		
		this.y1 = this.y1 + b ;
		this.y2 = this.y2 + b ;
		this.y3 = this.y3 + b ;
    }

	
    public String toString() 
    {
		return "triangle "+nom+" : ( p1("+x1+" , "+y1+") ,p2("+x2+" , "+y2+") ,p3("+x3+" , "+y3+") , dessin : " + dessin_id + " )";
	}


	
	public String Type() {
		return type;
	}


	
	public String getDessin_Id() {
		return this.dessin_id;
	}
	
	
	
}
