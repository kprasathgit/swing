package com.mkp.hotelroombooking.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jilaba.control.JilabaComboBox;
import com.jilaba.control.JilabaPasswordField;
import com.jilaba.control.ListItem;
import com.mkp.hotelroombooking.common.CommonValues;
import com.mkp.hotelroombooking.logic.OperatorLogic;
import com.mkp.hotelroombooking.model.Operator;

public class FrmLogin extends JFrame implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JButton btnLogin;
	private JilabaPasswordField txtPassword;
	private JilabaComboBox<String> cmbUserName;

	private JButton btnExit;
	private static String operCode;

	public static Color PRIMARY_COLOR = new Color(60, 141, 188); // Light blue
	public static final Color SECONDARY_COLOR = new Color(255, 64, 129); // Pink
	public static final Color ACCENT_COLOR = new Color(255, 193, 7); // Amber
	public static final Color BACKGROUND_COLOR = new Color(255, 255, 255); // White

	public void frmLoginLoad() {
		setBounds(0, 0, 600, 400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setTitle("Login");
		componentCreation();
		componentListeners();
		loadInitialise();
		cmbUserName.requestFocus();
	}

	private void componentListeners() {

		txtPassword.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent e) {

				if ("".equalsIgnoreCase(String.valueOf(txtPassword.getPassword()))) {

					JOptionPane.showMessageDialog(null, "Enter Password");
					txtPassword.requestFocus();
					return false;
				}
				return true;
			}

		});

	}

	private void loadInitialise() {

		cmbUserName.removeAllItems();

		try {

			OperatorLogic operatorLogic = new OperatorLogic();
			List<Operator> lstOperators = operatorLogic.operatorView();

			if (lstOperators.size() == 0) {

				JOptionPane.showMessageDialog(null, "Operator list is Empty");
				System.exit(0);
			}

			for (Operator operator : lstOperators) {
				cmbUserName.addListItem(new ListItem(operator.getOpername(), operator.getOpercode()));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error occured while adding operator name into combo box");

		}
		txtPassword.setText("");
		cmbUserName.requestFocus();

	}

	private void componentCreation() {

		JLabel lblTitle, lblUserName, lblPassword;

		int fWidth = 600, fHeight = 400;
		int compWidth = CommonValues.getCompWidth();
		int compHeight = CommonValues.getCompHeight();

		panelMain = new JPanel(null);
		panelMain.setBounds(0, 0, fWidth, fHeight);
		panelMain.setVisible(true);
		getContentPane().add(panelMain);

		lblTitle = new JLabel("***ENTER YOUR CREDENTIALS TO LOGIN***");
		lblTitle.setBounds(150, 40, 400, 10);
		lblTitle.setVisible(true);
		lblTitle.setForeground(Color.black);
		panelMain.add(lblTitle);

		lblUserName = new JLabel(" USER NAME ");
		lblUserName.setBounds(65, 140, compWidth, compHeight);
		lblUserName.setVisible(true);
		panelMain.add(lblUserName);

		cmbUserName = new JilabaComboBox<String>();
		cmbUserName.setBounds(lblUserName.getX() + 110, lblUserName.getY(), compWidth, compHeight);
		cmbUserName.addKeyListener(this);
		cmbUserName.setVisible(true);
		panelMain.add(cmbUserName);

		lblPassword = new JLabel(" PASSWORD : ");
		lblPassword.setBounds(lblUserName.getX(), lblUserName.getY() + 50, compWidth, compHeight);
		lblPassword.setVisible(true);
		panelMain.add(lblPassword);

		txtPassword = new JilabaPasswordField();
		txtPassword.setBounds(lblPassword.getX() + 110, lblPassword.getY(), compWidth, compHeight);
		txtPassword.setForeground(Color.blue);
		txtPassword.addKeyListener(this);
		txtPassword.setMaxLength(20);
		txtPassword.setVisible(true);
		panelMain.add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(lblPassword.getX() + 100, lblPassword.getY() + 60, 100, 25);
		btnLogin.setMnemonic(KeyEvent.VK_L);
		 btnLogin.setForeground(PRIMARY_COLOR);
		// btnLogin.setBackground(Color.GREEN);
		btnLogin.setBackground(PRIMARY_COLOR);
		btnLogin.addActionListener(this);
		btnLogin.setVisible(true);
		panelMain.add(btnLogin);

		btnExit = new JButton("Exit");
		btnExit.setBounds(btnLogin.getX() + 150, btnLogin.getY(), 100, 25);
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(this);
		btnExit.setVerifyInputWhenFocusTarget(false);
		btnExit.setVisible(true);
		panelMain.add(btnExit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Login":

			loginProcess();
			break;

		case "Exit":
			System.exit(1);
			break;
		default:
			break;
		}

	}

	private void loginProcess() {

		try {

			if ("".equalsIgnoreCase(String.valueOf(txtPassword.getPassword()))) {
				JOptionPane.showMessageDialog(null, "ENTER PASSWORD");
				txtPassword.requestFocus();
				return;
			}

			OperatorLogic operatorLogic = new OperatorLogic();
			if (operatorLogic.loginCheck(Integer.parseInt(String.valueOf(cmbUserName.getSelectedItemValue())),
					String.valueOf(txtPassword.getPassword()))) {

				JOptionPane.showMessageDialog(null, "Login Success");

				operCode = String.valueOf(cmbUserName.getSelectedItemValue());
				loadInitialise();
				this.dispose();
//				FrmMdi frmMdi = new FrmMdi();
//				frmMdi.setVisible(true);

			} else {

				JOptionPane.showMessageDialog(null, "Login Failed");
				txtPassword.setText("");
				txtPassword.requestFocus();
				return;

			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error Occurred During Login");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (e.getComponent() == cmbUserName) {

				txtPassword.requestFocus();
			}

			else if (e.getComponent() == txtPassword) {

				btnLogin.requestFocus();

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public static String getOperCode() {
		return operCode;
	}

}