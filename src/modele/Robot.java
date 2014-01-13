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
	private ArrayList<Tache> sesTaches; //les types de taches que le robot est capable d'effectuer
	private Tache tache; //la tache que le robot doit effectuer l
	
	public Robot(Base b, ArrayList<Tache> st){
		this.cpt++;
		this.id=this.cpt;
		this.charge = 100;
		this.nbRechargement=0;
		this.tache = new TachePoser(); // A REVOIR
		sesTaches = st;
		this.base = b;
	}
	
	public int getIdRobot(){
		return this.id;
	}
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	private Tache chosirTache() {
		Random rand = new Random();
		int nb = rand.nextInt(3) + 0;
		return sesTaches.get(nb);
	}

	public void run(){
		int energie=0;
		 while (true){
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
				}				
			}
			else{
				this.tache = chosirTache();
				energie = this.tache.effectuerTache();
				charge -= energie;
				//System.out.println(this.id + "- effectue la tache " + this.tache.getNom() + "");
			}
		}
					
	}


	
	
}
