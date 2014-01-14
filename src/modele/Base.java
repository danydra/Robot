package modele;

import java.util.*;


public class Base{ 

	public static final long NBTACHE = 10;
	public static final long TEMPSRECHARGEMENT = 500;
	private boolean libre;
	private ArrayList<Robot> fileAttente;
	private Statistique stat;
	
	
	public Base() {
		this.libre = true;
		this.fileAttente = new ArrayList<Robot>();	
		this.stat = new Statistique();
	}
	
	public boolean placeFile(){
		return (this.fileAttente.size() < 3);
	}
	
	public Statistique getStat() {
		return stat;
	}

	public void recharger(Robot r) {
		//System.out.println("Taille file "+ this.fileAttente.size());
		if (this.libre && this.fileAttente.size()==0 ){
			System.out.println( r.getIdRobot() + " - Direct.");
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

	public void setStatistique(Robot r, Tache t, int energie){
		int leRobot = this.stat.existe(r);
		int laTache = this.stat.existe(t);
		
		if (leRobot == -1){
			this.stat.mesRobots.add(r);
			leRobot = this.stat.existe(r);
		}
		if (laTache == -1){
			this.stat.mesTaches.add(t);
			laTache = this.stat.existe(t);	
		}
		
		this.stat.mesRobots.get(leRobot).ajoutStat(energie);
		this.stat.mesTaches.get(laTache).ajoutStat(energie);		
	}
	
	
	
		
	
	

}
