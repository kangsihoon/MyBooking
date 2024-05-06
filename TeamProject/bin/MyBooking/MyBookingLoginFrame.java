package MyBooking;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.tools.javac.Main;

class logFrame extends JFrame implements ActionListener {
	
	MemberDAO Mbdao = new MemberDAO();
	ManegerDAO Mgdao = new ManegerDAO();
	
	Container container = getContentPane();

	JCheckBox checkManager = new JCheckBox("관리자 로그인");

	JLabel labelId = new JLabel("아이디 ", JLabel.RIGHT);
	JLabel labelPw = new JLabel("비밀번호 ", JLabel.RIGHT);
	JLabel labelLogo = new JLabel();

	JTextField textId = new JTextField(10);
	JTextField textPw = new JTextField(10);

	JButton buttonLogin = new JButton("로그인");
	JButton buttonFind = new JButton("아이디/비밀번호\n 찾기");
	JButton buttonJoin = new JButton("회원가입");

	JPanel panelLogo = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelCheck = new JPanel();
	JPanel panelId = new JPanel();
	JPanel panelPw = new JPanel();
	JPanel panelLogin = new JPanel();
	JPanel panelButton = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelIdPwLog = new JPanel();
	JPanel panelIdId = new JPanel();
	JPanel panelPwPw = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();

	public logFrame() {
		setSize(400, 600);
		setLocation(1000, 100);
		setTitle("My Booking");
		init();
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panelLogo);
		container.add("Center", panelCenter);
		container.add("South", panelSouth);

		panelLogo.setLayout(new BorderLayout());
		panelLogo.add(labelLogo);

		labelLogo.setIcon(new ImageIcon("img/MyBookingLogo.jpg"));
		labelLogo.setPreferredSize(new Dimension(400, 200));

		panelCenter.setLayout(new GridLayout(3, 1, 10, 5));
		panelCenter.setBackground(Color.white);
		panelCenter.add(panelCheck);
		panelCenter.add(panel1);
		panelCenter.add(panelButton);

		panelCheck.setLayout(new BorderLayout());
		panelCheck.add("North", panel5);
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(400, 40));
		panelCheck.add("West", panel4);
		panel4.setBackground(Color.white);
		panel4.setPreferredSize(new Dimension(85, 20));
		panelCheck.add("Center", checkManager);
		checkManager.setBackground(Color.white);

		panel1.setLayout(new BorderLayout());
		panel1.setBackground(Color.white);
		panel1.add("West", panel2);
		panel1.add("Center", panelIdPwLog);
		panel1.add("East", panel3);

		panel2.setPreferredSize(new Dimension(30, 50));
		panel3.setPreferredSize(new Dimension(40, 50));
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);

		panelIdPwLog.setLayout(new BorderLayout(5, 5));
		panelIdPwLog.add("East", panelLogin);
		panelIdPwLog.add("West", panelIdId);
		panelIdPwLog.add("Center", panelPwPw);
		panelIdPwLog.setBackground(Color.white);

		panelIdId.setLayout(new GridLayout(2, 1, 0, 5));
		panelIdId.setBackground(Color.white);
		panelIdId.add(labelId);
		panelIdId.add(labelPw);

		panelPwPw.setLayout(new GridLayout(2, 1, 0, 5));
		panelPwPw.setBackground(Color.white);
		panelPwPw.add(textId);
		panelPwPw.add(textPw);

		panelLogin.setLayout(new BorderLayout());
		panelLogin.add(buttonLogin);
		buttonLogin.setBackground(new Color(98, 99, 212));
		buttonLogin.setForeground(Color.white);
		buttonLogin.setFocusPainted(false);

		panelButton.setLayout(new FlowLayout());
		panelButton.setBackground(Color.white);
		panelButton.add(buttonFind);
		panelButton.add(buttonJoin);
		buttonFind.setBorderPainted(false);
		buttonFind.setBackground(Color.white);
		buttonFind.setFocusPainted(false);
		buttonJoin.setBorderPainted(false);
		buttonJoin.setBackground(Color.white);
		buttonJoin.setFocusPainted(false);

		panelSouth.setPreferredSize(new Dimension(400, 120));
		panelSouth.setBackground(Color.white);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		buttonFind.addActionListener(this);
		buttonJoin.addActionListener(this);
		buttonLogin.addActionListener(this);
		checkManager.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonLogin) {
			String ID = textId.getText();
			String PW = textPw.getText();

			if (textId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.", "Error", JOptionPane.WARNING_MESSAGE);
			} 
			if(checkManager.isSelected()) {
				int result = Mgdao.mlogin(ID, PW);
				if(result == 1) {
					new MR();
					
				}else if(result==0) {
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-1) {
					JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-2) {
					JOptionPane.showMessageDialog(this, "데이터베이스 오류가 발생했습니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				int result = Mbdao.ulogin(ID, PW);
				if(result == 1) {
					new MainFrame();
				}else if(result==0) {
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-1) {
					JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-2) {
					JOptionPane.showMessageDialog(this, "데이터베이스 오류가 발생했습니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
				

		}

	}
}

public class MyBookingLoginFrame {
	public static void main(String[] args) {
		
		new logFrame();
	}
}
