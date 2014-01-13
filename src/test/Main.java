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
		ArrayList<Tache> f3  = new ArrayList<Tache>();
		ArrayList<Tache> f4 = new ArrayList<Tache>();
		ArrayList<Tache> f5 = new ArrayList<Tache>();
		
		Tache t1 = new TacheElectricite();
		Tache t2 = new TacheAcheminer();
		Tache t3 = new TacheMonter();
		Tache t4 = new TachePoser();
		Tache t5 = new TacheVerifier();
		
		f1.add(t1);f1.add(t2);f1.add(t3);
		f2.add(t2);f2.add(t3);f2.add(t4);
		f3.add(t3);f3.add(t4);f3.add(t5);
		f4.add(t1);f4.add(t3);f4.add(t5);		
		f5.add(t2);f5.add(t4);f5.add(t5);
		
		Base base = new Base();


		Robot r1 = new Robot(base, f1);
		Robot r2 = new Robot(base, f2);
		Robot r3 = new Robot(base, f3);
		Robot r4 = new Robot(base, f4);
		Robot r5 = new Robot(base, f5);
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		try {
			
			r1.join();
			r2.join();
			r3.join();
			r4.join();
			r5.join();
			
		}
		catch (InterruptedException ex){
			ex.printStackTrace();
		}
		
	}

}
