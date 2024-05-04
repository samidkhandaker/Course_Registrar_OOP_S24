package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class dropClassGUI extends JFrame{
	public dropClassGUI(Student student) {
        setTitle("Delete Class");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel courseLabel = new JLabel("Choose a class to drop:");
        JComboBox<String> courseComboBox = new JComboBox<>();
        for (StudentCourse course : student.getCourses()) {
            courseComboBox.addItem(course.getName());
        }

        JLabel infoLabel = new JLabel();

        JButton deleteButton = new JButton("Delete Class");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClassName = (String) courseComboBox.getSelectedItem();
                student.removeCourse(selectedClassName);
                infoLabel.setText("Dropped class: " + selectedClassName);
            }
        });

        JButton goBackButton = new JButton("Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(courseLabel);
        panel.add(courseComboBox);
        panel.add(deleteButton);
        panel.add(goBackButton);
        panel.add(infoLabel);

        add(panel);
        setVisible(true);
    }
}
