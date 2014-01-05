package modele;

import java.util.ArrayList;
import java.util.Iterator;

import tache.TachePoser;


public class Robot extends Thread{

	public static final int NBTACHEMAX = 3;
	private Base base;
	private static int cpt=0; //variable static pour compter le nombre d'instance de robot
	private int id;
	private int charge; // 100 pour un robot chargé, 0 pour un robot décharger
	private int nbRechargement;
	private ArrayList<Tache> sesTaches; //les types de taches que le robot est capable d'effectuer
	private Tache tache; //la tache que le robot doit effectuer
	private boolean working; //indique si le robot a du travail a faire
	
	public Robot(Base b){
		this.cpt++;
		this.id=this.cpt;
		this.charge = 100;
		this.nbRechargement=0;
		this.tache = new TachePoser(); // A REVOIR
		ArrayList<Tache> sesTaches = new ArrayList<Tache>();
		this.working = false;
		this.base = b;
	}
	
	
	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
		this.working = true;
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
	
	
	 public void run(){
		while (base.getNbTacheAFaire() > 0){
			
			System.out.println("Je suis " + id);
			this.working = true;
			this.base.tacheEffectue();
			charge -= this.tache.effectuerTache();
			this.working = false;
			
		}
				
	}

	public static void main (String[] args){ 
		int a=30;int b=10;
		a-=b;
		System.out.println(a);

	}
	
	
}
