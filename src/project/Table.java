package project;

public class Table {
    private final int identifier; //It´s a final because the identifier of a table is not going to change
    private String client_name;
    private int diners;


    /**
     *Constructor that initialized the ID of the table
     * @param identifier of the table
     */
    public Table(int identifier){
        this.identifier = identifier;
        this.client_name = null;
        this.diners = 0;
    }

    //Getters
    public int getIdentifier() {
        return identifier;
    }
    public String getClient_name() {
        return client_name;
    }
    public int getDiners() {
        return diners;
    }

    //Setters - In the case it´s needed, data could be modified
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
    public void setDiners(int diners) {
        if(diners >= 2){
            this.diners = diners;
        }
    }

    //Method to asign the table to someone
    public void setData(String client_name, int diners) {
        if(diners < 2){
            System.out.println("Invalid number of diners. Please, at least two.");
        }
        this.client_name = client_name;
        this.diners = diners;
    }

    //Method to know is the table is available
    public boolean isAvailable(){
        if(this.client_name == null){
            return true;
        }
        else{
            return false;
        }
    }
}
