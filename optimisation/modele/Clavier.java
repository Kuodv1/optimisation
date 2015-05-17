package optimisation.modele;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	//Fonction pour générer un clavier avec un nombre de lettre de départ
	//Utile ou non, va savoir
	public Clavier(int nbLettre) {
		clavier = new char[4][10];
		int i,j,k;
		int taille = nbLettre;
		Random r = new Random();
		if(nbLettre>26) taille = 26;
		else if(nbLettre<=0) taille = 1;
		ArrayList<Character> lettreAlea = new ArrayList<Character>(taille);
		for(i = 0; i<taille;i++) {
			j = r.nextInt(26);
			if(!lettreAlea.contains(lettre[j])) lettreAlea.add(lettre[j]);
			else i--;
		}
		
		for(i = 0;i<taille;i++) {
			j = r.nextInt(4);
			k = r.nextInt(10);
			if(clavier[j][k]<65) clavier[j][k] = lettreAlea.get(i);
			else i--;
		}
	}
	
	public char[][] getClavier() {
		return clavier;
	}
	
	public boolean estVide(int ligne, int colonne) {
		return clavier[ligne][colonne]<65;
	}
	
	public boolean equals(Object test) {
		return Arrays.deepEquals(getClavier(),((Clavier)test).getClavier());
	}
}
