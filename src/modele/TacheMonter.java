package modele;



public class TacheMonter extends Tache{
	
	public TacheMonter() {
		super("Monter charpente",3);	
	}

	@Override
	public synchronized void effectuerTache() {
		long deb = start();
		 
		System.out.println(this.getNom());
		
		stop(deb);
	}

}
