package Prog.gl.OutilDeDessin;

import java.util.ArrayList;
import java.util.Iterator;

public class Udessin implements Iterable<FormeGeometrique>
{
	
    String nomDessin;
    ArrayList<FormeGeometrique> formes;
    
    public Udessin(String name) 
    {
        this.nomDessin = name;
        formes = new ArrayList<FormeGeometrique>();
    }

	public ArrayList<FormeGeometrique> getFormes() 
	{
		return formes;
	}

	public void setFormes(ArrayList<FormeGeometrique> formes) 
	{
		this.formes = formes;
	}

	

    public void ajoutForme(FormeGeometrique formeGeometrique)
    {
        this.formes.add(formeGeometrique);
    }
    
    public void supprForme(FormeGeometrique nom)
    {
        formes.remove(formes.indexOf(nom));
    }

    public void clearDraw()
    {
    	this.formes.clear();
    }
    
    public String toString() 
    {
    	String s = "Dessin \" " + nomDessin + " :   "  ;  
    			for(FormeGeometrique formeGeometrique : formes) 
    				s = s + "[ "+ formeGeometrique.toString() + "]" ;
    	return s ;
    }

    public void glisser(int a , int b) 
    {
        for(FormeGeometrique formeGeometrique : formes)
        {
            formeGeometrique.glisser(a, b);
        }
    }
    
    
	public Iterator<FormeGeometrique> iterator() 
	{
		assert null!= formes;		
		return formes.iterator();
	}
    


	
}
