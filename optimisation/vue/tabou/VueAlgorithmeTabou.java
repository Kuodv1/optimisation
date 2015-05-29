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
	protected Thread t;
	
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

		 Thread t = new Thread(){
			public void run() {
				at.tabou();
			}
		 };
		t.start();
		System.out.println("ta mère");
		System.out.println("coucou");
		 Thread t2 = new Thread(){
			public void run() {
				while((!at.estFini())) {
					System.out.println("je boucle");
					vc.majClavier(at.getBestOf().getClavier());
					vc.repaint();
					vc.validate();
					vi.maj(at);
					vi.validate();
					vi.repaint();
					
				      try {
					        Thread.sleep(100);
					      } catch (InterruptedException e) {
					        e.printStackTrace();
					      }
					
					
				}
			}
		 };
		t2.start();

	}

}
