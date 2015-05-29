package optimisation.modele.algorithme;

import java.util.ArrayList;

import optimisation.modele.Clavier;

public class AlgorithmeTabou implements Algorithme{
	
	private int[][] ods = {
			{31,242,392,208,48,135,232,37,1255,32,7,663,350,1378,17,412,44,905,409,613,599,301,2,6,69,12 },
			{	15,8,	2,	1,	2,	130	,1,	2,	0,	132,	4,	10,	181	,1,	1,	146	,1	,3	,187	,29,16	,44	,3,	0	,0	,4	,0 },
			{ 312,	0,	73,	19,	765,	2,	2,	411,	209,	3,	5,	124,	5,	1,	677,	11,	7,	100,	14,	142	,132,	2,	0	,0	,11,	0 },
			{	427,	1,	8,	24,	2409,	2,	5,	25,	378,	3,	0,	14,	21,	5,	231,	4,	6,	134,	64,	3,	406,	4,	1,	0,	5,	0 },
			{	616	,176	,917	,998,	782,	258,	209,	67,	179,	96,	8,	1382,	1056,	2121,	136,	699,	190,	1514,	3318,1307	,761	,258,	11,	125,	15,	60 },
			{	181	,1,	1,	8,	180,	118,	1,	1,	190,	0,	0,	43,	1,	1,	213,	1,	2,	106,	12,	1,	61,	0,	0,	0,	1,	0 },
			{	135,	1,	10,	9,	408,	4,	63,	3,	69,	6,	4,	74,	10,	103,	47,	5,	1,	197,	12,	23,	81,	1,	0,	0,	2,	0 },
			{	267,	5,	4,	1,	285,	0,	0,	0,	149,	3,	0,	3,	4,	17,	107,	0,	3,	18,	5,	0,	42,	0,	1,	0,	7,	0 },
			{	176,	85,	203,	172,	1030,	114,	115,	6,	49,	14,	0,	798,	181,	797,	524,	75,	215,	400,	897,	1243,	11,	190,	1,	40,	0,	4 },
			{	76,	0,	0	,0,	100,	0,	0,	0	,2,	0,	0,	0,	0,	0,	91,	0,	0,	0,	0,	0,	42,	0,	0,	0,	2,	0 },
			{	8,	0,	0,	0,	6,	0,	3,	0,	6,	0,	0,	0,	10,	3,	9,	0,	0,	5,	1,	0,	0,	0,	0,	0,	3,	0 },
			{	1270,	14,	22,	58,	2366,	25,	14,	39,	512,	4,	1,	647,	18,	41,	281,	69,	47,	16,	126,	42,	369,	14,	0,	0,	15,	1 },
			{	510,	152,	11,	11,	1099,	0,	1,	1,	302,	0,	0,	7,	243,	4,	334,	201,	2,	10,	10,	8,	52,	1,	0,	0,	3,	0},
			{	405,	30,	438,	785,	985,	124,	222,	24,	316,	17,	7	,89,	68,	249,	303,	130,	82,	55,	846,	1694,	114,	109,	0,	1,	19,	20},
			{	6	,83	,88	,101,	46,	32,	115,	7,	452,	14,	3,	184,	391,	1646,	8,	175,	19,	491,	126,	109,	1086,	28,	9	,4,	62,	4},
			{	671,	1,	3,	21,	441,	5,	1,	136,	119,	0,	0,	377,	2,	4,	505,	125,	1,	363,	31,	65,	140,	1,	0,	0,	1,	0},
			{	2,	0,	3,	0,	1,	0,	0,	1,	0,	0,	0,	1,	3,	0,	0,	1,	0,	1,	0,	0,	975,	0,	0,	0,	0,	0},
			{	896,	53,	168,	302,	1885,	46,	96,	5,	583,	11,	3,	292,	181,	88,	520,	82,	51,	176,	386,	445,	183,	77,	1,	1,	21,	5},
			{	809	,85,	306,	735,	1377,	151,	73,	83,	565,	36,	0,	453,	192,	107,	521,	496,	191,	137,	702,	578,	343,	92,	1,	6,	30,	10},
			{	881,	25,	166,	515,	1484,	52,	19,	64,	984,	28,	3,	331,	70,	40,	363,	268,	96,	668,	404,	269,	270,	41,	4,	6,	18,	3},
			{	168	,87	,165,	162,	781,	40,	83,	4,	534,	41,	3,	302,	128,	516,	19,	184,	15,	980,	591,	469,	14,	177,	1,	264,	8,	4},
			{	277	,0	,1,	0,	502,	0,	0,	0,	288,	0,	0	,1,	0,	0,	167,	0,	0,	81,	0,	0,	11,	0,	0,	0,	0,	0},
			{	11,	1	,1,	0,	3,	0,	0,	2,	8,	0,	0,	0,	0,	0,	3,	0,	1,	0,	4,	0,	0,	0,	0,	0,	2,	0},
			{	35,	14,	37,	36,	68,	8,	7,	5,	57,	0,	0,	21,	15	,3,	7,	56,	11,	3,	15,	35	,2,	18,	0,	4,	0,	0},
			{	63,	0,	7,	7,	59	,3,	4,	0,	0,	0,	0,	13,	8,	5,	15,	14	,0	,10,	75	,9	,2,	4,	0,	0,	0,	0},
			{	8,	0,	2,	6,	49,	3,	1,	0,	1,	1,	0,	11,	4,	2,	15	,4,	1,	0,	3,	1,	0,	7,	4,	0,	0,	2},
							};
	
