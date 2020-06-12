package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import model.CardMessage;
import dao.CardDao;

public class CardMessageFrm extends JInternalFrame {
	private JTextField seasrchcardnametextField;
	private JTable cardlisttable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardMessageFrm frame = new CardMessageFrm();
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
	public CardMessageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5361\u724C\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 721, 549);
		
		JLabel label = new JLabel("\u5361\u724C\u540D\u79F0\uFF1A");
		
		seasrchcardnametextField = new JTextField();
		seasrchcardnametextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardMessage sc=new CardMessage();
				sc.setName(seasrchcardnametextField.getText().toString());
				setTable(sc);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(36)
							.addComponent(seasrchcardnametextField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(searchButton)
							.addGap(227))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
							.addGap(51))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(seasrchcardnametextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		
		cardlisttable = new JTable();
		cardlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5361\u7247\u7F16\u53F7", "\u5361\u7247\u540D\u79F0", "ATK", "DEF", "\u5361\u7247\u6548\u679C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		cardlisttable.getColumnModel().getColumn(2).setPreferredWidth(46);
		cardlisttable.getColumnModel().getColumn(3).setPreferredWidth(52);
		cardlisttable.getColumnModel().getColumn(4).setPreferredWidth(149);
		scrollPane.setViewportView(cardlisttable);
		getContentPane().setLayout(groupLayout);
		setTable(new CardMessage());

	}
	private void setTable(CardMessage cardmessage){
		DefaultTableModel dft=(DefaultTableModel) cardlisttable.getModel();
		dft.setRowCount(0);
		CardDao carddao=new CardDao();
		List<CardMessage> cardList=carddao.getCardList(cardmessage);
		for(CardMessage sc:cardList){
			Vector v=new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getAtk());
			v.add(sc.getDef());
			v.add(sc.getInfo());
			dft.addRow(v);
			
		}
		
		
		
	}
}
