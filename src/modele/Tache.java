package modele;

import java.util.Random;


public abstract class Tache {
	
	private int id;
	private String nom;
	private float tempsTotal;
	private int nbAppel;
	
	public Tache(){
		this.id = 0;
		this.nom="";
		this.tempsTotal=0;
		this.nbAppel=0;
	}

	public String getNom() {
		return nom;
	}
	
	

	public float getTempsTotal() {
		return tempsTotal;
	}

	public int getNbAppel() {
		return nbAppel;
	}

	//consutructeur pour les classes filles
	public Tache(String n, int id){
		this.nom = n;
		this.id = id;
	}
	
	//public abstract int effectuerTache();
	public int effectuerTache() {
		
		//lancer chrono tache
		long deb = start();
		//System.out.println(this.getNom());
		
		Tableau t = new Tableau();
		
		//triInsertion
	    tri(t);
        
		return stop(deb);
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public long start(){
		return System.currentTimeMillis();
		
	}
	
	public int stop(long deb){
	    long fin = System.currentTimeMillis();
	    float temps = (fin -deb);
		return (int) temps;
	}
	
	


	public void ajoutStat(int ener) {
		this.nbAppel ++;
		this.tempsTotal += ener;		
	}

	public abstract void tri(Tableau t);
	
	

}
