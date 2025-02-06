import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //to do: add file with data of restaurants with name, location, and meals that include name, ingredients, calories, and price
        ArrayList<Restaurant> allRestaurants= new ArrayList<>();

        //to do: add exceptions

        System.out.println("Welcome to the Meal Suggestions App!");
        System.out.println("Please enter some information so we can find you a meal today.");
        System.out.println("What city would you like to eat in? (N/A if it does not matter)");
        String userLocation = sc.nextLine();
        System.out.println("What restaurant you would like to eat at? (N/A if it does not matter)");
        String userRestaurant = sc.nextLine();
        System.out.println("What meal you would like to eat? (N/A if it does not matter)");
        String userMeal = sc.nextLine();
        System.out.println("What ingredients don't you want in your meal? (Separate ingredients with a comma)(N/A if it does not matter)");
        String userIngredients = sc.nextLine();
        System.out.println("What is the maximum amount of calories you would like your meal to have? (-1 if it does not matter)");
        int userCalories = sc.nextInt();
        System.out.println("What is the maximum price you would like your meal to be? (-1 if it does not matter)");
        double userPrice = sc.nextInt();


        if (!userLocation.equalsIgnoreCase("N/A")){
            for (int i = 0; i < allRestaurants.size(); i++){
                if(!allRestaurants.get(i).restaurantMatchLocation(userLocation)){
                    allRestaurants.remove(i);
                }
            }
        }

        if (!userRestaurant.equalsIgnoreCase("N/A")){
            for (int i = 0; i < allRestaurants.size(); i++){
                if(!allRestaurants.get(i).restaurantMatchName(userRestaurant)){
                    allRestaurants.remove(i);
                }
            }
        }

        //to do: add if statements to filter out the remaining conditions entered by user
        //to do: for price and calories use array to give number ranking of how good a match it is
    }
}