	protected Clavier bestOf;
	protected int refresh;
	protected Clavier aTraiter;
	protected int limite;
	protected int nbrIte;
	//protected HashSet<Clavier> valeurTabou;
	protected ArrayList<Clavier> listeTabou;
	protected int tailleTabou;
	
	boolean fini;
	
	public AlgorithmeTabou() {
		bestOf = new Clavier();
		bestOf.setEnergie(calculEnergie(bestOf.getClavier()));
		aTraiter = new Clavier();
		aTraiter.setClavier(bestOf.getClavier());
		aTraiter.setEnergie(bestOf.getEnergie());
		aTraiter.setEnergie(calculEnergie(aTraiter.getClavier()));
		tailleTabou = 25;
		//valeurTabou = new HashSet<Clavier>(10);
		listeTabou = new ArrayList<Clavier>(10);
		limite = 5000000;
		fini = false;
		nbrIte = 0;
	}
	
	
	public int getTailleTabou() {
		return tailleTabou;
	}
	
	public void setTailleTabou(int tailleTabou) {
		this.tailleTabou = tailleTabou;
		//valeurTabou = new HashSet<Clavier>(tailleTabou);
		listeTabou = new ArrayList<Clavier>(tailleTabou);
		fini = false;
	}
	
	public int getNbrIte() {
		return nbrIte;
	}
	
	public int getBestObj() {
		return bestOf.getEnergie();
	}
	
	public void setLimiteBoucle(int limite) {
		this.limite = limite;
	}
	
	public Clavier getBestOf() {
		return bestOf;
	}
	
	public void ajoutClavierTabou(Clavier cla) {
		if(getSizeListe() == tailleTabou) {
			removeClavierTabou();
		}
		//valeurTabou.add(cla);
		listeTabou.add(cla);
	}
	
	public boolean presentTabou(Clavier cla) {
		return listeTabou.contains(cla);
	}
	
	/*public boolean presentTabouD(Clavier cla) {
		return listeTabou.contains(cla);
	}*/
	
	public int getIndexClavier(Clavier cla) {
		return listeTabou.indexOf(cla);
	}
	
	public void removeClavierTabou() {
		//Clavier cla = listeTabou.get(0);
		//valeurTabou.remove(cla);
		listeTabou.remove(0);		
	}
	
	public int getSizeListe() {
		return listeTabou.size();
	}
	
