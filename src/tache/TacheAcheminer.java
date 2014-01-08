package tache;

import java.util.Random;

import modele.Tache;


public class TacheAcheminer extends Tache {
	
	public TacheAcheminer() {
		super("Acheminer matériaux",2);	
	}
	
	public int effectuerTache() {
		System.out.println("Je fais la tache");
		
		long deb = start();
		System.out.println(this.getNom());
		
		int nb = (int) (Math.random()*9+1);
		System.out.println("ma tache dure " + nb + " secondes");
		nb=nb*100;
		try {
			Thread.sleep(nb);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();System.out.println("erreur chrono");
		}
	
		stop(deb);
		
		return 0;
		
	}
	
	public static void main(String[] args) {
		
		int val = 0 ;int cpt=0;
		for (int i=0; i<5000000 ; i++){
			//val = energieLost();
			
			if (val > 33 || val < 7) {
				cpt++;
				System.out.println(val);
			}
		}
		System.out.println(cpt);
	}

}
