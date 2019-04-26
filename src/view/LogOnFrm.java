package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import utilTools.DBUtiltool;
import utilTools.StringUtil;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private DBUtiltool dbUtil = new DBUtiltool();
	private UserDao userDao=new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		//改变系统默认环境
		Font font = new Font("Dialog",Font.PLAIN,12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = (Object) keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource){
				UIManager.put(key, font);
			}
		}
		
		
		setResizable(false);
		setTitle("管理员登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("图书管理系统");
		label.setFont(new Font("宋体", Font.BOLD, 19));
		
		JLabel label_1 = new JLabel("用户名：");
		
		JLabel label_2 = new JLabel("密  码：");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)
									.addGap(18))
								.addComponent(passwordTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
					.addGap(137))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(StringUtil.IsEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.IsEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser!=null){
				//JOptionPane.showMessageDialog(null, "登陆成功");
				dispose();
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				dbUtil.closeCon(con);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
