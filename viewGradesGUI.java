package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class viewGradesGUI extends JFrame {
    private ArrayList<StudentCourse> courseList;
    private JTextArea textArea;

    public viewGradesGUI(Student student) {

    	 setTitle("View Grades");
         setSize(300, 300);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        textArea.setText(student.getTranscript());
        JScrollPane scrollPane = new JScrollPane(textArea);
        String gpa=String.format("%.4f", student.getGPA());
        JLabel gpaLabel = new JLabel("Final GPA: " +gpa );
        JButton cancelButton = new JButton("Back");

        panel.add(scrollPane);
        panel.add(gpaLabel);
        panel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}
