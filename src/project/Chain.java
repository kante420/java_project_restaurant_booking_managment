package project;

public class Chain {
    private Restaurant[] restaurants;

    public Chain(){
        restaurants = new Restaurant[5];
        for (int i = 0; i < 5; i++) {
            restaurants[i] = new Restaurant(i+1, 5+(int)(Math.random()*4));
        }
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public Table findRestaurant(int restaurant_identifier, String clientName, int diners){
        int index = restaurant_identifier - 1;
        for (int i = 0; i < restaurants.length; i++) {
            Table table = restaurants[(index+1)% restaurants.length].getReservation(clientName, diners);
            if(table != null){
                return table;
            }
        }
        return null;
    }


}
