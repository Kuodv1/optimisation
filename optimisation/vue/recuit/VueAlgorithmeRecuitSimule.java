package optimisation.vue.recuit;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;
import optimisation.ecouteur.EcouterBoutonLance;

@SuppressWarnings("serial")
public class VueAlgorithmeRecuitSimule extends VueAlgorithme{

	protected GridLayout grid;
	protected VueClavier vc;
	protected JButton jb;
	protected JPanel jp;
	
	protected AlgorithmeRecuitSimule ars;
	
	public VueAlgorithmeRecuitSimule(Modele m) {
		super(m);
		
		this.ars = (AlgorithmeRecuitSimule)m.getAlgo();
		vc = new VueClavier(ars.getClavier());
		jb = new JButton("Lance");
		jp = new JPanel();
		
		jp.add(jb);
		
		jb.addActionListener(new EcouterBoutonLance(ars,this));
		this.add(vc,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		
		
	}
	
	@Override
	public void maj() {
		vc.majClavier(ars.getTampon());
	}

}
