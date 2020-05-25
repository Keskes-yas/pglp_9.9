package Prog.gl.OutilDeDessin;





public class Cercle implements FormeGeometrique
{	
	
	String nom;
    private String dessin_id = "";
    int x;
    int y;
    int rayon;
    String type = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
    
    
    public Cercle(String nom2, int x2, int y2, int rayon2, String dessin_id2) {
    	nom = nom2;
    	x= x2;
    	y = y2 ;
    	rayon = rayon2 ;
    	dessin_id = dessin_id2;
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


	public int getRayon() {
		return rayon;
	}


	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
 
    
    
	
    public void glisser(int a, int b) 
    {
		this.x = this.x + a ;
		this.y = this.y + b ;
    }

	
    public String toString() 
    {
    	return   "cercle ( : " + this.nom + ", Centre   : " + this.x + " - " + this.y + "rayon :" + this.rayon + " Dessin :" + this.dessin_id + ")" ;			
	
	}
	
	public String Type()
	{
		return this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
	}


	public String getDessin_Id() {
		return this.dessin_id;
	}



	public void setDessin_Id(String dessin_Id) {
		this.dessin_id = dessin_Id;
	}
}
