package modele;

public class Tache1 extends Tache
{

	

	public Tache1() {
		super("Poser mur");	
	}

	@Override
	public void effectuerTache() {
		long deb = start();
		  
		for (int i = 0; i < 25; i++)
		    {
				//System.out.println(i);
		        try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		
		stop(deb);
	}
	
	 public static void main(String[] args) 
	  {
		
	  }
	

}
