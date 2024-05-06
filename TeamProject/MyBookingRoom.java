package MyBooking;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class SubFrame extends JFrame{
	Container container = getContentPane();
	
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelR11 = new JPanel();
	JPanel panelR12 = new JPanel();
	JPanel panelR13 = new JPanel();
	JPanel panelR14 = new JPanel();
	JPanel panelR15 = new JPanel();
	JPanel panelR21 = new JPanel();
	JPanel panelR22 = new JPanel();
	JPanel panelR23 = new JPanel();
	JPanel panelR24 = new JPanel();
	JPanel panelR25 = new JPanel();
	JPanel panelR31 = new JPanel();
	JPanel panelR32 = new JPanel();
	JPanel panelR33 = new JPanel();
	JPanel panelR34 = new JPanel();
	JPanel panelR35 = new JPanel();
	
	JLabel labelHImg = new JLabel(new ImageIcon("img/hotel LamadaTitle.jpg"));
	JLabel labelR1Img = new JLabel(new ImageIcon("img/hotelLamadaR1.png"));
	JLabel labelR2Img = new JLabel(new ImageIcon("img/hotelLamadaR1.png"));
	JLabel labelR3Img = new JLabel(new ImageIcon("img/hotelLamadaR1.png"));
	
	JLabel labelName = new JLabel("여수 라마다 프라자 호텔");
	JLabel labelAddress = new JLabel("전남 여수시 돌산읍 우두리 1048-4");
	JLabel labelPrice1 = new JLabel("190,000원");
	JLabel labelPrice2 = new JLabel("190,000원");
	JLabel labelPrice3 = new JLabel("190,000원");
	
	JButton buttonR1 = new JButton("예약하기");
	JButton buttonR2 = new JButton("예약하기");
	JButton buttonR3 = new JButton("예약하기");
	
	JTextArea textR1 = new JTextArea();
	JTextArea textR2 = new JTextArea();
	JTextArea textR3 = new JTextArea();
	
	
	
	SubFrame() {
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
		container.setBackground(Color.white);
		container.add("North",panelNorth);
		container.add("Center",panelCenter);
		
		panelNorth.setLayout(new BorderLayout());
		panelNorth.setBackground(null);
		panelNorth.add("North", labelName);
		panelNorth.add("Center", labelHImg);
		panelNorth.add("South", labelAddress);
		
		LineBorder lineBorder = new LineBorder(Color.black);
		EmptyBorder emptyBorder = new EmptyBorder(5,5,5,5);
		labelName.setBorder(new CompoundBorder(lineBorder, emptyBorder));
		labelName.setBackground(null);
		
		labelHImg.setPreferredSize(new Dimension(400,130));
		
		panelCenter.setLayout(new GridLayout(3,1));
		panelCenter.add(panelR11);
		panelCenter.add(panelR21);
		panelCenter.add(panelR31);
		
		//방1
		panelR11.setBorder(new LineBorder(Color.black));
		panelR11.setBackground(Color.white);
		panelR11.setLayout(new BorderLayout());
		panelR11.add("Center",panelR12);
		panelR11.add("South",panelR13);
		
		panelR12.setLayout(new BorderLayout());
		panelR12.add("West",labelR1Img);
		panelR12.add("Center",textR1);
		textR1.setText("슈페리어 더블 마운틴\n 기준2인 · 최대2인\n 입실 15:00\r\n"
				+ "퇴실 11:00");
		textR1.setEditable(false);
		
		panelR13.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR13.add(labelPrice1);
		panelR13.add(buttonR1);
		
		//방2
		panelR21.setBorder(new LineBorder(Color.black));
		panelR21.setBackground(Color.white);
		panelR21.setLayout(new BorderLayout());
		panelR21.add("Center",panelR22);
		panelR21.add("South",panelR23);
		
		panelR22.setLayout(new BorderLayout());
		panelR22.add("West",labelR2Img);
		panelR22.add("Center",textR2);
		textR2.setText("슈페리어 더블 마운틴\n 기준2인 · 최대2인\n 입실 15:00\r\n"
				+ "퇴실 11:00");
		textR2.setEditable(false);
		
		panelR23.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR23.add(labelPrice2);
		panelR23.add(buttonR2);
		
		
		//방3
		panelR31.setBorder(new LineBorder(Color.black));
		panelR31.setBackground(null);
		panelR31.setLayout(new BorderLayout());
		panelR31.add("Center",panelR32);
		panelR31.add("South",panelR33);
		
		panelR32.setLayout(new BorderLayout());
		panelR32.add("West",labelR3Img);
		panelR32.add("Center",textR3);
		textR3.setText("슈페리어 더블 마운틴\n 기준2인 · 최대2인\n 입실 15:00\r\n"
				+ "퇴실 11:00");
		textR3.setEditable(false);
		
		panelR33.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR31.setBackground(null);
		panelR33.add(labelPrice3);
		panelR33.add(buttonR3);
		
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}

public class MyBookingRoom {
	public static void main(String[] args) {
		new SubFrame();
	}

}
