package app;


import java.util.List;

import javax.swing.JFrame;

import gui.MainFrame;
import utils.Entity;
import utils.Storage;

public class Main {

	
	public static void main (String[] args) {
		MainFrame mf = MainFrame.getInstance();
	      JFrame frame = new JFrame ("App");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add (mf);
	      frame.pack();
	      frame.setVisible (true);
	      frame.setLocationRelativeTo(null);
	  }
}

