package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据维护");
		mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 19));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("图书类别管理");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("图书类别维护");
		mnNewMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("图书类别添加");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFRM bookTypeAddInterFRM=new BookTypeAddInterFRM();
				bookTypeAddInterFRM.setVisible(true);
				table.add(bookTypeAddInterFRM);
			}
		});
		mnNewMenu_2.add(menuItem_1);
		
		JMenu menu = new JMenu("图书管理");
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("图书添加");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("图书维护");
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("安全退出");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否确认退出系统？");
				if(result==0){
					dispose();
				}
			}
		});
		mnNewMenu.add(menuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("关于我们");
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 19));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("关于团队");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Java1234InterFrm java1234InterFrm=new Java1234InterFrm();
				java1234InterFrm.setVisible(true);
				table.add(java1234InterFrm);
				
			}
		});
		mnNewMenu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		table.setLayout(new BorderLayout(0, 0));
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
