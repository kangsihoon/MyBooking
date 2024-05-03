package MyBookingtest;

import javax.swing.*;
import javax.swing.text.Utilities;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class text {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("Clickable TextArea Example");

        // JTextArea 생성
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // 편집 불가능하도록 설정

        // 문자열 목록
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        // StringBuilder를 사용하여 문자열을 하나의 문자열로 결합
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(item).append("\n");
        }

        // JTextArea에 문자열 설정
        textArea.setText(sb.toString());

        // JTextArea에 마우스 이벤트 추가
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextArea textArea = (JTextArea) e.getSource();
                int offset = textArea.viewToModel(e.getPoint());
                try {
                    int start = Utilities.getRowStart(textArea, offset);
                    int end = Utilities.getRowEnd(textArea, offset);
                    String selectedText = textArea.getText(start, end - start);
                    System.out.println("Clicked: " + selectedText.trim());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // JScrollPane을 사용하여 JTextArea를 스크롤 가능하게 함
        JScrollPane scrollPane = new JScrollPane(textArea);

        // JFrame에 JScrollPane 추가
        frame.add(scrollPane);

        // JFrame 설정
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
