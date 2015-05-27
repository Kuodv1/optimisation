package optimisation.vue.recuit;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;
import optimisation.vue.VueInfo;
import optimisation.ecouteur.EcouterBoutonLance;

@SuppressWarnings("serial")
public class VueAlgorithmeRecuitSimule extends VueAlgorithme{

	protected GridLayout grid;
	protected VueClavier vc;
	protected JButton jb;
	protected JPanel jp;
	protected Thread t;
	
	protected AlgorithmeRecuitSimule ars;
	protected VueInfo vi;
	
	public VueAlgorithmeRecuitSimule(Modele m) {
		super(m);
		
		this.ars = (AlgorithmeRecuitSimule)m.getAlgo();
		vc = new VueClavier(ars.getClavier());
		//jb = new JButton("Lance");
		jp = new JPanel();
		
		//jp.add(jb);
		
		vi = new VueInfo(ars,this,new VueInfoAlgoRecuit(ars));
		this.add(vc,BorderLayout.CENTER);
		this.add(vi,BorderLayout.EAST);
		
		//jb.addActionListener(new EcouterBoutonLance(ars,this));
		//this.add(vc,BorderLayout.CENTER);
		//this.add(jp,BorderLayout.SOUTH);
		
		
	}
	
	@Override
	public void maj() {
		 t = new Thread(){
			public void run() {
				for(char[][] a : ars.getParcours()){
					  vc.majClavier(a);
					  vc.repaint();
					  vi.maj(ars);
					  vi.repaint();
				      jp.repaint(); 
				      
				      try {
				        Thread.sleep(1000);
				      } catch (InterruptedException e) {
				        e.printStackTrace();
				      }
				    }
		
				}
			
		};
		t.start();
	}
}
