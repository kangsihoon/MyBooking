package MyBookingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class test1 extends JFrame {
    Container container = getContentPane();
    List<String> dataList = new ArrayList<>();
    JList<String> list = new JList<>();
    JButton addButton = new JButton("추가");
    JButton removeButton = new JButton("삭제");

    public test1() {
        setSize(500, 400);
        setTitle("Swing14");
        setLocationRelativeTo(null);

        init();
        start();

        setVisible(true);
    }

    private void init() {
        container.setLayout(new BorderLayout());

        // JList를 JScrollPane 안에 넣어서 화면 가로 크기를 차지하게 함
        JScrollPane scrollPane = new JScrollPane(list);
        container.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        container.add(buttonPanel, BorderLayout.SOUTH); // 추가와 삭제 버튼을 SOUTH에 배치
    }

    private void start() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 추가 버튼 이벤트 처리
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 임의의 데이터 추가
                dataList.add("New Data " + (dataList.size() + 1));

                // JList 업데이트
                updateJList();
            }
        });

        // 삭제 버튼 이벤트 처리
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 항목 삭제
                int[] selectedIndices = list.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    dataList.remove(selectedIndices[i]);
                }

                // JList 업데이트
                updateJList();
            }
        });
    }

    private void updateJList() {
        // ArrayList를 배열로 변환하여 JList 업데이트
        list.setListData(dataList.toArray(new String[0]));
    }

    public static void main(String[] args) {
        new test1();
    }
}
