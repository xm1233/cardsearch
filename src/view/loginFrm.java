package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.UserType;
import util.Stringutil;
import dao.AdminDao;

public class loginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField passwordtextField;
	private JComboBox userTypecomboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrm frame = new loginFrm();
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
	public loginFrm() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 11, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("\u5361\u7247\u67E5\u8BE2\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		label.setFont(new Font("黑体", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		
		usernametextField = new JTextField();
		usernametextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		usernametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B");
		
		userTypecomboBox = new JComboBox();
		userTypecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userTypecomboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN}));
		userTypecomboBox.setFont(new Font("SimSun", Font.PLAIN, 15));
		
		JButton loginbutton = new JButton("\u767B\u5F55");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		
		JButton resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(120))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(label_1)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(15)
								.addComponent(label_2))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(userTypecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passwordtextField)
						.addComponent(usernametextField, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
					.addContainerGap(128, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(loginbutton)
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addComponent(resetbutton)
					.addGap(63))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(label)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(usernametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginbutton)
						.addComponent(resetbutton)))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName=usernametextField.getText().toString();
		String password=passwordtextField.getText().toString();
		UserType selectedItem=(UserType)userTypecomboBox.getSelectedItem();
		if(Stringutil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		if(Stringutil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		Admin admin=null;
		if("系统管理员".equals(selectedItem.getName())){
			AdminDao adminDao=new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin=adminDao.login(adminTmp);
			adminDao.closeDao();;
			if(admin==null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】:"+admin.getName()+"登录");
			this.dispose();
			new Mainfrm(selectedItem,admin).setVisible(true);;
		}
		else if("教师".equals(selectedItem.getName())){
			
		}else{
			
		}
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		usernametextField.setText("");
		passwordtextField.setText("");
		userTypecomboBox.setSelectedIndex(0);
	}
}
