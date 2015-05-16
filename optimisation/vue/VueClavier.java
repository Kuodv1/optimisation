package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import optimisation.modele.Clavier;

public class VueClavier extends JPanel{

	protected GridLayout grid;
	protected JLabel[][] tabLabel;
	
	public VueClavier(Clavier cl) {
		super(new BorderLayout());
		//this.setPreferredSize(new Dimension(200,50));
		grid = new GridLayout(4,10);
		tabLabel = new JLabel[4][10];
		grid.setHgap(2);
		grid.setVgap(2);
		this.setBackground(Color.BLACK);
		this.setLayout(grid);
		char [][] clavier = cl.getClavier();
		for(int i = 0; i < 4;i++) {
			for(int j = 0; j<10;j++) {
				JLabel eltAdd = new JLabel(clavier[i][j]+"",SwingConstants.CENTER);
				eltAdd.setBackground(Color.WHITE);
				eltAdd.setOpaque(true);
				this.add(eltAdd);
				tabLabel[i][j] = eltAdd;
			}
		}
		
	//	majClavier(clavier);
	}
	
	
	//Fonction pour changer le contenu du clavier via un clavier
	public void majClavier(char[][] newClavier) {
		for(int i = 0; i<4;i++) {
			for(int j = 0; j<10;j++) {
				tabLabel[i][j].setText(newClavier[i][j]+"");
			}
		}
	}
}
