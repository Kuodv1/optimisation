package optimisation.modele.algorithme;

import java.util.ArrayList;

import optimisation.modele.Clavier;


public class AlgorithmeRecuitSimule implements Algorithme{
	
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
	private char[][] lettre = {
								{' ',' ','a','l','e','y','d',' ',' ',' '},
								{' ','g','f','w','z','h','s','i',' ',' '},
								{' ','o','q','x','c','t','u','m',' ',' '},
								{' ','r','k','p','v','j','n','b',' ',' '},
							  };
	private int energie;
	protected int refresh;
	private double temperature;
	protected int ite;
	private double tps = 0;
	private double k;
	private ArrayList<char[][]> parcours;
	private char[][] tampon ={
								{' ',' ','a','l','e','y','d',' ',' ',' '},
								{' ','g','f','w','z','h','s','i',' ',' '},
								{' ','o','q','x','c','t','u','m',' ',' '},
								{' ','r','k','p','v','j','n','b',' ',' '},
	  						};
	private Clavier clavier;
	
	public AlgorithmeRecuitSimule() {
		this.temperature = 10000;
		this.energie = 0;
		ite = 0;
		this.clavier = new Clavier();
		this.tps = 30000;
		k = 0.99;
		this.parcours = new ArrayList<char[][]>();
	}
	
	public AlgorithmeRecuitSimule(int temperature) {
		this.temperature = temperature;
		k = 0.99;
		this.energie = 0;
		ite = 0;
		this.clavier = new Clavier();
		this.tps = 30000;
		this.parcours = new ArrayList<char[][]>();
	}
	
	public int getNbrIte() {
		return ite;
	}
	
	public void recuitSimule()
	{
		char[][] s  = copyTab(lettre);
		char[][] sn = {};
		int temps = 0;
		int e = calculEnergie(s);
		int en=0;
		ite = 0;
		double t = temperature/10;
		
		while(t<=temperature && temps<tps)
		{
			sn = voisin(s);
			en = calculEnergie(sn);
			if( (en < e) || (Math.random() < Math.exp(en/t)))
			{
				if(en < e)
				{
					tampon = copyTab(sn);
					e=en;
					temps=0;
					parcours.add(getMajuscule(copyTab(sn)));
				}
				s=sn;
			}
			temps+=1;
			temperature*=k;
			ite++;
		}
	}
	
	public char[][] copyTab(char[][] let){
    	int i,j;
    	char[][] c = new char[let.length][let[0].length];
    	for(i=0;i<4;i++){
    		for(j=0;j<10;j++){
    			c[i][j]=let[i][j];
    		}
    	}
    	return c;
    }
	
	
	public char[][] voisin(char[][] let)
	{
		char[][] l = copyTab(let);
		
		int x1= (int)Math.ceil(Math.random()*3);
		int x2= (int)Math.ceil(Math.random()*3);
		int y1= (int)Math.ceil(Math.random()*9);
		int y2= (int)Math.ceil(Math.random()*9);
		
		while(l[x1][y1]==' ' && l[x2][y2]==' ') // Vérification qu'on ne change pas une case vide avec une autre vide
		{
			y1= (int)Math.ceil(Math.random()*9);
			y2= (int)Math.ceil(Math.random()*9);
		}
		
		char tmp;
		tmp = l[x1][y1];
		l[x1][y1] = l[x2][y2];
		l[x2][y2] = tmp;
		
		return l;
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
		char a = (char)(i+97);
		char b = (char)(j+97);
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
			
		}
		else
		{
			return 0;
		}
		
		return Math.abs((Math.abs(x1-x2)+Math.abs(y1-y2)));
	}
	
	public char[][] getEtat()
	{
		return lettre;
	}
	
	public int getEnergie()
	{
		return energie;
	}
	
	public void setK(double k)
	{
		this.k = k;
	}
	
	public double temperature()
	{
		return temperature;
	}
	
	public void setTemperature(double temperature)
	{
		this.temperature=temperature;
	}
	@Override
	public String getNom() {
		return "Algorithme Recuit Simule";
	}
	
	public char[][] getTampon()
	{
		int i,j;
		for(i=0;i<4;i++)
		{
	
			for(j=0;j<10;j++)
			{
				tampon[i][j]=Character.toUpperCase(tampon[i][j]);
			}
		}
		return tampon;
	}
	
	public char[][] getMajuscule(char[][] l )
	{
		int i,j;
		for(i=0;i<4;i++)
		{
	
			for(j=0;j<10;j++)
			{
				l[i][j]=Character.toUpperCase(l[i][j]);
			}
		}
		return l;
	}
	
	public Clavier getClavier()
	{
		clavier.setClavier(getTampon());
		return clavier;
	}
	
	public ArrayList<char[][]> getParcours()
	{
		return parcours;
	}
	
	public void getClavierString(char[][] let)
	{
		StringBuilder s = new StringBuilder("");
		int i,j;
		for(i=0;i<4;i++)
		{
			s.append("|");
			for(j=0;j<10;j++)
			{
				s.append(let[i][j]+"|");
			}
			s.append("\n");
		}
		System.out.println(s.toString());
	}

	public double getTemperature() {
		return temperature;
	}
	
	public double getK() {
		return k;
	}
	
	public int getBestObj() {
		return calculEnergie(tampon);
	}

	@Override
	public int getRefresh() {
		return refresh;
	}

	@Override
	public void setRefresh(int refresh) {
		this.refresh = refresh;
		
	}

	@Override
	public int getLimite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLimite(int limite) {
		// TODO Auto-generated method stub
		
	}
	
}
