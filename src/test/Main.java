package test;

import java.util.ArrayList;

import tache.TachePoser;


import modele.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Tache> f = new ArrayList<Tache>();
		
		Tache t1 = new TachePoser();
		Tache t2 = new TachePoser();
		Tache t3 = new TachePoser();
		Tache t4 = new TachePoser();
		Tache t5 = new TachePoser();
		Tache t6 = new TachePoser();
		
		Base base = new Base();
		base.ajouterTache(t1, 1);
		base.ajouterTache(t2, 1);
		base.ajouterTache(t3, 1);
		base.ajouterTache(t4, 1);
		base.ajouterTache(t5, 1);
		

		Robot r1 = new Robot(base);
		Robot r2 = new Robot(base);
		
		r1.start();
		r2.start();
		
		try {
			r1.join();
			r2.join();
			
		}
		catch (InterruptedException ex){
			ex.printStackTrace();
		}
		

			
		

	}

}
