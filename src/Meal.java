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
        System.out.print("      - " + calories + " calories");
        System.out.print("      - $" + price);
    }

    public boolean mealMatchName(String userName){
        return name.equalsIgnoreCase(userName);
    }

}
