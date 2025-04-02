import java.util.ArrayList;

public class Restaurant {

    String name;
    String location;
    public ArrayList<Meal> meals;

    //constructor
    public Restaurant (String name, String location){
        this.name = name;
        this.location = location;
        this.meals = new ArrayList<>();
    }

    //copy constructor
    public Restaurant (Restaurant x){
        this.name = x.name;
        this.location = x.location;
        this.meals = new ArrayList<>();
        for (int i = 0; i < x.meals.size(); i++) {
            this.meals.add(new Meal(x.meals.get(i)));
        }
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
        System.out.println(name + " --- " + location);
        recursivePrintMeals(0);
    }

    public void recursivePrintMeals(int index){
        if (index >= meals.size()){
            return;
        }
        else{
            meals.get(index).printMeal();
            recursivePrintMeals(index + 1);
        }
    }

    public boolean restaurantMatchName(String userName){
        return name.equalsIgnoreCase(userName);
    }

    public boolean restaurantMatchLocation(String userLocation){
        return location.equalsIgnoreCase(userLocation);
    }
}
