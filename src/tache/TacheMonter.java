package tache;

import modele.Tache;



public class TacheMonter extends Tache{
	
	public TacheMonter() {
		super("Monter charpente",3);	
	}

	@Override
	public synchronized int effectuerTache() {
		long deb = start();
		 
		System.out.println(this.getNom());
		
		stop(deb);
		
		return 0;
	}

}
