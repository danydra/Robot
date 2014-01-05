package tache;

import modele.Tache;


public class TachePoser extends Tache
{

	

	public TachePoser() {
		super("Poser mur",1);	
	}

	@Override
	public int effectuerTache() {

		long deb = start();
		System.out.println(this.getNom());
		
		int nb = (int) (Math.random()*9+1);
		System.out.println("ma tache dure " + nb + " secondes");
		nb=nb*100;
		try {
			Thread.sleep(nb);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();System.out.println("erreur chrono");
		}
		
		stop(deb);
		
		return 0;
	}
	

	
	
	
	

	


}
