import java.util.ArrayList;

public class Meal {

    String name;
    ArrayList<String> ingredients;
    int calories;
    double price;

    //constructor
    public Meal(String name, ArrayList<String> ingredients, int calories, double price){
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.price = price;
    }

    //copy constructor
    public Meal (Meal x){
        this.name = x.name;
        this.ingredients = x.ingredients;
        this.calories = x.calories;
        this.price = x.price;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public int getCalories(){
        return calories;
    }

    public double getPrice(){
        return price;
    }

    public void printMeal(){
        System.out.println("   - " + name);
        System.out.print("      - ");
        for (int i = 0; i < ingredients.size()-1; i++){
            System.out.print(ingredients.get(i) + ", ");
        }
        System.out.println(ingredients.getLast());
        System.out.println("      - " + calories + " calories");
        System.out.printf("      - $%.2f\n", price);
    }

    public boolean mealMatchName(String userName){
        return name.equalsIgnoreCase(userName);
    }

    public boolean mealMatchIngredients(String userIngredient){
        for (int i = 0; i < ingredients.size(); i++){
            if (ingredients.get(i).equalsIgnoreCase(userIngredient)){
                return true;
            }
        }
        return false;
    }

    public boolean mealMatchCalories(int userCalories){
        if (this.calories <= userCalories){
            return true;
        }
        return false;
    }

    public boolean mealMatchPrice(double userPrice){
        if (this.price <= userPrice){
            return true;
        }
        return false;
    }

}
