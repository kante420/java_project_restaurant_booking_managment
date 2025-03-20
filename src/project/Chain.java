package project;

public class Chain extends Restaurant {
    private String chainName;
    private int numberOfRestaurants;
    private Restaurant[] restaurants;

    //Contructor
    public Chain(String chainName, int numberOfRestaurants) {
        this.chainName = chainName;
        this.numberOfRestaurants = numberOfRestaurants;
        //Initialization of the Restaurant Array
        restaurants = new Restaurant[numberOfRestaurants];
        for(int i=0; i < numberOfRestaurants;i++){
            restaurants[i] = new Restaurant();
        }
    }

    //Add Restaurant
    public boolean addRestaurant(Restaurant restaurant){
        for(int i = 0; i < numberOfRestaurants; i++){
            if(restaurants[i].getName() == null){
                restaurants[i].setName(restaurant.getName());
                return true;
            }
        }
        return false;
    }

    //Get Restaurant
    public Restaurant getRestaurant(String name){
        for(int i = 0; i < numberOfRestaurants; i++){
            if(restaurants[i].getName().equals(name)){
                return restaurants[i];
            }
        }
        return null;
    }

    //Get Restaurant Position
    private int getRestaurantPosition(String name){
        for(int i = 0; i < numberOfRestaurants; i++){
            if(restaurants[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    //Reserve Restaurant
    public boolean removeRestaurant(int numberOfPeople, String restaurantName, String reservationName){
        Restaurant restaurant = getRestaurant(restaurantName);

        if (restaurant == null){
            return false;
        }
        else{

            return restaurant.reserveTables(numberOfPeople, reservationName);
        }

    }


    //Search Restaurant
    public Restaurant searchRestaurant(int numberOfPeople, String restaurantName){
        Restaurant restaurant = getRestaurant(restaurantName);

        if (restaurant == null){
            return null;
        }
        else{
            int position = getRestaurantPosition(restaurantName);

            for(int i = position; i < numberOfRestaurants; i++){
                if(restaurants[i].hasAvailableTables(numberOfPeople)){
                    return restaurants[i];
                }
            }

            return null;
        }
    }
}
