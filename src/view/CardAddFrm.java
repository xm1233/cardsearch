package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.CardMessage;
import util.Stringutil;
import dao.CardDao;

public class CardAddFrm extends JInternalFrame {
	private JTextField cardNametextField;
	private JTextArea CardInfotextArea;
	private JTextField ATKtextField;
	private JTextField DEFtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardAddFrm frame = new CardAddFrm();
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
	public CardAddFrm() {
		setTitle("\u6DFB\u52A0\u5361\u724C\u4FE1\u606F");
		setBounds(100, 100, 450, 369);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u5361\u7247\u540D\u79F0\uFF1A");
		
		cardNametextField = new JTextField();
		cardNametextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cardNametextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5361\u7247\u6548\u679C\uFF1A");
		
		CardInfotextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				submitClass(a);
			}
		});
		
		JButton resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				resetValue(a);
			}
		});
		
		JLabel lblNewLabel = new JLabel("ATK:");
		
		JLabel lblNewLabel_1 = new JLabel("DEF\uFF1A");
		
		ATKtextField = new JTextField();
		ATKtextField.setColumns(10);
		
		DEFtextField = new JTextField();
		DEFtextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetbutton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1)
											.addComponent(lblNewLabel)))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(4)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cardNametextField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addComponent(DEFtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CardInfotextArea, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(ATKtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(240))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cardNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ATKtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(DEFtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(CardInfotextArea, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetbutton)
						.addComponent(submitButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent a) {
		// TODO Auto-generated method stub
		String cardname=cardNametextField.getText().toString();
		String cardatk=ATKtextField.getText().toString();
		String carddef=DEFtextField.getText().toString();
		String cardinfo=CardInfotextArea.getText().toString();
		if(Stringutil.isEmpty(cardname)){
			JOptionPane.showMessageDialog(this, "卡牌名称不能为空");
			return;
		}  
		if(Stringutil.isEmpty(cardatk)){
			JOptionPane.showMessageDialog(this, "攻击力不能为空");
			return;
		}
		if(Stringutil.isEmpty(carddef)){
			JOptionPane.showMessageDialog(this, "守备力不能为空");
			return;
		}
		CardMessage cm1=new CardMessage();
		cm1.setName(cardname);
		cm1.setAtk(cardatk);
		cm1.setDef(carddef);
		cm1.setInfo(cardinfo);
		CardDao carddao=new CardDao();
		if(carddao.addClass(cm1)){
			JOptionPane.showMessageDialog(this, "卡牌添加成功");
	}else{
		JOptionPane.showMessageDialog(this, "卡牌添加失败");
	}
		resetValue(a);
	}

	protected void resetValue(ActionEvent a) {
		// TODO Auto-generated method stub
		cardNametextField.setText("");
		ATKtextField.setText("");
		DEFtextField.setText("");
		CardInfotextArea.setText("");
		
	}
}
