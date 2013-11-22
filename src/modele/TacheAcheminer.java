package modele;


public class TacheAcheminer extends Tache {
	
	public TacheAcheminer() {
		super("Acheminer matériaux",2);	
	}

	@Override
	public synchronized void effectuerTache() {
		long deb = start();
		
		System.out.println(this.getNom());
			
		stop(deb);
	}
	
	

}
