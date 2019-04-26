package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.BookType;
import utilTools.DBUtiltool;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		
		bookTypeTable = new JTable();
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		));
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(167);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
	}
	private void fillTable(BookType bookType){
		DefaultTableModel dtm=(DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;
		try{
			con=dbUtiltool.getCon();
			ResultSet rs=bookTypeDao.list(con,bookType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				DBUtiltool.closeCon(con);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
