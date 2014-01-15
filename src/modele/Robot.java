package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import tache.TachePoser;


public class Robot extends Thread{

	private Base base;
	private static int cpt=0; //variable static pour compter le nombre d'instance de robot
	private int id;
	private int charge; // 100 pour un robot chargé, 0 pour un robot décharger
	private int nbRechargement;
	private int nbTacheFait;
	private float tempsTotalTravail;
	private ArrayList<Tache> sesTaches; //les types de taches que le robot est capable d'effectuer
	private Tache tache; //la tache que le robot doit effectuer l
	
	public Robot(Base b, ArrayList<Tache> st){
		this.cpt++;
		this.id=this.cpt;
		this.charge = 100;
		this.nbRechargement=0;
		this.tache = new TachePoser(); 
		this.tempsTotalTravail = 0;
		this.nbTacheFait = 0;
		sesTaches = st;
		this.base = b;
	}
	
	
	
	public int getNbRechargement() {
		return nbRechargement;
	}



	public int getNbTacheFait() {
		return nbTacheFait;
	}



	public float getTempsTotalTravail() {
		return tempsTotalTravail;
	}



	public int getIdRobot(){
		return this.id;
	}
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
		nbRechargement++;
		
	}

	private Tache chosirTache() {
		Random rand = new Random();
		int nb = rand.nextInt(3) + 0;
		return sesTaches.get(nb);
	}

	public void run(){
		int energie=0;
		int bou=0;
		 //while (true){
		for (bou=0; bou<base.NBTACHE;bou++){
			if (charge < 30 ){
				if (base.placeFile()){
					base.recharger(this);
				}
				else{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bou-=1;
				}				
			}
			else{
				this.tache = chosirTache();
				energie = this.tache.effectuerTache();
				base.setStatistique(this, this.tache, energie);
				if (this.charge - energie < 0 ) this.charge =1;
				else charge -= energie;
				//System.out.println(this.id + " - Effectue la tache " + this.tache.getNom() + " qui a consommé " + energie + " d'energie.");
				System.out.println(this.id + " - Effectue la tache " + this.tache.getNom() + " il lui reste " + this.charge + "% d'energie.");
			}
		}
		//System.err.println(this.id + " " + bou );
					
	}

	public void ajoutStat(int ener) {
		this.nbTacheFait++;
		this.tempsTotalTravail += ener;
	}


	
	
}
