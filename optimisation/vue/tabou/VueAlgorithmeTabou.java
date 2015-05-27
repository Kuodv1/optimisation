package optimisation.vue.tabou;

import java.awt.BorderLayout;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeTabou;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;
import optimisation.vue.VueInfo;
import optimisation.vue.VueInfoAlgo;

public class VueAlgorithmeTabou extends VueAlgorithme{
	
	protected VueClavier vc;
	protected AlgorithmeTabou at;
	protected VueInfo vi;
	
	public VueAlgorithmeTabou(Modele m) {
		super(m);
		at = (AlgorithmeTabou)m.getAlgo();
		vc = new VueClavier(at.getBestOf());
		vi = new VueInfo(at,this,new VueInfoAlgoTabou(at));
		this.add(vc,BorderLayout.CENTER);
		this.add(vi,BorderLayout.EAST);
	}

	@Override
	public void maj() {
		vi.maj(at);
	}

}
