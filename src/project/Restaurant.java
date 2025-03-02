package project;

public class Restaurant {
    private int identifier;
    private Table[] tables;
    private int extra_tables;

    //Constructor that receives the ID of the restaurant and the capacity
    public Restaurant(int identifier, int capacity){
        this.identifier = identifier;
        this.tables = new Table[capacity];
        for(int i = 0; i < capacity; i++){
            tables[i] = new Table(i+1);
        }
    }

    //Getters
    public int getIdentifier(){
        return identifier;
    }
    public Table[] getTables(){
        return tables;
    }
    public int getExtraTables(){
        return extra_tables;
    }

    //Setters
    public void setExtraTables(int extraTables){
        this.extra_tables = extraTables;
    }

    //Method that searched in tables[] the first available table and when one is found, it gets reserved
    public Table getReservation(String client_name, int people){
        for(Table table : tables){
            if(table.isAvailable()){
                table.setData(client_name, people);
                return table;
            }
        }
        if(extra_tables > 0){
            Table new_Table = new Table(tables.length + 1);
            new_Table.setData(client_name, people);
            extra_tables--;
            return new_Table;
        }
        return null; //In case there isn´t any available table
    }
}
