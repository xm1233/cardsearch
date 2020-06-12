package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.Admin;
import util.Stringutil;
import dao.AdminDao;



public class EditpasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordtextField;
	private JTextField newPasswordtextField;
	private JTextField confirmPasswordtextField;
	private JLabel currentUserlblSss;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				EditpasswordFrm frame = new EditpasswordFrm();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public EditpasswordFrm() {
		setTitle("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		
		oldPasswordtextField = new JTextField();
		oldPasswordtextField.setColumns(10);
		
		newPasswordtextField = new JTextField();
		newPasswordtextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		confirmPasswordtextField = new JTextField();
		confirmPasswordtextField.setColumns(10);
		
		JButton submitbutton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitedit(e);
				
			}
		});
		
		JButton resetbtnNewButton = new JButton("\u91CD\u7F6E");
		resetbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restvalue(ae);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		
		currentUserlblSss = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(248, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(174))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(submitbutton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(resetbtnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(newPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(confirmPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(oldPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(currentUserlblSss))))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(currentUserlblSss))
					.addGap(18)
					.addComponent(label)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(oldPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(newPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(confirmPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitbutton)
						.addComponent(resetbtnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(Mainfrm.userType.getName())){
			Admin admin=(Admin)Mainfrm.userObject;
			currentUserlblSss.setText("[系统管理员]"+admin.getName());
		}
		
	}

	protected void submitedit(ActionEvent e) {
		String oldpassword=oldPasswordtextField.getText().toString();
		String newpassword=newPasswordtextField.getText().toString();
		String confirmpassword=confirmPasswordtextField.getText().toString();
		if(Stringutil.isEmpty(oldpassword)){
			JOptionPane.showMessageDialog(this, "请输入旧密码");
			return;
		}
		if(Stringutil.isEmpty(newpassword)){
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if(newpassword.equals(oldpassword)){
			JOptionPane.showMessageDialog(this, "新密码不能与旧密码一致");
			return;
		}
		if(Stringutil.isEmpty(confirmpassword)){
			JOptionPane.showMessageDialog(this, "请确认密码");
			return;
		}
		if(!confirmpassword.equals(newpassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}
		if("系统管理员".equals(Mainfrm.userType.getName())){
			AdminDao adminDao=new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin=(Admin)Mainfrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setPassword(oldpassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newpassword));
			return;
		}
		
		
		
		
	}

	protected void restvalue(ActionEvent ae) {
		    newPasswordtextField.setText("");
			confirmPasswordtextField.setText("");
			oldPasswordtextField.setText("");
	}
}
