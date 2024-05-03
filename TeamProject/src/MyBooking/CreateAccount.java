package MyBooking;

//회원가입 화면 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;

class CA extends JFrame implements ActionListener {
	MyBookingImpl mpip = new MyBookingImpl();
	
	Container container = getContentPane();
	JPanel[] big_pns = new JPanel[6]; // 큰 패널(전체 구조)

	JPanel ac_btn_pns = new JPanel();
	JPanel tit_pns = new JPanel();
	JPanel[] sml_pns = new JPanel[7]; // 작은 패널(패널 당 구조)

	JLabel tit_lbs = new JLabel("회원가입");
	JLabel under_lbs = new JLabel("_____________________________________");

	JLabel[] lbs = new JLabel[7];
	String[] lbs_strs = { "아이디", "비밀번호", "비밀번호 확인", "이름", "생년월일", "전화번호", "이메일" };

	// 이름, 아이디, 생년월일, 전화번호, 이메일
	JTextField[] tfs = new JTextField[5];
	JPasswordField[] pfs = new JPasswordField[2];

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

			sml_pns[i] = new JPanel();
			sml_pns[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 0)); // FlowLayout을 이용하여 가로로 배치
			big_pns[4].add(sml_pns[i]);
		}
		
		// 텍스트 필드 선언
		for (int i = 0; i < tfs.length; i++) {
			tfs[i] = new JTextField(15); 
		}
		
		// 패스워드 필드 선언
		for (int i = 0; i < pfs.length; i++) {
			pfs[i] = new JPasswordField(15);
		}
		// 아이디
		sml_pns[0].add(lbs[0]);
		sml_pns[0].add(tfs[0]);
		// 비밀번호
		sml_pns[1].add(lbs[1]);
		sml_pns[1].add(pfs[0]);
		// 비번확인
		sml_pns[2].add(lbs[2]);
		sml_pns[2].add(pfs[1]);
		// 이름
		sml_pns[3].add(lbs[3]);
		sml_pns[3].add(tfs[1]);
		// 생년월일
		sml_pns[4].add(lbs[4]);
		sml_pns[4].add(tfs[2]);
		// 전화번호
		sml_pns[5].add(lbs[5]);
		sml_pns[5].add(tfs[3]);
		// 이메일
		sml_pns[6].add(lbs[6]);
		sml_pns[6].add(tfs[4]);

		for (int i = 0; i < sml_pns.length; i++) {
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

		// TextField DocumentListener 구현(실시간 업데이트)
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

		// PasswordField DocumentListener 구현(실시간 업데이트)
		for (int i = 0; i < pfs.length; i++) {
			pfs[i].getDocument().addDocumentListener(new DocumentListener() {
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
		// 가입 버튼 이벤트 처리
		if(e.getSource() == btns[2]) {	
			
			String tfsId = tfs[0].getText();		// textfield 아이디	
			char[] tfsPw = pfs[0].getPassword();	// textfield 비번
			String strPw = new String(tfsPw);
			char[] tfsPwR = pfs[1].getPassword();	// textfield 비번확인(데이터 insert 필요없음)
			String strPwR = new String(tfsPwR);
			String tfsName = tfs[1].getText();		// textfield 이름
			String tfsBirth = tfs[2].getText();		// textfield 생년월일
			String tfsTell = tfs[3].getText();		// textfield 전화번호
			String tfsMail = tfs[4].getText();		// textfield 이메일
			
			
			// 공백 검사(공백 시 오류 창)
			// 아이디
			if(tfsId.equals("")) {
				JOptionPane.showMessageDialog(this, "ID 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 비번
			if(strPw.equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 비번 확인
			if(!strPwR.equals(strPw) || strPwR.equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호 재입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 이름
			if(tfsName.equals("")) {
				JOptionPane.showMessageDialog(this, "이름 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 생년월일
			if(tfsBirth.equals("")) {
				JOptionPane.showMessageDialog(this, "생년월일 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 전번
			if(tfsTell.equals("")) {
				JOptionPane.showMessageDialog(this, "전화번호 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			// 이메일 
			if(tfsMail.equals("")) {
				JOptionPane.showMessageDialog(this, "이메일 입력", "경고", JOptionPane.CANCEL_OPTION);
				return; 	// 해당 if문 탈출 후 처음부터 
			}
			
			// DB에 입력값을 저장 
			DBConnectDTO dto = new DBConnectDTO();
			dto.setUserId(tfsId);
			dto.setUserPw(strPw);
			dto.setUserName(tfsName);
			dto.setUserBirth(tfsBirth);
			dto.setUserTell(tfsTell);
			dto.setUserMail(tfsMail);
			mpip.CreateAccount(dto);	// 회원가입 insert 기능
			
			if(mpip.CreateAccount(dto) > 0) JOptionPane.showMessageDialog(this, "저장성공", "저장", JOptionPane.INFORMATION_MESSAGE);	
			else JOptionPane.showMessageDialog(this, "저장실패", "저장", JOptionPane.CANCEL_OPTION);
			
			
 		}
	}

	// 아이콘 업데이트 메서드
	private void updateIcon() {
		ImageIcon newIcon;

		// 조건을 하나 하나씩 부여시켜야 함
		String tfId = tfs[0].getText(); // 아이디 입력값
		String tfPw = new String(pfs[0].getPassword()); // 비밀번호 입력값
		String tfPwR = new String(pfs[1].getPassword()); // 비밀번호 확인입력값
		String tfName = tfs[1].getText(); // 이름 입력값
		String tfBir = tfs[2].getText(); // 생년월일 입력값
		String tfPhone = tfs[3].getText(); // 전화번호 입력값
		String tfMail = tfs[4].getText(); // 이메일 입력값

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

public class CreateAccount {
	public static void main(String[] args) {
		new CA();
	}
}
