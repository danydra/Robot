package modele;

public abstract class Tache {
	
	
	private int id; 
	private int duree; // le cumule des durées d'éxécution de la tache
	private int cpt; //le nombre de fois ou la tache a été effectué
	
	public Tache(){
		this.duree=0;
		this.cpt=0;
	}
	
	public abstract void effectuerTache();

	public void incrementerCompteur(){
		this.cpt ++;
	}
	
	public void ajouterDuree(int d){
		this.duree += d;
	}
	
	// retourne la durée moyenne d'une tache
	public float moyenneTempsTache(){
		float retour;
		
		if (this.cpt == 0) retour = -1; 
		else retour = this.duree / this.cpt;
		
		return retour;	
	}
	
	

}
