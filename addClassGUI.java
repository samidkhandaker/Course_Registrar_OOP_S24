package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addClassGUI extends JFrame{
	private JTextField nameField, symbolField, timeField;
    private JComboBox<String> locationComboBox;
    private JSpinner creditsSpinner;
    private ArrayList<String> prerequisitesname=new ArrayList<String>();
    private ArrayList<Courses> prerequisites=new ArrayList<Courses>();
    public Courses newcourse;

    public addClassGUI( ArrayList<Courses> courses) {
        setTitle("Add Class");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(95, 40, 40, 16);
        JLabel symbolLabel = new JLabel("Symbol:");
        symbolLabel.setBounds(86, 78, 50, 16);
        JLabel creditsLabel = new JLabel("Credits:");
        creditsLabel.setBounds(86, 116, 49, 16);
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(77, 149, 58, 16);
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(100, 188, 35, 16);
        JLabel prerequisitesLabel = new JLabel("Prerequisites:");
        prerequisitesLabel.setBounds(50, 228, 85, 16);

        nameField = new JTextField(15);
        nameField.setBounds(158, 35, 190, 26);
        symbolField = new JTextField(15);
        symbolField.setBounds(158, 73, 190, 26);
        creditsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
        creditsSpinner.setBounds(158, 111, 37, 26);
        String[] locations = {"Bobst", "Silver","Cantor","Paulson"};
        locationComboBox = new JComboBox<>(locations);
        locationComboBox.setBounds(157, 145, 105, 27);
        timeField = new JTextField(15);
        timeField.setBounds(158, 183, 190, 26);

        JButton addPrerequisiteButton = new JButton("Add Prerequisite");
        addPrerequisiteButton.setBounds(157, 223, 147, 29);
        addPrerequisiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prerequisite = JOptionPane.showInputDialog(null, "Enter Prerequisite Class:");
                if (prerequisite != null && !prerequisite.isEmpty()) {
                	prerequisitesname.add(prerequisite);
                }
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(214, 276, 85, 29);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String symbol = symbolField.getText();
                int credits = (int) creditsSpinner.getValue();
                String location = (String) locationComboBox.getSelectedItem();
                String time = timeField.getText();
                if(!prerequisitesname.isEmpty()){
                for(String coursename: prerequisitesname) {
                	for(Courses precourse: courses) {
                		if(precourse.getName().equals(coursename)) {
                			prerequisites.add(precourse);
                		}
                	}
                }
            }
                newcourse=new Courses(name, symbol, credits, location, time, prerequisites);
               dispose();
               
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 276, 86, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        panel.setLayout(null);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(symbolLabel);
        panel.add(symbolField);
        panel.add(creditsLabel);
        panel.add(creditsSpinner);
        panel.add(locationLabel);
        panel.add(locationComboBox);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(prerequisitesLabel);
        panel.add(addPrerequisiteButton);
        panel.add(cancelButton); 
        panel.add(saveButton);

        getContentPane().add(panel);
        setVisible(true);
    }

}
