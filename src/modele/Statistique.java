package modele;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import test.Main;

public class Statistique {
	
	public ArrayList<Robot> mesRobots;
	public ArrayList<Tache> mesTaches;
	
	
	public Statistique(){
		this.mesRobots = new ArrayList<Robot>();	
		this.mesTaches = new ArrayList<Tache>();	
	}


	public int existe(Robot r) {
		int trouve= -1;
		for (int i=0 ; i<this.mesRobots.size();i++){
			if (r.getIdRobot() == this.mesRobots.get(i).getIdRobot()){
				trouve = i;
				break;
			}
			
		}
		return trouve;
	}


	public int existe(Tache t) {
		int trouve= -1;
		for (int i=0 ; i<this.mesTaches.size();i++){
			if (t.getId() == this.mesTaches.get(i).getId()){
				trouve = i;
				break;
			}
		}
		return trouve;
	}


	public void ecrire() 
	{
		
		String s="---Robot---\n";
		s+= "\n";
		s+="Les Robots\n";
		s+= "\n";
		for (Robot r : this.mesRobots){
			s+="Robot n°"+ r.getIdRobot();
			s+=" a effectué " + r.getNbTacheFait();
			s+= " tache(s), le temps moyen pour effectuer une tache est " + (r.getTempsTotalTravail() / r.getNbTacheFait());
			s+= " , s'est recharger " + r.getNbRechargement() + " fois.";
			s+= "\n";
			
		}
		s+= "\n";
		
		s+="Les Taches\n";
		s+= "\n";
		for (Tache t : this.mesTaches){
			s+="La tache "+ t.getNom();
			s+=" a effectué " + t.getNbAppel();
			s+= " fois, le temps moyen pour effectuer une tache est " + (t.getTempsTotal() / t.getNbAppel());
			s+= "\n";
			
		}
		
		
		
		
        try {
          File file = new File("resultat.txt");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(s);
          output.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }
	}
	



	public static void main(String[] args) {
		Main m = new Main();
		m.main(null);
		
	}

	
	
}
