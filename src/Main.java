import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class Main {

	private JFrame frame;
	private JTextField moneyT;
	private JRadioButton cokeRB;
	private JRadioButton pepsiRB;
	private JRadioButton sodaRB;
	private JLabel coke;
	private JLabel pepsi;
	private JLabel soda;
	private JTextField cokeS;
	private JTextField pepsiS;
	private JTextField sodaS;
	private JLabel changet;
	private JTextField changeT;
	private JButton btnTakeChange;
	public int cokeStock = 10;
	public int pepsiStock = 10;
	public int sodaStock = 10;
	double moneyValue = 0;
	double money = 0;
	double change;
	double penny = 0;
	double nickel = 0;
	double dime = 0;
	double quarter = 0;
	double cokeP = 25, pepsiP = 35, sodaP = 45;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main app = new Main();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 51, 51));
		frame.setBounds(100, 100, 556, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VENDING MACHINE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 11, 303, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 51, 51));
		panel.setBounds(33, 231, 215, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		cokeRB = new JRadioButton("Coke \u20B125");
		cokeRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cokeRB.isSelected()) {
					pepsiRB.setSelected(false);
					sodaRB.setSelected(false);
				}
			}
		});
		cokeRB.setBounds(22, 7, 109, 23);
		panel.add(cokeRB);
		
		pepsiRB = new JRadioButton("Pepsi \u20B135");
		pepsiRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pepsiRB.isSelected()) {
					cokeRB.setSelected(false);
					sodaRB.setSelected(false);
				}
			}
		});
		pepsiRB.setBounds(22, 33, 109, 23);
		panel.add(pepsiRB);
		
		sodaRB = new JRadioButton("Soda \u20B145");
		sodaRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sodaRB.isSelected()) {
					cokeRB.setSelected(false);
					pepsiRB.setSelected(false);
				}
			}
		});
		sodaRB.setBounds(22, 59, 109, 23);
		panel.add(sodaRB);
		
		coke = new JLabel("Coke Stock: ");
		coke.setForeground(new Color(255, 255, 255));
		coke.setBounds(22, 102, 80, 14);
		panel.add(coke);
		
		pepsi = new JLabel("Pepsi Stock: ");
		pepsi.setForeground(new Color(255, 255, 255));
		pepsi.setBounds(22, 127, 80, 14);
		panel.add(pepsi);
		
		soda = new JLabel("Soda Stock: ");
		soda.setForeground(new Color(255, 255, 255));
		soda.setBounds(22, 152, 80, 14);
		panel.add(soda);
		
		cokeS = new JTextField();
		cokeS.setEditable(false);
		cokeS.setText("10");
		cokeS.setBounds(105, 99, 31, 20);
		panel.add(cokeS);
		cokeS.setColumns(10);
		
		pepsiS = new JTextField();
		pepsiS.setEditable(false);
		pepsiS.setText("10");
		pepsiS.setBounds(105, 124, 31, 20);
		panel.add(pepsiS);
		pepsiS.setColumns(10);
		
		sodaS = new JTextField();
		sodaS.setEditable(false);
		sodaS.setText("10");
		sodaS.setBounds(105, 149, 31, 20);
		panel.add(sodaS);
		sodaS.setColumns(10);
		
		final JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setForeground(SystemColor.desktop);
		btnPurchase.setBackground(SystemColor.menu);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				money = Double.parseDouble(moneyT.getText());
				
				if(cokeRB.isSelected()) {
					money = money - cokeP;
				}
					else if(pepsiRB.isSelected()) {
					money = money - pepsiP;
				}
					else if(sodaRB.isSelected()) {
					money = money - sodaP;
				}
				else {
					JOptionPane.showMessageDialog(null, "Please pick a Product!");
					return;
				}
				
				if(money < 0) {
					JOptionPane.showMessageDialog(null, "You do not have enough money!");
					return;
				}
				
				else {

			    	  if(cokeRB.isSelected()) {
			    		  if(money < 0) {
			    			  cokeS.setText("");
			    		  }
			 	 	         if(cokeStock <= 0) {
			 	 	        	 JOptionPane.showMessageDialog(null, "Coke is out of stock!");
			 	 	        	 return;
			 	 	         }
			    			  --cokeStock; 
			 	 	         cokeS.setText(cokeStock + ""); 
			    	  }
			    	  else if (pepsiRB.isSelected()) {
			    		  if(pepsiStock <= 0) {
			    			 JOptionPane.showMessageDialog(null, "Pepsi is out of stock!");
				 	         return;
				 	         }
			    		  --pepsiStock;
			    		  pepsiS.setText(pepsiStock + "");
			    	  }
			    	  else if (sodaRB.isSelected()) {
			    		  if(sodaStock <= 0) {
					 	         JOptionPane.showMessageDialog(null, "Soda is out of stock!");
					 	  return;
				    		  	}
			    		  --sodaStock;
			    		  sodaS.setText(sodaStock + "");
			    	  }
			    	  
					JOptionPane.showMessageDialog(null, "This is your change: ₱" + money);
					
					changeT.setText("" + money);
					
					money = money * 0;
					moneyT.setText("" +money);
					 
					btnPurchase.setEnabled(false);
				}
				
						 
			}
		}
					);
		btnPurchase.setBounds(33, 455, 89, 23);
		frame.getContentPane().add(btnPurchase);
		BtnCountStock listener = new BtnCountStock();
	    btnPurchase.addActionListener(listener);
		
		JButton btnNewButton_1 = new JButton("Refund");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 	
				
				money = Double.parseDouble(moneyT.getText());
				
				cokeRB.setSelected(false);
				pepsiRB.setSelected(false);
				sodaRB.setSelected(false);
				
				if(money > 0) {
					JOptionPane.showMessageDialog(null, "You got your money back: ₱" + money );
					
					money = money * 0;
					
					moneyT.setText("" + money);
				}
				else {
					JOptionPane.showMessageDialog(null, "You haven't entered your money");
				}
			}
		});
		btnNewButton_1.setBounds(132, 455, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cash Inserted:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(31, 174, 120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		moneyT = new JTextField();
		moneyT.setEditable(false);
		moneyT.setBounds(33, 190, 44, 20);
		frame.getContentPane().add(moneyT);
		moneyT.setColumns(10);
		
		final JButton resetbtn = new JButton("Reset");
		resetbtn.setForeground(SystemColor.desktop);
		resetbtn.setBackground(SystemColor.menu);
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cokeRB.setSelected(false);
				pepsiRB.setSelected(false);
				sodaRB.setSelected(false);
				changeT.setText(" ");
				money = money * 0;
				moneyT.setText(" ");
				btnPurchase.setEnabled(true);
			}
		});
		resetbtn.setBounds(433, 455, 89, 23);
		frame.getContentPane().add(resetbtn);
		
		btnTakeChange = new JButton("Take Change");
		btnTakeChange.setForeground(SystemColor.desktop);
		btnTakeChange.setBackground(SystemColor.menu);
		btnTakeChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				change = Double.parseDouble(changeT.getText());
				
				if(change <= 0) {
					JOptionPane.showMessageDialog(null, "You don't have change");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "You took your change: ₱" + change );
					changeT.setText(" ");
					btnPurchase.setEnabled(true);
				}
			}
		});
		btnTakeChange.setBounds(307, 355, 118, 23);
		frame.getContentPane().add(btnTakeChange);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(153, 51, 51));
		panel_1.setBounds(307, 231, 215, 113);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		changet = new JLabel("Change:");
		changet.setForeground(new Color(255, 255, 255));
		changet.setHorizontalAlignment(SwingConstants.CENTER);
		changet.setBounds(10, 45, 94, 14);
		panel_1.add(changet);
		
		changeT = new JTextField();
		changeT.setBounds(103, 42, 86, 20);
		panel_1.add(changeT);
		changeT.setEditable(false);
		changeT.setColumns(10);
		
		JLabel lblTakeChange = new JLabel("Please take your change");
		lblTakeChange.setForeground(new Color(255, 255, 255));
		lblTakeChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeChange.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTakeChange.setBounds(10, 70, 195, 26);
		panel_1.add(lblTakeChange);
		
		JButton btnPenny = new JButton("₱1");
		btnPenny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money += 1;
				moneyT.setText(money+ "");
			}
		});
		btnPenny.setBounds(43, 96, 108, 23);
		frame.getContentPane().add(btnPenny);
		
		
		JButton btnNickel = new JButton("₱5");
		btnNickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money += 5;
				moneyT.setText(money+ "");
			}
		});
		btnNickel.setBounds(43, 130, 111, 23);
		frame.getContentPane().add(btnNickel);
		
		JButton btnDime = new JButton("₱10");
		btnDime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money += 10;
				moneyT.setText(money+ "");
			}
		});
		btnDime.setBounds(170, 96, 111, 23);
		frame.getContentPane().add(btnDime);
		
		JButton btnQuarter = new JButton("₱25");
		btnQuarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money += 25;
				moneyT.setText(money+ "");
			}
		});
		btnQuarter.setBounds(170, 130, 111, 23);
		frame.getContentPane().add(btnQuarter);
		
		JLabel lblNewLabel_7 = new JLabel("Press Inserted Cash: ");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(43, 71, 133, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("CocaCola");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Script MT Bold", Font.ITALIC, 60));
		lblNewLabel_2.setBounds(291, 78, 230, 87);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	private class BtnCountStock implements ActionListener {
	      public void actionPerformed(ActionEvent evt) {
	    	  
			
	         
	      }
	}
}
