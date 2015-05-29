package optimisation.modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Clavier {

	protected char[][] clavier;
	protected int energie;
	
	static char[] lettre={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'} ;
	public Clavier() {
		clavier = new char[4][10];
		for(int i = 0; i<4;i++) {
			for(int j = 0; j<10;j++) clavier[i][j] = ' ';
		}
		Random r = new Random();
		int j,k;
		for(int i = 0;i<lettre.length;i++) {
			j = r.nextInt(4);
			k = r.nextInt(10);
			if(clavier[j][k]<65) clavier[j][k] = lettre[i];
			else i--;
		}
		energie = 0;
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
	
	public void setClavier(char[][] cla) {
		this.clavier = cla;
	}
	
	public char[][] getClavier() {
		return clavier;
	}
	
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public int getEnergie() {
		return energie;
	}
	
	public boolean possibleDroit(int x, int y) {
		return (y<8 && !(clavier[x][y]==' ' && clavier[x][y+1]==' '));
	}
	
	public boolean possibleBas(int x, int y) {
		return (x<3 && !(clavier[x][y]==' ' && clavier[x+1][y]==' '));
	}
	
	public boolean possibleGauche(int x, int y) {
		return (y>0 && !(clavier[x][y]==' ' && clavier[x][y-1]==' '));
	}
	
	public boolean possibleHaut(int x, int y) {
		return (x>0 && !(clavier[x][y]== ' ' && clavier[x-1][y]==' '));
	}
	
	public void echangeDroit(int x, int y) {
		char tmp = clavier[x][y];
		clavier[x][y] = clavier[x][y+1];
		clavier[x][y+1] = tmp;
	}
	
	public void echangeBas(int x, int y){
		char tmp = clavier[x][y];
		clavier[x][y] = clavier[x+1][y];
		clavier[x+1][y] = tmp;
	}
	
	public void echangeGauche(int x, int y){
		char tmp = clavier[x][y];
		clavier[x][y] = clavier[x][y-1];
		clavier[x][y-1] = tmp;
	}
	
	public void echangeHaut(int x, int y) {
		char tmp = clavier[x][y];
		clavier[x][y] = clavier[x-1][y];
		clavier[x-1][y] = tmp;
	}
	
	public boolean estVide(int ligne, int colonne) {
		return clavier[ligne][colonne]<65;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<4;i++) {
			sb.append("|"+clavier[i][0]+"|");
			for(int j = 1; j<10; j++) {
				sb.append(clavier[i][j]+"|");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean equals(Object test) {
		char[][] aTest = ((Clavier)test).getClavier();
		boolean diff = false;
		int i = 0;
		int y = 0;
		while(!diff && i<4) {
			y = 0;
			while(!diff && y<10) {
				diff = (clavier[i][y]!=aTest[i][y]);
				y++;
			}
			i++;
		}
		return diff;
		//return Arrays.deepEquals(getClavier(),((Clavier)test).getClavier());
	}
}
