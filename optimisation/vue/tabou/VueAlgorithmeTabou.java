package optimisation.vue.tabou;

import java.awt.BorderLayout;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeTabou;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;

public class VueAlgorithmeTabou extends VueAlgorithme{
	
	protected VueClavier vc;
	protected AlgorithmeTabou at;
	
	public VueAlgorithmeTabou(Modele m) {
		super(m);
		at = (AlgorithmeTabou)m.getAlgo();
		vc = new VueClavier(at.getBestOf());
		this.add(vc,BorderLayout.CENTER);
	}

	@Override
	public void maj() {
		
	}

}
