package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Entity;
import utils.Storage;
import utils.StorageJSONImpl;



public class MainFrame extends JPanel {
  private JTextField tfPath;
  private JButton btnPath;
  private JButton btnSearch;
  private JTextField tfSearch;
  private JButton btnAdd;
  private JButton btnDelete;
  private JLabel lbSorted;
  private JCheckBox cbAscending;
  private JCheckBox cbDescending;
  private JList jList;
  private static MainFrame instance = null;
  private DefaultListModel<Entity> listModel = new DefaultListModel<>();
  private JLabel lbSort;
  private JTextField tfSort;
  private Storage storage;

  public MainFrame() {
      //construct preComponents
      
      storage = new StorageJSONImpl();
      //construct components
      tfPath = new JTextField (5);
      btnPath = new JButton ("Save path");
      btnSearch = new JButton ("Search");
      tfSearch = new JTextField (5);
      btnAdd = new JButton ("Add New");
      btnDelete = new JButton ("Delete");
      lbSorted = new JLabel ("Sorted:");
      cbAscending = new JCheckBox ("Ascending");
      cbDescending = new JCheckBox ("Descending");
      jList = new JList (listModel);
      lbSort = new JLabel();
      tfSort = new JTextField();

      //adjust size and set layout
      setPreferredSize (new Dimension (746, 574));
      setLayout (null);

      //add components
      add (tfPath);
      add (btnPath);
      add (btnSearch);
      add (tfSearch);
      add (btnAdd);
      add (btnDelete);
      add (lbSorted);
      add (cbAscending);
      add (cbDescending);
      add (jList);
      add(tfSort);
      add(lbSort);

      //set component bounds (only needed by Absolute Positioning)
      tfPath.setBounds (15, 20, 590, 30);
      btnPath.setBounds (625, 20, 100, 25);
      btnSearch.setBounds (125, 60, 100, 25);
      tfSearch.setBounds (15, 60, 100, 25);
      btnAdd.setBounds (500, 60, 100, 25);
      btnDelete.setBounds (625, 60, 100, 25);
      lbSorted.setBounds (235, 60, 45, 25);
      cbAscending.setBounds (285, 60, 100, 25);
      cbDescending.setBounds (385, 60, 100, 25);
      jList.setBounds (15, 115, 710, 455);
      tfSort.setBounds(285,85,185,25);
      
      
      btnSearch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			listModel.removeAllElements();
			if(cbAscending.isSelected())
				listModel.addAll(storage.getEntitiesSorted(tfSearch.getText(), tfSort.getText(), true));
			else if(cbDescending.isSelected())
				listModel.addAll(storage.getEntitiesSorted(tfSearch.getText(), tfSort.getText(), false));
			else
				listModel.addAll(storage.getEntities(tfSearch.getText()));
			jList.updateUI();
			
		}
	});
      cbAscending.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbDescending.isSelected())
			{
				cbDescending.setSelected(false);
			}
			
		}
	});
      cbDescending.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (cbAscending.isSelected())
				cbAscending.setSelected(false);
		}
	});
      btnDelete.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			storage.removeEntity(((Entity)jList.getSelectedValue()).getId());
			listModel.removeElement(((Entity)jList.getSelectedValue()));
			jList.updateUI();
		}
	});
      btnPath.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(tfPath.getText().endsWith(".json"))
				storage.initNew(tfPath.getText());
			else
				System.err.println("Wrong file");
//			if(tfPath.getText().endsWith(".yml"))
//				storage.initNew(tfPath.getText());
//			else
//				System.err.println("Wrong file");
		}
	});
      btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddNewForm().show();
		}
	});
  }
  
  public static MainFrame getInstance() {
	if(instance == null) instance = new MainFrame();
	return instance;
  }

  public Storage getStorage() {
	return storage;
}
  
}

