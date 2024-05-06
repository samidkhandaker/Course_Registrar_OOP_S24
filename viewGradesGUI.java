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
		setSize(319, 311);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JTextArea textArea = new JTextArea(10, 20);
		textArea.setEditable(false);
		textArea.setText(student.getTranscript());
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(28, 23, 265, 175);
		String gpa = String.format("%.4f", student.getGPA());
		JLabel gpaLabel = new JLabel("Final GPA: " + gpa);
		gpaLabel.setBounds(103, 210, 111, 16);
		JButton cancelButton = new JButton("Back");
		cancelButton.setBounds(125, 238, 75, 29);
		panel.setLayout(null);

		panel.add(scrollPane);
		panel.add(gpaLabel);
		panel.add(cancelButton);

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		getContentPane().add(panel);
		setVisible(true);
	}
}
