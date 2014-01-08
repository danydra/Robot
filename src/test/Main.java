package test;

import java.util.ArrayList;

import tache.*;


import modele.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Tache> f1 = new ArrayList<Tache>();
		ArrayList<Tache> f2 = new ArrayList<Tache>();
		
		Tache t1 = new TacheAcheminer();

		
		f1.add(t1);f1.add(t1);f1.add(t1);
		f2.add(t1);f2.add(t1);f2.add(t1);
		
		Base base = new Base();


		Robot r1 = new Robot(base, f1);
		Robot r2 = new Robot(base, f2);
		
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
