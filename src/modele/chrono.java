package modele;

public class chrono
{
	/**       Chronométrer une opération               **/
 
  public static void main(String[] args) throws Exception
  {
    long tempsDebut = System.currentTimeMillis();
 
    for (int i = 0; i < 30; i++)
    {
		//System.out.println(i);
        Thread.sleep(100);
    }
    long tempsFin = System.currentTimeMillis();
    float seconds = (tempsFin - tempsDebut) / 1000F;
    System.out.println("Opération effectuée en: "+ Float.toString(seconds) + " secondes.");
  }
}