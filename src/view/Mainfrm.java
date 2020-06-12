package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserType;

public class Mainfrm extends JFrame {

	private JPanel contentPane;
	public static UserType userType;
	public static Object userObject;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainfrm frame = new Mainfrm(null,null);
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
	public Mainfrm(UserType userType,Object userObject) {
		this.userType=userType;
		this.userObject=userObject;
		setTitle("\u5361\u724C\u641C\u7D22\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 675);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Mainfrm.this, "确定退出？")==JOptionPane.OK_OPTION){
			           System.exit(0);
		}
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u5361\u724C\u641C\u7D22");
		menuBar.add(menu_2);
		
		JMenuItem cardAddNewMenuItem_1 = new JMenuItem("\u5361\u724C\u6DFB\u52A0");
		cardAddNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}

			
		});
		menu_2.add(cardAddNewMenuItem_1);
		
		JMenuItem cardListNewMenuItem_2 = new JMenuItem("\u5361\u724C\u5217\u8868");
		cardListNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardMessageFrm cm=new CardMessageFrm();
				cm.setVisible(true);
				desktopPane.add(cm);
			}
		});
		menu_2.add(cardListNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		mnNewMenu.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(135, 206, 235));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}
	private void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		CardAddFrm s=new CardAddFrm();
		s.setVisible(true);
		desktopPane.add(s);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditpasswordFrm editPasswordFrm=new EditpasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
		
	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info="                    _小套路\n";
				info+="https://space.bilibili.com/303713750";
		String[] buttons={"迫不及待去看看","不想去"};
		int rst=JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, buttons, null);
		if(rst==0){
			try{
				URI uri=new URI("https://space.bilibili.com/303713750");
				Desktop.getDesktop().browse(uri);
			}catch(Exception e){
				e.printStackTrace();
			}
			}
			else{
				JOptionPane.showMessageDialog(this, "不去");
			}
			
		}

}
