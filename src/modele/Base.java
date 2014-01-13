package modele;

import java.util.*;


public class Base{ 

	public static final long TEMPSRECHARGEMENT = 1000;
	private boolean libre;
	private ArrayList<Robot> fileAttente;
	
	
	public Base() {
		this.libre = true;
		this.fileAttente = new ArrayList<Robot>();		
	}
	
	public boolean placeFile(){
		return (this.fileAttente.size() < 3);
	}
	
	public void recharger(Robot r) {
		//System.out.println("Taille file "+ this.fileAttente.size());
		if (this.libre && this.fileAttente.size()==0 ){
			effectuerRechargement(r, false);
		}
		else {
			if (!existe(r)){
				fileAttente.add(r);
				System.out.println(r.getIdRobot() + " - Entre dans la fille d'attente.");
				gestionRechargement();
			}
		}	
	}

	
	private boolean existe(Robot r) {
		boolean trouve= false;
		for (int i=0 ; i<this.fileAttente.size() ; i++){
			if (r.getIdRobot() == this.fileAttente.get(i).getIdRobot()){
				trouve = true;
				break;
			}
		}
		return trouve;
	}

	private synchronized void gestionRechargement() {
		while(!this.libre){
			try {
				wait();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.effectuerRechargement(this.fileAttente.get(0), true);
	}

	private synchronized void effectuerRechargement(Robot r, boolean oqp) {
		this.libre = false;
		
		try {
			Thread.sleep(TEMPSRECHARGEMENT );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		r.setCharge(100);
		System.out.println(r.getIdRobot() + " - S'est rechargé.");
		if(oqp){
			this.fileAttente.remove(r);
		}
		
		this.libre = true;
		notifyAll();
		
	}

}
