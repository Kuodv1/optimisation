package optimisation.vue.tabou;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import optimisation.ecouteur.EcouteurBoutonListeTabou;
import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeTabou;
import optimisation.vue.VueInfoAlgo;

public class VueInfoAlgoTabou extends VueInfoAlgo{

	protected JLabel jl;
	protected AlgorithmeTabou at;
	
	public VueInfoAlgoTabou(Algorithme m) {
		super(m);
		at = ((AlgorithmeTabou)m);
		GridLayout gl = new GridLayout(1,2);
		this.setLayout(gl);
		JButton jb1 = new JButton("Taille liste Tabou");
		jl = new JLabel(": "+at.getTailleTabou());
		jb1.addActionListener(new EcouteurBoutonListeTabou(at,jl));
		this.add(jb1);
		this.add(jl);
	}
	
	
	@Override
	public void maj() {
		jl.setText(": "+at.getTailleTabou());
		
	}

}
