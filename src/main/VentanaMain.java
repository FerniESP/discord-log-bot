package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import discordBOT.DiscordBOT;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaMain {

	private JFrame frmLogbotAdminPanel;
	private static DiscordBOT robot = new DiscordBOT();
	private boolean botActivo = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMain window = new VentanaMain();
					window.frmLogbotAdminPanel.setVisible(true);
					robot.iniciarBOT();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogbotAdminPanel = new JFrame();
		frmLogbotAdminPanel.setTitle("LogBOT Admin panel");
		frmLogbotAdminPanel.setBounds(100, 100, 450, 300);
		frmLogbotAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmLogbotAdminPanel.getContentPane().setLayout(springLayout);
		
		JLabel lblOn = new JLabel("ON");
		lblOn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOn.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblOn, 10, SpringLayout.NORTH, frmLogbotAdminPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblOn, 10, SpringLayout.WEST, frmLogbotAdminPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblOn, 251, SpringLayout.NORTH, frmLogbotAdminPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblOn, 424, SpringLayout.WEST, frmLogbotAdminPanel.getContentPane());
		frmLogbotAdminPanel.getContentPane().add(lblOn);
	}
}
