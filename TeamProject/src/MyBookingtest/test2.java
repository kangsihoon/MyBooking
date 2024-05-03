package MyBookingtest;

//회원가입 화면 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;

class CA extends JFrame implements ActionListener {
	Container container = getContentPane();
	JPanel[] big_pns = new JPanel[6]; // 큰 패널(전체 구조)

	JPanel ac_btn_pns = new JPanel();
	JPanel tit_pns = new JPanel();
	JPanel[] sml_pns = new JPanel[7]; // 작은 패널(패널 당 구조)

	JLabel tit_lbs = new JLabel("회원가입");
	JLabel under_lbs = new JLabel("_____________________________________");

	JLabel[] lbs = new JLabel[7];
	String[] lbs_strs = { "이름", "아이디", "비밀번호", "비밀번호 확인", "생년월일", "전화번호", "이메일" };

	JTextField[] tfs = new JTextField[7];
	// 이름, 아이디, 비밀번호, 비밀번호 확인, 생년월일, 전화번호, 이메일

	JButton[] btns = new JButton[3];
	String[] btns_strs = { "로그인", "아이디/비번 찾기", "가입하기" };

	ImageIcon icon = new ImageIcon("img/no.png"); // 기본은 x 조건 만족하면 o로 변경(ActionListener 에
	Image image = icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	ImageIcon scaledIcon = new ImageIcon(image);

	// 글자 설정
	Font lbsfont = new Font(" ", Font.BOLD, 30); // lbsfont: 글자 굵음, 크기 30

	public CA() {
		setSize(400, 600);
		setLocation(300, 200);
		setTitle("회원가입");

		init();
		start();

		setResizable(false);
		setVisible(true);
	}

	private void init() {
		Font font = new Font("", Font.PLAIN, 10);
		container.setLayout(new BorderLayout());
		for (int i = 0; i < big_pns.length; i++) {
			big_pns[i] = new JPanel();
			big_pns[i].setBackground(Color.WHITE);
		}

		// 버튼 선언하기
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btns_strs[i]);
			btns[i].setBackground(Color.WHITE);
			btns[i].setFont(font);
		}

		// 샛업 패널(왼, 오른 띄우기 위한 작업)
		container.add("West", big_pns[0]);
		big_pns[0].setPreferredSize(new Dimension(20, 600));
		container.add("Center", big_pns[1]); // 사용한 메인 패널
		container.add("East", big_pns[2]);
		big_pns[2].setPreferredSize(new Dimension(20, 600));

		// 메인(중간) 패널 작업
		big_pns[1].setLayout(new BorderLayout());

		big_pns[1].add("North", big_pns[3]);
		big_pns[1].add("Center", big_pns[4]);
		big_pns[1].add("South", big_pns[5]);

		// 위 패널
		big_pns[3].setLayout(new FlowLayout(FlowLayout.CENTER));

		// 중간 패널
		big_pns[4].setLayout(new BoxLayout(big_pns[4], BoxLayout.Y_AXIS)); // 수직으로 컴포넌트를 배치하는 BoxLayout으로 변경

		// 타이틀 레이블(가입하기)
		big_pns[4].add(tit_pns); // 타이틀 패널 삽입
		tit_pns.setLayout(new FlowLayout(FlowLayout.CENTER));
		tit_pns.add(tit_lbs);
		tit_pns.add(under_lbs); // 가로 줄
		tit_lbs.setFont(lbsfont);

		// 레이블, 텍스트 필드 레이블(작은 패널)
		for (int i = 0; i < sml_pns.length; i++) {
			lbs[i] = new JLabel(lbs_strs[i]); // 레이블 선언
			tfs[i] = new JTextField(15); // 텍스트 필드 선언

			sml_pns[i] = new JPanel();
			sml_pns[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 0)); // FlowLayout을 이용하여 가로로 배치
			big_pns[4].add(sml_pns[i]);

			sml_pns[i].add(lbs[i]);
			sml_pns[i].add(tfs[i]);

			// 표시 추가(기본 x표시)
			JLabel iconLabel = new JLabel(scaledIcon);
			sml_pns[i].add(iconLabel);
		}

		big_pns[4].add(ac_btn_pns);
		ac_btn_pns.setLayout(new FlowLayout(FlowLayout.CENTER));
		ac_btn_pns.add(btns[2]); // 맨 아래 가입하기 버튼

		// 아래 패널
		big_pns[5].setLayout(new FlowLayout(FlowLayout.CENTER));
		big_pns[5].add(btns[0]);
		big_pns[5].add(btns[1]);

		// 텍스트 필드의 DocumentListener 구현(실시간 업데이트)
		for (int i = 0; i < tfs.length; i++) {
			tfs[i].getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					updateIcon();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					updateIcon();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					updateIcon();
				}
			});
		}

	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(this); // 버튼 이벤트 추가
		}
	}

	// 아이콘 설정 메소드
	private void setIcon(String imagePath, int panelIndex) {
		ImageIcon newIcon = new ImageIcon(imagePath);
		Image image = newIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		JLabel iconLabel = (JLabel) sml_pns[panelIndex].getComponent(2); // 2번째 컴포넌트는 아이콘 레이블
		iconLabel.setIcon(scaledIcon); // 이미지 아이콘 변경
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateIcon();
	}

	// 아이콘 업데이트 메서드
	private void updateIcon() {
		ImageIcon newIcon;

		// 조건을 하나 하나씩 부여시켜야 함
		String tfName = tfs[0].getText(); // 이름 입력값
		String tfId = tfs[1].getText(); // 아이디 입력값
		String tfPw = tfs[2].getText(); // 비밀번호 입력값
		String tfPwR = tfs[3].getText(); // 비밀번호 확인입력값
		String tfBir = tfs[4].getText(); // 생년월일 입력값
		String tfPhone = tfs[5].getText(); // 전화번호 입력값
		String tfMail = tfs[6].getText(); // 이메일 입력값

		// 이 for 전체를 수정해야 한다.

		// 이름 조건
		if (!tfName.equals("") && tfName.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 0);
		} else {
			setIcon("img/no.png", 0);
		}
		
		// 아이디 조건
		if (!tfId.equals("") && tfId.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 1);
		} else {
			setIcon("img/no.png", 1);
		}
		
		// 비밀번호 조건
		if (!tfPw.equals("") && tfPw.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 2);
		} else {
			setIcon("img/no.png", 2);
		}

		// 비밀번호 확인 조건
		if (!tfPwR.equals("") && tfPwR.equals(tfPw)) { // 공백이 아니면서 비밀번호가 같아야 함
			setIcon("img/yes.png", 3);
		} else {
			setIcon("img/no.png", 3);
		}
		
		// 생년월일 조건
		if (!tfBir.equals("") && tfBir.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 4);
		} else {
			setIcon("img/no.png", 4);
		}
		
		// 전화번호 조건
		if (!tfPhone.equals("") && tfPhone.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 5);
		} else {
			setIcon("img/no.png", 5);
		}
		
		// 이메일 조건
		if (!tfMail.equals("") && tfMail.length() >= 3) { // 공백이 아니면서 3글자 이상
			setIcon("img/yes.png", 6);
		} else {
			setIcon("img/no.png", 6);
		}
	}
}

public class test2 {
	public static void main(String[] args) {
		new CA();
	}
}
