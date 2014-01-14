package modele;

import java.util.Random;

public class Tableau {

	public int taille;
	public int []tab;
	public static final int MAXNBELMT = 2000;
	public static final int MINNBELMT = 4000;
	public static final int MAXVALEUR = 1000;
	
	public Tableau(){
		//la taille du tableau 
		Random rand = new Random();
		this.taille = rand.nextInt(MAXNBELMT) + MINNBELMT;
		this.tab = new int [taille];
		
		for(int i=0; i<taille;i++){
			tab[i] = rand.nextInt(MAXVALEUR);
		}	
		
	}
	
	
	public static void main (String[] args){ 
		Tableau t = new Tableau();
		
		for(int i=0; i<t.taille;i++){
			System.out.println( i+ " -- "+ t.tab[i]);
		}
		

	}
	
	public void verif (){
		int j=0;int cpt=0;
		for (int i=1; i<this.taille;i++){
			if(this.tab[i]< this.tab[j] ){
				cpt++;
			}
			j++;
		}
		if (cpt ==0 ) System.out.println("NO PROBLEM");
		else System.out.println("PROBLEM");
			
	}
	
			

	
	

}
