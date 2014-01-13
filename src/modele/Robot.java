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
/*	
	 public void run(){
		while (true){
			if (charge < 34){
				//
				// faire un code d'une file d'attente
			}
			else{
				System.out.println("Je suis " + id);
				this.tache = chosirTache();
				charge -= this.tache.effectuerTache();
			}
	
			System.out.println("");
		}
				
	}
*/
	 public void run(){
			//for (int i=0; i<20; i++){
		 while (true){
				//System.out.println("Je suis le robot " + this.id + " mon niveau " + charge);
				if (charge < 30 ){
					//System.out.println(this.id + "TRY");
					if (base.placeFile()){
						base.recharger(this);
					}
					else{
						//System.out.println(this.id + " PAUSE");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
						
				}
				else{
					//System.out.println("Je suis " + this.id);
					this.tache = chosirTache();
					charge -= this.tache.effectuerTache();
				}
			}
					
		}


	
	
}
