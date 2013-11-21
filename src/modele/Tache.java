package modele;

public abstract class Tache {
	
	
	private int id;
	private String nom;
	private float duree; // le cumule des durées d'éxécution de la tache
	private int cpt; //le nombre de fois ou la tache a été effectué
	private float tempsMoyen;
	
	
	public Tache(){
		this.duree=0;
		this.cpt=0;
		this.tempsMoyen=-1;
	}
	
	//consutructeur pour les classes filles
	public Tache(String n){
		this.nom = n;
		this.duree=0;
		this.cpt=0;
	}
	
	public abstract void effectuerTache();

	public void incrementerCompteur(){
		this.cpt ++;
	}
	
	public void ajouterDuree(float d){
		this.duree += d;
	}
	
	// retourne la durée moyenne d'une tache
	public float moyenneTempsTache(){
		float retour;
		
		if (this.cpt == 0) retour = -1; 
		else retour = this.duree / this.cpt;
		
		return retour;	
	}
	
	public long start(){
		return System.currentTimeMillis();
		
	}
	
	public void stop(long deb){
	    long fin = System.currentTimeMillis();
	    float temps = (fin -deb) / 1000F;
	    this.ajouterDuree(temps);
		this.incrementerCompteur();
		this.tempsMoyen = moyenneTempsTache();
		System.out.println(Float.toString(temps));
	}

	@Override
	public String toString() {
		return "Tache [nom=" + nom + ", duree=" + duree
				+ ", cpt=" + cpt + ", tempsMoyen=" + tempsMoyen + "]";
	}
	
	
	

}
