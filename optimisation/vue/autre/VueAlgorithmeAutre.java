package optimisation.vue.autre;

import java.awt.BorderLayout;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeAutre;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;

public class VueAlgorithmeAutre extends VueAlgorithme{
	
	protected VueClavier vc;
	protected AlgorithmeAutre aa;
	
	public VueAlgorithmeAutre(Modele m) {
		super(m);
		aa = (AlgorithmeAutre)m.getAlgo();
		vc = new VueClavier(aa.getBestOf());
		this.add(vc,BorderLayout.CENTER);
	}

	@Override
	public void maj() {
		
	}

}
