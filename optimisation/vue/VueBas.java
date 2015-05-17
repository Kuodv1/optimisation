package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueBas extends JPanel implements Observer{
	
	protected Modele m;
	
	
	public VueBas(Modele m) {
		super(new BorderLayout());
		this.m = m;
		m.addObserver(this);
		String[] algoString = { "Algorithme Recuit Simule","Recherche Tabou"};
		JComboBox algoList = new JComboBox(algoString);
		
		class ecouteurComboBox implements ActionListener {
			protected Modele m;
			public ecouteurComboBox(Modele m) {
				this.m = m;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String algoName = (String)cb.getSelectedItem();
		        m.setAlgorithme(algoName);
			}
			
		}
		
		algoList.addActionListener(new ecouteurComboBox(m));
		add(algoList,BorderLayout.WEST);
			
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {

	}
}
