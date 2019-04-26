package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Java1234InterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Java1234InterFrm frame = new Java1234InterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Java1234InterFrm() {
		getContentPane().setBackground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Java1234InterFrm.class.getResource("/images/add.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addComponent(lblNewLabel)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(lblNewLabel)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		setClosable(true);
		setTitle("关于团队");
		setBounds(100, 100, 450, 300);

	}

}