	@Override
	public String getNom() {
		return "Recherche Tabou";
	}
	
	
	public ArrayList<Clavier> getVoisin() {
		ArrayList<Clavier> voisin = new ArrayList<Clavier>();
		int tmp = 0;
		int index = 0;
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<10;j++) {
				if(aTraiter.possibleGauche(i,j)){
					Clavier c = new Clavier();
					c.setClavier(aTraiter.getClavier());
					c.echangeGauche(i, j);
					if(ajoutVoisin(voisin,c)){
						tmp = c.getEnergie();
						if(voisin.get(index).getEnergie()>tmp){
							index = voisin.size()-1;
						}
					}
				}
				if(aTraiter.possibleHaut(i, j)) {
					Clavier c = new Clavier();
					c.setClavier(aTraiter.getClavier());
					c.echangeHaut(i, j);
					if(ajoutVoisin(voisin,c)){
						tmp = c.getEnergie();
						if(voisin.get(index).getEnergie()>tmp){
							index = voisin.size()-1;
						}
					}
				}
				if(aTraiter.possibleDroit(i, j)) {
					Clavier c = new Clavier();
					c.setClavier(aTraiter.getClavier());
					c.echangeDroit(i, j);
					if(ajoutVoisin(voisin,c)){
						tmp = c.getEnergie();
						if(voisin.get(index).getEnergie()>tmp){
							index = voisin.size()-1;
						}
					}
				}
				if(aTraiter.possibleBas(i, j)) {
					Clavier c = new Clavier();
					c.setClavier(aTraiter.getClavier());
					c.echangeBas(i, j);
					if(ajoutVoisin(voisin,c)){
						tmp = c.getEnergie();
						if(voisin.get(index).getEnergie()>tmp){
							index = voisin.size()-1;
						}
					}
				}
			}
		}
		voisin.get(0).setClavier(voisin.get(index).getClavier());
		return voisin;
	}
	
	public boolean ajoutVoisin(ArrayList<Clavier> voisin, Clavier c){
		boolean place = false;
		if(!voisin.contains(c) && !presentTabou(c)) {
			voisin.add(c);
			c.setEnergie(calculEnergie(c.getClavier()));
			place = true;
		}
		return place;
	}


	public void setEtatATraiter(ArrayList<Clavier> voisin) {
		Clavier c = voisin.get(0);
		if(c.getEnergie()< bestOf.getEnergie()) {
			bestOf.setClavier(c.getClavier());
			bestOf.setEnergie(c.getEnergie());
		}
		aTraiter.setClavier(c.getClavier());
		aTraiter.setEnergie(c.getEnergie());
		ajoutClavierTabou(c);
	}
	
	public void tabou() {
		nbrIte = 0;
		fini = false;
		while(nbrIte < limite){
			setEtatATraiter(getVoisin());
			nbrIte++;
		}
		fini = true;
	}
	
	public boolean estFini() {
		return fini;
	}
	
	public int calculEnergie(char[][] let)
	{
		int i,j,a=0;
					 
		for(i=0;i<26;i++)
		{
	
			for(j=0;j<26;j++)
			{
				a+= ods[i][j] * distance(i,j,let);
			}
		}
		
		return a;
	}
	
	public double distance(int i,int j,char[][] let)
	{
		int valRetour = 0;
		char a = (char)(i+65);
		char b = (char)(j+65);
		int x,y,x1=0,x2=0,y1=0,y2=0;
		if(a!=b)
		{
			for(x=0;x<4;x++)
			{
				for(y=0;y<10;y++)
				{
					if(let[x][y]==a)
					{
						x1=x;
						y1=y;
					}
				    if(let[x][y]==b)
					{
						x2=x;
						y2=y;
						
					}
				}

			}
			valRetour = Math.abs((Math.abs(x1-x2)+Math.abs(y1-y2)));
		}
		return valRetour;
	}
	
	
	public void setRefresh(int refresh){
		this.refresh = refresh;
	}
	
	public int getRefresh() {
		return refresh;
	}
 /*   public static void main(String[] args) {
        AlgorithmeTabou at = new AlgorithmeTabou();
        Clavier c1 = new Clavier();
        Clavier c2 = new Clavier();
        Clavier c3 = new Clavier();
        
        ArrayList<Clavier> t = new ArrayList<Clavier>();
        t.add(c1);
        if(t.contains(c1)) System.out.println("ok");
        c2.setClavier(c1.getClavier());
        if(t.contains(c2)) System.out.println("ok2");
        if(c2.possibleBas(2, 2)) {c2.echangeBas(2, 2);System.out.println("ok3");}
        if(t.contains(c2)) System.out.println("ok4");
        
    }*/


	@Override
	public int getLimite() {
		return limite;
	}


	@Override
	public void setLimite(int limite) {
		this.limite = limite;		
	}

	

}
