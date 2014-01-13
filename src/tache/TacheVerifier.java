package tache;

import modele.Tableau;
import modele.Tache;


public class TacheVerifier extends Tache{
	
	public TacheVerifier() {
		super("Vérifier etat travaux",4);	
	}

	@Override
	public int effectuerTache() {
		
		//lancer chrono tache
		long deb = start();
		//System.out.println(this.getNom());
		
		
		Tableau t = new Tableau();
		triRapide(t.tab,0,t.taille-1);
		
		return stop(deb);
		
	}
	
	private static int partitionner(int tab[],int deb,int fin){
		int temp;
		int cpt=deb;
		int pivot=tab[deb];
       
		for(int i=deb+1;i<=fin;i++){
           if (tab[i]<pivot){
               cpt++;
               temp = tab[i];
               tab[i] = tab[cpt];
               tab[cpt] = temp;
           }
        }
		
       temp = tab[deb];
       tab[deb] = tab[cpt];
       tab[cpt] = temp;
       
       return cpt;
	}

	private static void triRapide(int tab[],int deb,int fin){
       if(deb<fin){
           int positionPivot=partitionner(tab,deb,fin);
           triRapide(tab,deb,positionPivot-1);
           triRapide(tab,positionPivot+1,fin);
       }
	}
	
	public static void main (String[] args){ 
		Tableau t = new Tableau();
		t.verif();
		triRapide(t.tab,0,t.taille-1);
		t.verif();
		
		
	}
	

}
