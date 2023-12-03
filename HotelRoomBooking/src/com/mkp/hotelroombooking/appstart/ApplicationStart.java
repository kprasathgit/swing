package com.mkp.hotelroombooking.appstart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.mkp.hotelroombooking.common.CommonValues;
import com.mkp.hotelroombooking.common.DatabaseConnection;
import com.mkp.hotelroombooking.form.FrmLogin;

/**
 * Hello world!
 *
 */
@SuppressWarnings("serial")
public class ApplicationStart extends JFrame {

	private static JLabel loading;
	private static JProgressBar jProgressBar;

	 
	
	public static void main(String[] args) throws SQLException {

		try {

			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// To implement Loading screen.

			try {
				//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				
			} catch (Exception e) {
				//e.printStackTrace();
			}

			ApplicationStart applicationStart = new ApplicationStart();
			applicationStart.setVisible(true);

			for (int i = 0; i <= 50; i++) {

				jProgressBar.setValue(i);
				loading.setText("Loading.." + i + " %");
				Thread.sleep(30);
//
//							if (i == 50)
//								Thread.sleep(1000);

			}
			loading.setText("Connecting to database ..please wait...");
			 new DatabaseConnection();

			for (int i = 51; i <= 100; i++) {

				jProgressBar.setValue(i);
				loading.setText("Loading.." + i + " %");
				Thread.sleep(30);
//
//							if (i == 50)
//								Thread.sleep(1000);

			}

			applicationStart.dispose();

			FrmLogin frmLogin = new FrmLogin();
			frmLogin.frmLoginLoad();
			frmLogin.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public ApplicationStart() {

		// setBounds(500, 100, 500, 400);
		setBounds((int) (CommonValues.getFrmWidth() * 0.35), (int) (CommonValues.getFrmHeight() * 0.2),
				(int) (CommonValues.getFrmWidth() * 0.32), (int) (CommonValues.getFrmHeight() * 0.40));
		setUndecorated(true);
		setVisible(true);

		JPanel jPanel = new JPanel(null);
		jPanel.setBounds(0, 0, 500, 400);
		jPanel.setBackground(Color.BLACK);
		jPanel.setVisible(true);
		getContentPane().add(jPanel);

		JLabel jLabel = new JLabel();
		jLabel.setBounds(100, 10, 400, 200);
		jLabel.setVisible(true);
		jPanel.add(jLabel);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/pika.gif"));
		jLabel.setIcon(imageIcon);

		loading = new JLabel();
		loading.setBounds(120, 250, 350, 20);
		loading.setHorizontalAlignment(SwingConstants.LEFT);
		loading.setFont(new Font("consolas", Font.BOLD, 15));
		loading.setForeground(Color.orange);
		jPanel.add(loading);

		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(20, 300, 450, 16);
		jProgressBar.setBackground(Color.GREEN);
		jPanel.add(jProgressBar);

	}
}