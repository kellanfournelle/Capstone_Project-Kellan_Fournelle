import java.util.ArrayList;

public class Restaurant {

    String name;
    String location;
    ArrayList<Meal> meals;

    //constructor
    public Restaurant (String name, String location, ArrayList<Meal> meals){
        this.name = name;
        this.location = location;
        this.meals = meals;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public ArrayList<Meal> getMeals(){
        return meals;
    }

    public void printRestaurant(){
        System.out.println(name + " - " + location);
        for (int i = 0; i < meals.size(); i++){
            meals.get(i).printMeal();
        }
    }

    public boolean restaurantMatchName(String userName){
        return name.equalsIgnoreCase(userName);
    }

    public boolean restaurantMatchLocation(String userLocation){
        return location.equalsIgnoreCase(userLocation);
    }

}
