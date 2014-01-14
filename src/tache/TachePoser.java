package tache;

import modele.Tableau;
import modele.Tache;


public class TachePoser extends Tache
{

	

	public TachePoser() {
		super("Poser mur",1);	
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
	
	public void tri(Tableau t){
		triFusion(t.tab,0,t.taille-1);
	}
	
	private static  void triFusion(int tab[],int deb,int fin){
	    if (deb!=fin){
			int mil;
			mil=(fin+deb)/2;
			triFusion(tab,deb,mil);
			triFusion(tab,mil+1,fin);
			fusionner(tab,deb,mil,fin);
	    }
	}

	private static void fusionner(int tab[],int deb,int fin,int finBis){
	    int debBis=fin+1;

	    int table1[]=new int[fin-deb+1];
	    
	    for(int i=deb;i<=fin;i++){
	        table1[i-deb]=tab[i];
	    }
	    
	    int compt1=deb;
	    int compt2=debBis;
	    
	    for(int i=deb;i<=finBis;i++){        
	        if (compt1==debBis) {
	            break;
	        }
	        else if (compt2==(finBis+1)) {
	        	tab[i]=table1[compt1-deb];
	        	compt1++;
            }
	        else if (table1[compt1-deb]<tab[compt2]){
	            tab[i]=table1[compt1-deb];
	            compt1++;
	        }
	        else{
	            tab[i]=tab[compt2]; 
	            compt2++;
	        }
	   }
	}

	

	

	


}
