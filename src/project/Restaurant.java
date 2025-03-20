package project;

public class Restaurant extends Table{
    private final int additionalTables = 2;
    private int availableTables;
    private int currentTableIndex = 0;
    private String name;
    private Table[] tables;
    private int totalTables;

    //Constructs a Restaurant object with a given name for it and a number of tables
    public Restaurant(String name, int totalTables){
        this.name = name;
        this.totalTables = totalTables + additionalTables;
        //Initialization of the Table Array
        tables = new Table[totalTables];
        for(int i=0; i< totalTables;i++){
            tables[i] = new Table();
        }
    }

    //Getters and Setters
    public int getAvailableTables() {
        return availableTables;
    }
    public void setAvailableTables(int availableTables) {
        this.availableTables = availableTables;
    }
    public int getCurrentTableIndex() {
        return currentTableIndex;
    }
    public void setCurrentTableIndex(int currentTableIndex) {
        this.currentTableIndex = currentTableIndex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Table[] getTables() {
        return tables;
    }
    public void setTables(Table[] tables) {
        this.tables = tables;
    }
    public int getTotalTables() {
        return totalTables;
    }
    public void setTotalTables(int totalTables) {
        this.totalTables = totalTables;
    }

    /*

    public boolean reserveTables(int numberOfPeople, String reservationName) {
        int tables_needed = (numberOfPeople + 6 - 1) / 6; //Rounding up

        if(numberOfPeople <= 1 || tables_needed > availableTables) {
            return false;
        }

        else if(currentTableIndex == 5 && tables_needed == 1) {
            return false;
        }

        else{
            if(tables_needed == 1){
                tables[currentTableIndex].reserve(numberOfPeople, reservationName);
                availableTables--;
                currentTableIndex++;
                return true;
            }
            else if(tables_needed >= 2){

            }
        }
    }

     */

    //Method to reserve a table
    public boolean reserveTables(int numberOfPeople, String reservationName) {
        int tables_needed = (int) Math.ceil((double) numberOfPeople /6); //Rounding up

        if (tables_needed <= availableTables) {
            if (tables_needed <= 1) {
                if (currentTableIndex == 6) {
                    return false;
                } else {
                    if (tables[currentTableIndex].getIsOccupied()) {
                        return false;
                    } else {
                        tables[currentTableIndex].reserve(numberOfPeople, reservationName);
                        availableTables--;
                        currentTableIndex++;
                        return true;
                    }
                }

            } else {
                if (tables_needed > (totalTables - currentTableIndex)) {
                    return false;
                } else {
                    int people_last_table = numberOfPeople - ((tables_needed - 1) * 6);
                    int counter = 0;
                    for (int i = 0; i < totalTables; i++) {
                        if (tables[i] == null) {
                            if (counter < tables_needed) {
                                if (counter == tables_needed - 1) {
                                    tables[i].reserve(people_last_table, reservationName);
                                    availableTables -= tables_needed;
                                    currentTableIndex = i + 1;
                                    return true;
                                }
                                tables[i].reserve(6, reservationName);
                                counter++;
                            }
                        }
                    }
                }
            }

        }

        return false;
    }

    //Get Name Method
    public String getName(){
        return name;
    }

    //Method to check is there are available tables
    public boolean hasAvailableTables(int numberOfPeople){
        int tables_needed = (int) Math.ceil((double) numberOfPeople /6); //Rounding up
        //Review for case just 1 table and there are only additional_tables
        return tables_needed <= availableTables;
    }

    //Available Tables Info Method
    public String availableTablesInfo (int numberOfPeople){
        int num_available_tables = totalTables - (currentTableIndex + 1);
        int tables_needed = (int) Math.ceil((double) numberOfPeople /6); //Rounding up
        StringBuilder return_string_available = new StringBuilder();

        if(tables_needed > num_available_tables){
            for(int i=currentTableIndex; i < totalTables; i++){
                if (i == totalTables - 1){
                    return_string_available.append(" Table ").append(i + 1).append(" Available");
                }
                return_string_available.append(" Table ").append(i + 1).append(" Available / ");
            }
            return return_string_available.toString();
        }

        return "There are no available tables for your reservation. Sorry!";
    }

    //To String Method
    public String toString(){
        StringBuilder return_string_restaurant = new StringBuilder();

        for(int i=0; i< totalTables; i++){
            if(i == totalTables - 1){
                if(tables[i].getIsOccupied()){
                    return_string_restaurant.append(" Table ").append(i + 1).append("\n Occupation: Occupied \n");
                    return_string_restaurant.append("Number of dinners: ").append(tables[i].getOccupiedSeats());
                    return_string_restaurant.append("\n Reservation Name: ").append(tables[i].getReservationName());
                    return return_string_restaurant.toString();
                }
                else{
                    return_string_restaurant.append(" Table ").append(i + 1).append("\n Occupation: Available");
                    return return_string_restaurant.toString();
                }
            }
            else{
                if(tables[i].getIsOccupied()){
                    return_string_restaurant.append(" Table ").append(i + 1).append("\n Occupation: Occupied \n");
                    return_string_restaurant.append("Number of dinners: ").append(tables[i].getOccupiedSeats());
                    return_string_restaurant.append("\n Reservation Name: ").append(tables[i].getReservationName());
                    return_string_restaurant.append("\n--------------------------------------\n");
                }
                else{
                    return_string_restaurant.append(" Table ").append(i + 1).append("\n Occupation: Available");
                    return_string_restaurant.append("\n--------------------------------------\n");
                }
            }
        }

        return "Error while obtaining the data";
    }

}
