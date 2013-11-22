package test;

import java.util.ArrayList;


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
		
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		
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
