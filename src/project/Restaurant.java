package project;

public class Restaurant extends Table{
    private final int additionalTables = 2;
    private int availableTables;
    private int currentTableIndex;
    private String name;
    private Table[] tables;
    private int totalTables;

    //Constructs a Restaurant object with a given name for it and a number of tables
    public Restaurant(String name, int totalTables){
        this.name = name;
        this.totalTables = totalTables + additionalTables;
        this.copy_totalTables = this.totalTables;
        //And creates a Table object for each table slot
    }

    private int copy_totalTables;

    //Inizialization of the Table Array
    tables = new Table[copy_totalTables];
    for(int i=0; i<copy_totalTables;i++){
        tables[i] = null;
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
    public String getName() {
        return name;
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

    //Method to reserve a table
    public boolean reserveTable(int numberOfPeople, String reservationName){
        int tables_needed = (numberOfPeople + 6 - 1) / 6; //Rounding up

        if(tables_needed <= availableTables){
            if(tables_needed <= 1){
                if(currentTableIndex == 6){
                    return false;
                }
                else{
                    for(int i=0; i<copy_totalTables; i++){
                        if(tables[i] == null){
                            tables[i].reserve(numberOfPeople, reservationName);
                            availableTables--;
                            currentTableIndex = i+1;
                            return true;
                            break;
                        }
                    }
                }

            }
            else{
                if(tables_needed > (totalTables-currentTableIndex)){
                    return false;
                }
                else{
                    int people_last_table = numberOfPeople - ((tables_needed - 1)*6);
                    int counter = 0;
                    for(int i=0; i<copy_totalTables; i++){
                        if(tables[i] == null){
                            if(counter < tables_needed){
                                if(counter == tables_needed-1){
                                    tables[i].reserve(numberOfPeople, reservationName);
                                    availableTables -= tables_needed;
                                    currentTableIndex = i+1;
                                    return true;
                                    break
                                }
                                tables[i] = 6;
                                counter++;

                            }
                        }
                    }
                }
            }

        }
        else{
            return false;
        }
    }

    //Get Name Method
    public String getName(){
        return name;
    }

    //Method to check is there are available tables
    public boolean hasAvailableTables(int numberOfPeople){
        int tables_needed = (numberOfPeople + 6 - 1) / 6; //Rounding up

        if(tables_needed <= availableTables){
            return true;
        }
        else{
            return false;
        }
    }

    //Available Tables Info Method
    public String availableTablesInfo (int numberOfPeople){
        int num_available_tables = copy_totalTables - (currentTableIndex + 1);
        int tables_needed = (numberOfPeople + 6 - 1) / 6; //Rounding up
        StringBuilder return_string = new StringBuilder();

        for(int i=currentTableIndex; i < copy_totalTables; i++){
            if (i == copy_totalTables - 1){
                return_string.append(" Table " + (i+1) + " Available")
            }
            return_string.append(" Table " + (i+1) + " Available / ")
        }

        return return_string;
    }


}
