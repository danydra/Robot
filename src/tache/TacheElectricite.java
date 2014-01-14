package tache;

import modele.Tableau;
import modele.Tache;


public class TacheElectricite extends Tache{
	
	public TacheElectricite() {
		super("Faire electricite",5);	
	}



	public int effectuerTache() {
		
		//lancer chrono tache
		long deb = start();
		//System.out.println(this.getNom());
		
		
		Tableau t = new Tableau();
		
		tri(t);
	       
		return stop(deb);
		
	}
	
	public void tri (Tableau t){
		//triABulle
				for (int i=0 ;i<=(t.taille-2);i++){
					for (int j=(t.taille-1);i < j;j--){
						if (t.tab[j] < t.tab[j-1]){
		                    int x=t.tab[j-1];
		                    t.tab[j-1]=t.tab[j];
		                    t.tab[j]=x;
		                 }
					}
				}
	}
	
	
	
	public static void main (String[] args){ 
		
	Tableau t = new Tableau();
	
	  for(int i=0; i<t.taille;i++)System.out.println( i+ " -- "+ t.tab[i]);
	  System.out.println("-------");

	    for(int i=0; i<t.taille;i++)System.out.println( i+ " -- "+ t.tab[i]);
	    
	    
		t.verif();
		
	}

	

}
