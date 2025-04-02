import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //add file with data of restaurants with name, location
        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("src/restaurants.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not open input file –ending program");
            System.exit(1);
        }

        ArrayList<Restaurant> allRestaurants= new ArrayList<>();

        Scanner fileReader = new Scanner(myFile);

        fileReader.nextLine();
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            String[] splitData = data.split(";");

            int countryCode = Integer.parseInt(splitData[1]);
            if (countryCode == 216){
                allRestaurants.add(new Restaurant(splitData[0], splitData[2]));
            }
        }


        System.out.println("Welcome to the Meal Suggestions App!");
        System.out.println();

        char choice = 'z';
        while (choice != 'c' && choice != 'C') {
            System.out.println("What would you like to do today...");
            System.out.println("a) Find a restaurant based on your preferences");
            System.out.println("b) Add a meal to a restaurant");
            System.out.println("c) Exit the program");
            choice = sc.next().charAt(0);

            System.out.println();

            sc.nextLine();
            if (choice == 'a' || choice == 'A') {

                ArrayList<Restaurant> prefered = new ArrayList<>();
                for (int i = 0; i < allRestaurants.size(); i++){
                    prefered.add(new Restaurant(allRestaurants.get(i)));
                }

                System.out.println("Please enter some information so we can find you a meal today.");
                System.out.println();

                System.out.println("What city would you like to eat in? (N/A if it does not matter)");
                String userLocation = sc.nextLine();

                //check location
                if (!userLocation.equalsIgnoreCase("N/A")){
                    for (int i = 0; i < prefered.size(); i++){
                        if(!prefered.get(i).restaurantMatchLocation(userLocation)){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("What restaurant you would like to eat at? (N/A if it does not matter)");
                String userRestaurant = sc.nextLine();

                //check restaurant name
                if (!userRestaurant.equalsIgnoreCase("N/A")){
                    for (int i = 0; i < prefered.size(); i++){
                        if(!prefered.get(i).restaurantMatchName(userRestaurant)){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("What meal you would like to eat? (N/A if it does not matter)");
                String userMeal = sc.nextLine();

                //check meal name
                if (!userMeal.equalsIgnoreCase("N/A")){
                    for (int i = 0; i < prefered.size(); i++){
                        boolean hasMeal = false;
                        for (int j = 0; j < prefered.get(i).meals.size(); j++){
                            if (prefered.get(i).meals.get(j).mealMatchName(userMeal)){
                                hasMeal = true;
                            }
                        }
                        if (!hasMeal){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("What ingredient don't you want in your meal? (N/A if it does not matter)");
                String userIngredient = sc.nextLine();

                //check ingredients
                if (!userIngredient.equalsIgnoreCase("N/A")){
                    for (int i = 0; i < prefered.size(); i++){
                        boolean hasIngredient = false;
                        for (int j = 0; j < prefered.get(i).meals.size(); j++){
                            if (prefered.get(i).meals.get(j).mealMatchIngredients(userIngredient)){
                                hasIngredient = true;
                            }
                        }
                        if (!hasIngredient){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("What is the maximum amount of calories you would like your meal to have? (-1 if it does not matter)");
                int userCalories = sc.nextInt();

                //check calories
                if (userCalories >= 0){
                    for (int i = 0; i < prefered.size(); i++){
                        boolean underCalories = false;
                        for (int j = 0; j < prefered.get(i).meals.size(); j++){
                            if (prefered.get(i).meals.get(j).mealMatchCalories(userCalories)){
                                underCalories = true;
                            }
                        }
                        if (!underCalories){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("What is the maximum price you would like your meal to be? (-1 if it does not matter)");
                double userPrice = sc.nextInt();

                //check price
                if (userPrice >= 0){
                    for (int i = 0; i < prefered.size(); i++){
                        boolean underPrice = false;
                        for (int j = 0; j < prefered.get(i).meals.size(); j++){
                            if (prefered.get(i).meals.get(j).mealMatchPrice(userPrice)){
                                underPrice = true;
                            }
                        }
                        if (!underPrice){
                            prefered.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println();

                System.out.println("Based on your preferences, here are some restaurants you would like:");
                printAll(prefered);
                System.out.println();

            }

            else if (choice == 'b' || choice == 'B'){
                int foundIndex = -1;
                while (foundIndex == -1){
                    System.out.println("What is the name of the restaurant you would like to add a meal to?");
                    String nameAddTo = sc.nextLine();
                    for (int i = 0; i < allRestaurants.size(); i++){
                        if (allRestaurants.get(i).restaurantMatchName(nameAddTo)){
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex == -1){
                        System.out.println("Restaurant not found. Try again.");

                    }
                }
                System.out.println("What is the name of this meal?");
                String mealName = sc.nextLine();

                System.out.println("How expensive is the meal? (in USD)");
                double mealPrice = sc.nextDouble();

                System.out.println("How many calories are in the meal?");
                int mealCalories = sc.nextInt();

                sc.nextLine();
                System.out.println("What ingredients are in the meal? (separate with a comma)");
                String ingredientsInput = sc.nextLine();
                String[] splitIngredients = ingredientsInput.split(",");
                ArrayList<String> mealIngredients = new ArrayList<>();
                for (int i = 0; i < splitIngredients.length; i++){
                        splitIngredients[i] = splitIngredients[i].trim();
                        mealIngredients.add(splitIngredients[i]);
                }

                allRestaurants.get(foundIndex).meals.add(new Meal(mealName, mealIngredients, mealCalories, mealPrice));

                System.out.println();
            }

            else if (choice == 'c'  || choice == 'C'){
                System.out.println("Exiting...");
            }

            else{
                System.out.println("Please enter a valid character.");
                System.out.println();
            }

        }


        //to do: for price and calories use array to give number ranking of how good a match it is
    }



    public static void printAll(ArrayList<Restaurant> restaurants){
        if (restaurants.size() > 0){
            for (int i = 0; i < restaurants.size(); i++){
                restaurants.get(i).printRestaurant();
            }
        }
        else{
            System.out.println("There are no restaurants that match your preferences.");
        }
    }
}