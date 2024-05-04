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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        JLabel symbolLabel = new JLabel("Symbol:");
        JLabel creditsLabel = new JLabel("Credits:");
        JLabel locationLabel = new JLabel("Location:");
        JLabel timeLabel = new JLabel("Time:");
        JLabel prerequisitesLabel = new JLabel("Prerequisites:");

        nameField = new JTextField(15);
        symbolField = new JTextField(15);
        creditsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
        String[] locations = {"Bobst", "Silver","Cantor","Paulson"};
        locationComboBox = new JComboBox<>(locations);
        timeField = new JTextField(15);

        JButton addPrerequisiteButton = new JButton("Add Prerequisite");
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
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

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

        add(panel);
        setVisible(true);
    }

}
