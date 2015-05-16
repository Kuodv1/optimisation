package optimisation.modele;

import java.util.Random;

public class Clavier {

	protected char[][] clavier;
	
	static char[] lettre={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'} ;
	public Clavier() {
		clavier = new char[4][10];
		
		Random r = new Random();
		int j,k;
		for(int i = 0;i<lettre.length;i++) {
			j = r.nextInt(4);
			k = r.nextInt(10);
			if(clavier[j][k]<65) clavier[j][k] = lettre[i];
			else i--;
		}
	}
	
	public char[][] getClavier() {
		return clavier;
	}
}
