package optimisation.vue.recuit;



import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import optimisation.ecouteur.EcouterBoutonK;
import optimisation.ecouteur.EcouterBoutonTemperature;
import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueInfoAlgo;

@SuppressWarnings("serial")
public class VueInfoAlgoRecuit extends VueInfoAlgo{

	private JButton temperature;
	private JButton k;
	private JLabel jTemperature;
	private JLabel jK;
	protected GridLayout grid;
	
	public VueInfoAlgoRecuit(Algorithme m) {
		super(m);
		
		this.temperature = new JButton("Température");
		this.k = new JButton("Lambda");
		this.jTemperature = new JLabel("Température : "+((AlgorithmeRecuitSimule)m).getTemperature());
		this.jK = new JLabel("Lambda : "+((AlgorithmeRecuitSimule)m).getK());
		
		temperature.addActionListener(new EcouterBoutonTemperature(m,this));
		k.addActionListener(new EcouterBoutonK(m,this));
		
		temperature.setToolTipText("Permet de varier la valeur de la température");
		k.setToolTipText("Permet de varier la valeur lambda");
		
		
		grid = new GridLayout(2,2);
		this.setLayout(grid);
		
		add(temperature);
		add(jTemperature);
		add(k);
		add(jK);
		
		
	}

	@Override
	public void maj() {
		jTemperature.setText(("Température : "+((AlgorithmeRecuitSimule)m).getTemperature()));
		jK.setText(("Lambda : "+((AlgorithmeRecuitSimule)m).getK()));
		
	}

	
	//tu mets les informations qui indique les paramÃ¨tres de ton algo recuit 
	//utilise. + autre
}
