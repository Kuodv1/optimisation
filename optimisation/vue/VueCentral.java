package optimisation.vue;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import optimisation.modele.Modele;
import optimisation.vue.tabou.VueAlgorithmeTabou;
import optimisation.vue.recuit.VueAlgorithmeRecuitSimule;

public class VueCentral extends JPanel implements Observer{

	protected Modele m;
	protected VueAlgorithme va;
	
	public VueCentral(Modele m) {
		super(new BorderLayout());
		va = new VueAlgorithmeRecuitSimule(m);
		m.addObserver(this);
		this.m = m;
		this.add(va);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {

		if(m.getCodeUpdate()==1) {

			  //new Thread(new Runnable() {
			  //    public void run() {
						remove(va);
				    	  if(m.getNomAlgo().equals("Algorithme Recuit Simule")) {
					    	  VueAlgorithmeRecuitSimule vgs = new VueAlgorithmeRecuitSimule(m);
					    	  va = vgs;
					    	  //this.add(vg,BorderLayout.CENTER);
				    	  } else if(m.getNomAlgo().equals("Recherche Tabou")){
				    		  VueAlgorithmeTabou vat = new VueAlgorithmeTabou(m);
				    		  va = vat;
				    	  }
			    	  add(va,BorderLayout.CENTER);
			    	  va.repaint();
			    	  va.validate();
			    	  repaint();
			    	  validate();
			      //}
			 // }).start();
	
		}
		
	}
	
}
