package test;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;

import tache.*;
import modele.Base;
import modele.Robot;
import modele.Tableau;
import modele.Tache;

public class Test {

	public String nom;
	
	
	
	public Test(String nom) {
		super();
		this.nom = nom;
	}
	
	public void affiche(){
		System.out.println(this.nom + " PASS");
	}
	public void affiche(boolean ok){
		if (ok)System.out.println(this.nom + " PASS");
		else System.out.println(this.nom + "FAIL");
	}
	
	public static void main(String[] args) {
		
		//TEST DES TRI 
		Test t1 = new Test ("tache acheminer");
		Tableau tab1 = new Tableau();
		Tache tache1 = new TacheAcheminer();
		tache1.tri(tab1);
		assertEquals(tab1.verif(),true);
		t1.affiche();
	
		Test t2 = new Test ("tache electricite");
		Tableau tab2 = new Tableau();
		Tache tache2 = new TacheElectricite();
		tache2.tri(tab2);
		assertEquals(tab2.verif(),true);
		t2.affiche();
		
		Test t3 = new Test ("tache monter");
		Tableau tab3 = new Tableau();
		Tache tache3 = new TacheMonter();
		tache3.tri(tab3);
		assertEquals(tab3.verif(),true);
		t3.affiche();
		
		Test t4 = new Test ("tache poser");
		Tableau tab4 = new Tableau();
		Tache tache4 = new TacheMonter();
		tache4.tri(tab4);
		assertEquals(tab4.verif(),true);
		t4.affiche();
		
		Test t5 = new Test ("tache verifier");
		Tableau tab5 = new Tableau();
		Tache tache5 = new TacheVerifier();
		tache5.tri(tab5);
		assertEquals(tab5.verif(),true);
		t5.affiche();
		
		
		//TEST DU ROBOT 
		Base base = new Base();
		ArrayList<Tache> f1 = new ArrayList<Tache>();
		Tache ta1 = new TacheElectricite();
		Tache ta2 = new TacheAcheminer();
		Tache ta3 = new TacheMonter();
		f1.add(ta1);f1.add(ta2);f1.add(ta3);
		Robot r1 = new Robot(base, f1);
		
		r1.start();
		Test t6 = new Test ("robot ne se décharge jamais");
		boolean negatif = true;
		while (r1.isAlive() && negatif){
			if (r1.getCharge() < 0) negatif = false;
		}
		
		t6.affiche(negatif);
		
		Base base2 = new Base();
		Robot r2 = new Robot(base2, f1);
		Robot r3 = new Robot(base2, f1);
		Robot r4 = new Robot(base2, f1);
		Robot r5 = new Robot(base2, f1);
		Test t7 = new Test ("La file d'attente ne contient pas plus de 3 robot");
		negatif = true;
		while (r2.isAlive() && r3.isAlive() && r4.isAlive() && r5.isAlive() && negatif){
			if (base2.getNbFil() > 3) negatif = false;
		}
		t7.affiche(negatif);
		
		
		
	}

}
