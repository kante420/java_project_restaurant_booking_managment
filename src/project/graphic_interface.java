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
    private JTextArea table;
    private JTextArea tableBooked;
    private JLabel name;
    private JLabel stablishment;
    private JLabel number;
    private JLabel suggested;
    private JLabel no_options;
    private JLabel tables;
    private JScrollPane scrollPanel;

    public graphic_interface() {

        tableBooked.setVisible(false); //The booked message is hidden
        no_options.setVisible(true); //The "No Options Available" message is hidden

        //When we select a restaurant in the JComboBox, the tables in that restaurant are shown in the JTextArea (table) inside the JScrollPanel
        if(selectRestaurant.getSelectedIndex() == 0){
            table.setText("Table 1 - \n Table 2 - \n Table 3 - \n Table 4 - \n Table 5 - \n");
            scrollPanel.setMinimumSize(scrollPanel.getPreferredSize());
            table.setMinimumSize(scrollPanel.getPreferredSize());
        }
        else if(selectRestaurant.getSelectedIndex() == 1){
            table.setText("Table 1 - \n Table 2 - \n Table 3 - \n Table 4 - \n Table 5 - \n");
            scrollPanel.setMinimumSize(scrollPanel.getPreferredSize());
            table.setMinimumSize(scrollPanel.getPreferredSize());
        }
        else if(selectRestaurant.getSelectedIndex() == 2){
            table.setText("Table 1 - \n Table 2 - \n Table 3 - \n Table 4 - \n Table 5 - \n Table 6 - \n");
            scrollPanel.setMinimumSize(scrollPanel.getPreferredSize());
            table.setMinimumSize(scrollPanel.getPreferredSize());
        }
        else if(selectRestaurant.getSelectedIndex() == 3){
            table.setText("Table 1 - \n Table 2 - \n Table 3 - \n Table 4 - \n Table 5 - \n Table 6 - \n Table 7 - \n");
            scrollPanel.setMinimumSize(scrollPanel.getPreferredSize());
            table.setMinimumSize(scrollPanel.getPreferredSize());
        }
        else if(selectRestaurant.getSelectedIndex() == 4){
            table.setText("Table 1 - \n Table 2 - \n Table 3 - \n Table 4 - \n Table 5 - \n Table 6 - ");
            scrollPanel.setMinimumSize(scrollPanel.getPreferredSize());
            table.setMinimumSize(scrollPanel.getPreferredSize());
        }

        //If we book a table (= button is pressed)
        bookButton.addActionListener(new ActionListener() {
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

        //If there isn´t any table available
        if(tableSuggested.getText().trim().isEmpty()){
            searchAlternativeButton.setVisible(false);  //Disable the search alternative button
        }

        //If the JTextArea where the tables are shown is empty (there are no available tables)
        if(table.getText().trim().isEmpty()){
            bookButton.setVisible(false);   //Disable the Book Button
        }

        searchAlternativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int actual_position = selectRestaurant.getSelectedIndex(); //Store the actual position
                int total_positions = selectRestaurant.getItemCount(); //Store the amount of positions
                int result = (actual_position + 1) % total_positions;   //Calculate if we are in the last position or in one between [0, n-1]

                if(result == 0){ //If we are in a position between [0, n-1]
                    selectRestaurant.setSelectedIndex(actual_position + 1); //Go to the next position
                }
                else if(result == 1){ //If we are in position n (last position)
                    selectRestaurant.setSelectedIndex(0); //Go back to position 0
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("graphic_interface");
        frame.setContentPane(new graphic_interface().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); //We start it in the center, not relative to any margin
        frame.setVisible(true); //We pake the main panel visible
    }
}
