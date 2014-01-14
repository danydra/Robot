package tache;

import modele.Tableau;
import modele.Tache;



public class TacheMonter extends Tache{
	
	public TacheMonter() {
		super("Monter charpente",3);	
	}

	@Override
	public int effectuerTache() {
		//lancer chrono tache
		long deb = start();
		//System.out.println(this.getNom());
		
		
		Tableau t = new Tableau();
		tri(t);

		return stop(deb);
		
	}
	
	public void tri (Tableau t){
		int temp;
		 // Parcours du tableau.
	     for(int i = 0; i < t.taille - 1; i++){
	    	 int min = i;
	         // Recherche de l'indice minimum.
	         for(int j = i + 1; j < t.taille; j++){
	            if(t.tab[j] < t.tab[min]){
	               min = j;
	         	}
	         }
	         // Permutation.
	         temp = t.tab[i];
		     t.tab[i] = t.tab[min];
		     t.tab[min] = temp;
		      
	      }
	}
	
	public static void main (String[] args){ 
		
		Tableau t = new Tableau();
		t.verif();
		//for(int i=0; i<t.taille;i++)System.out.println( i+ " -- "+ t.tab[i]);
     
      System.out.println("-----");
     // for(int i=0; i<t.taille;i++)System.out.println( i+ " -- "+ t.tab[i]);
      
      t.verif();
	}
		   


}
