package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphic_interface {
    private JPanel mainPanel;
    private JComboBox selectRestaurant;
    private JTextField numberDinners;
    private JButton checkButton;
    private JTextArea tableSuggested;
    private JTextField clientName;
    private JButton bookButton;
    private JButton searchAlternativeButton;
    private JTextArea table1Table2TextArea1;
    private JTextArea tableBooked;
    private JLabel name;
    private JLabel stablishment;
    private JLabel number;
    private JLabel suggested;
    private JLabel no_options;
    private JLabel tables;


    public graphic_interface() {

        tableBooked.setVisible(false); //The booked message is hidden
        no_options.setVisible(true); //The "No Options Available" message is hidden

        bookButton.addActionListener(new ActionListener() { //If we book a table (= button is pressed)
            @Override
            public void actionPerformed(ActionEvent e) {
                tableBooked.setVisible(true); //The booked message is shown when you click the book button
                selectRestaurant.setSelectedIndex(-1); //Select restaurant is reset
                numberDinners.setText(""); //Number of dinners is reset
                clientName.setText(""); //Client Name is reset
                tableSuggested.setText(""); //Table Suggested is reset
            }
        });

        numberDinners.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int number = Integer.parseInt(numberDinners.getText());
                    if (number > 6) {
                        int table1 = 1; //This is just an example that will be modified when we have the final program
                        int table2 = table1 + 1;
                        tableSuggested.setText("Table " + table1 + " - " + table2);
                    }
                    else{
                        tableSuggested.setText("Table 1"); //This is just an example that will be modified when we have the final program
                    }
                }
                catch(NumberFormatException ex){
                    tableSuggested.setText("Enter a valid number of dinners, please.");
                }
            }
        });



        searchAlternativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableSuggested.getText().trim().isEmpty()){
                    no_options.setVisible(true);
                }
            }
        });

        if(tableSuggested.getText().trim().isEmpty()){ //If there isn´t any table available
            searchAlternativeButton.setVisible(false);  //Disable the search alternative button
        }

        if(table1Table2TextArea1.getText().trim().isEmpty()){ //If the JTextArea where the tables are shown is empty (there are no available tables)
            bookButton.setVisible(false);   //Disable the Book Button
        }


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("graphic_interface");
        frame.setContentPane(new graphic_interface().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
