import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class System extends JFrame {

	String HostEmail = "test.m4922@gmail.com";
	String HostPhoneNo = "+918385090004";
	private ArrayList<VisitorClass> AV;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhoneNo;
	private JTextField txtCheckInTime;
	private JTextField txtCheckOutTime;
	private JTable table;
	private JTable table_1;
	private JScrollPane pane;
	static int i=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System frame = new System();
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
	
	private int seti()
	{
		i = i+1;
		return i;
	}
	
	
	private void table_update()
	{
		int column;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DbManager db = new DbManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement("Select * From Visitor");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			column = rsmd.getColumnCount();
			DefaultTableModel dfm = (DefaultTableModel)table_1.getModel();
			dfm.setRowCount(0);
			while(rs.next())
			{
				Vector vec = new Vector();
				for(int i=1;i<=column;i++)
				{
					vec.add(rs.getString("Id"));
					vec.add(rs.getString("Name"));
					vec.add(rs.getString("Email"));
					vec.add(rs.getString("PhoneNo"));
					vec.add(rs.getString("CheckInTime"));
					vec.add(rs.getString("CheckOut"));
					vec.add(rs.getString("Timestamp"));
				}
				dfm.addRow(vec);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public System() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 409);
		AV = new ArrayList<>();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setForeground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisitorEntryManagement = new JLabel("Visitor Entry Management");
		lblVisitorEntryManagement.setForeground(new Color(255, 69, 0));
		lblVisitorEntryManagement.setFont(new Font("Sanskrit Text", Font.BOLD, 19));
		lblVisitorEntryManagement.setBounds(295, 11, 260, 25);
		contentPane.add(lblVisitorEntryManagement);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(51, 51, 102));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(42, 69, 63, 25);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(167, 73, 189, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(51, 51, 153));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(42, 105, 90, 25);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(167, 109, 189, 20);
		contentPane.add(txtEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(51, 51, 102));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(42, 147, 104, 25);
		contentPane.add(lblPhoneNumber);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(167, 151, 189, 20);
		contentPane.add(txtPhoneNo);
		
		JLabel lblCheckinTime = new JLabel("Check-in Time");
		lblCheckinTime.setForeground(new Color(51, 51, 102));
		lblCheckinTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckinTime.setBounds(42, 190, 97, 25);
		contentPane.add(lblCheckinTime);
		
		txtCheckInTime = new JTextField();
		txtCheckInTime.setColumns(10);
		txtCheckInTime.setBounds(167, 194, 189, 20);
		contentPane.add(txtCheckInTime);
		
		JLabel lblCheckoutTime = new JLabel("Check-out Time");
		lblCheckoutTime.setForeground(new Color(51, 51, 102));
		lblCheckoutTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckoutTime.setBounds(42, 236, 104, 25);
		contentPane.add(lblCheckoutTime);
		
		txtCheckOutTime = new JTextField();
		txtCheckOutTime.setColumns(10);
		txtCheckOutTime.setBounds(167, 240, 189, 20);
		contentPane.add(txtCheckOutTime);
		
		table_1 = new JTable();
		JScrollPane js=new JScrollPane(table_1);
		js.setLocation(366, 69);
		js.setSize(499, 269);
		
        js.setVisible(true);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dfm_2 = (DefaultTableModel)table_1.getModel();
				int selectIndex = table_1.getSelectedRow();
				txtName.setText(dfm_2.getValueAt(selectIndex, 1).toString());
				txtEmail.setText(dfm_2.getValueAt(selectIndex, 2).toString());
				txtPhoneNo.setText(dfm_2.getValueAt(selectIndex, 3).toString());
				txtCheckInTime.setText(dfm_2.getValueAt(selectIndex, 4).toString());
				txtCheckOutTime.setText(dfm_2.getValueAt(selectIndex, 5).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Phone Number", "CheckInTime", "CheckOutTime", "TimeStamp"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Long.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(6).setPreferredWidth(100);
		table_1.setBounds(422, 69, 402, 249);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contentPane.add(js);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtEmail.setText(null);
				txtPhoneNo.setText(null);
				txtCheckInTime.setText(null);
				txtCheckOutTime.setText(null);
				txtName.requestFocus();
			}
		});
		btnClear.setBackground(Color.WHITE);
		btnClear.setForeground(Color.BLUE);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.setBounds(255, 293, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnAdd = new JButton("Check-In");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String email = txtEmail.getText();
				String phoneNo = txtPhoneNo.getText();
				String checkInTime = txtCheckInTime.getText();
				String checkOutTime = txtCheckOutTime.getText();
				try {
//					pstmt = conn.prepareStatement("Insert Into Visitor values ("+(new VisitorClass()).getId()+",'"+name+"','"+email+"',"+phoneNo+",'"+ checkInTime +"','"+checkOutTime+"','"+(new Timestamp(date.getTime())).toString()+"')");
//					pstmt.executeUpdate();
					VisitorClass visitorClass = new VisitorClass(name, phoneNo, email, checkInTime, checkOutTime, (new Timestamp(new Date().getTime())).toString());
					//visitorClass.setId(seti());
					visitorClass.addVisitor();
					table_update();
					String body = "Name - "+name+"\nPhone - "+phoneNo+"\nEmail - "+email+"\nCheckin Time - "+checkInTime+"\nCheckout Time - "+checkOutTime+"\n";
					JavaSendMail.sendMail(HostEmail, "Information about new Visitor "+name, body);
					twiliosSndSms.sendSMS(HostPhoneNo,"Information about Visitor "+name+"\n"+body);
					table_update();
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
				
//				AV.add(visitorClass);
			}
		});
		
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(42, 293, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCheckout = new JButton("Check-Out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String email = txtEmail.getText();
				String phoneNo = txtPhoneNo.getText();
				String checkInTime = txtCheckInTime.getText();
				String checkOutTime = txtCheckOutTime.getText();
				String body = "Name - "+name+"\nPhone - "+phoneNo+"\nEmail - "+email+"\nCheckin Time - "+checkInTime+"\nCheckout Time - "+checkOutTime+"\nHostName - Puru Sewda\nAddress - Jaipur,Rajasthan\n";
				try {
					JavaSendMail.sendMail(email, "Information about new Visitor "+name, body);
					twiliosSndSms.sendSMS(phoneNo,"Information about your Visit \n"+body);
				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnCheckout.setBackground(Color.WHITE);
		btnCheckout.setForeground(Color.BLUE);
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCheckout.setBounds(141, 293, 104, 23);
		contentPane.add(btnCheckout);
		table_update();
	}
}
