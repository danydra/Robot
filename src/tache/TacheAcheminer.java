package tache;

import java.util.Random;
import modele.Tableau;
import modele.Tache;


public class TacheAcheminer extends Tache {
	
	public TacheAcheminer() {
		super("Acheminer matériaux",2);	
	}
	
	public int effectuerTache() {
		
		//lancer chrono tache
		long deb = start();
		//System.out.println(this.getNom());
		
		Tableau t = new Tableau();
		
		//triInsertion
	    for(int i=1;i<t.taille;i++){
            int memory=t.tab[i]; int compt=i-1;
            boolean marqueur;
            do{
                marqueur=false;
                if (t.tab[compt]>memory){
                    t.tab[compt+1]=t.tab[compt];
                    compt--;
                    marqueur=true;
                 }
                if (compt<0) marqueur=false;
            }
            while(marqueur);
            t.tab[compt+1]=memory;
        }
        
		return stop(deb);
		
	}
	
	
	
	public static void main (String[] args){ 
	}

}