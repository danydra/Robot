package modele;

import java.util.ArrayList;
import java.util.Iterator;


public class Robot extends Thread{

	public static final int NBTACHEMAX = 3;
	private static int cpt=0; //variable static pour compter le nombre d'instance de robot
	private int id;
	private int charge; // 100 pour un robot chargé, 0 pour un robot décharger
	private int nbRechargement;
	private ArrayList<Tache> sesTaches; //les types de taches que le robot est capable d'effectuer
	private Tache tache; //la tache que le robot doit effectuer
	private boolean working; //indique si le robot a du travail a faire
	
	public Robot(){
		this.cpt++;
		this.id=this.cpt;
		this.charge = 100;
		this.nbRechargement=0;
		this.tache = null;
		this.working = false;
	}
	
	public boolean ajouterTache(Tache t){
		if (this.verifierTache(t)) {
			sesTaches.add(t);
			return true;
		}
		else return false;
	}
	
	public boolean verifierTache(Tache t){
		if ( (this.sesTaches.size() >= this.NBTACHEMAX) || this.existeTache(t) ) return false;
		else return true;
	}
	
	//signale si la tache exite déja dans la liste des taches du robot
	public boolean existeTache(Tache t){
		boolean trouver=false;
		Iterator<Tache> it = this.sesTaches.iterator();
		
		while(!trouver && it.hasNext()){
			if (t.getId() == it.next().getId()){
				trouver = true;
			}
		}
		return trouver;
	}
	
	public boolean isWorking() {
		return working;
	}

	
	
	
	public void run(){
		while (true){
			this.working = true;
			this.tache.effectuerTache();
			this.working = false;
		}
				
	}

	public static void main (String[] args){ 
		Robot r1 = new Robot();
		Tache t1 = new TachePoser();
		//r1.setTache(t1);

	}
	
	
}
