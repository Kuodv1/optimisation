package optimisation.vue.autre;

import java.awt.BorderLayout;

import optimisation.modele.Modele;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;

public class VueAlgorithmeAutre extends VueAlgorithme{
	
	protected VueClavier vc;
	
	public VueAlgorithmeAutre(Modele m) {
		super(m);
		vc = new VueClavier();
		this.add(vc,BorderLayout.CENTER);
	}

	@Override
	public void maj(Modele m) {
		// TODO Auto-generated method stub
		
	}

}
