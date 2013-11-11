/**
 * 
 */
package vn.hust.smie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author Quan T. Nguyen <br>
 *         Hanoi University of Science and Technology
 */
public class Tester {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
	// Create user object
	User user = new User();
	user.setName("Tester");
	user.setSex(User.SEX_FEMALE);
	user.setYearOfBirth(1991);
	user.setHeight(1.65);
	user.setWeight(60);
	user.setActivity(User.ACTIVITY_NORMAL);

	// Create ingredient collection from data
	IngredientCollection ic = Parser.parseIngredient(new FileInputStream(new File("res/data/ingredient.csv")));
	
	// Create dish collection from data
	DishCollection dc = Parser.parseDish(ic, new FileInputStream(new File("res/data/dish.csv")));
	
	// Open rule file
	InputStream inStream = null;
	try {
	    inStream = new FileInputStream(new File("res/rule/smartmeal.xml"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	// Setup engine
	Smie smie = new Smie(dc, ic);
	smie.setupSession(inStream);
	
	// Add input here
	smie.inputUser(user);
	// Process user information
	smie.executeRules();
	
	// Setup a meal
	smie.setupMeal(Meal.TYPE_LUNCH); // TODO Example
	smie.executeRules();
	smie.printWorkingMemory();
	
	// Get result
	Meal meal = smie.getMeal();
	
	// Finish session
	smie.finishSession();
	
	// Print result
	System.out.println("Result meal:");
	ArrayList<Dish> menu = meal.getMenu();
	for (Dish d : menu) {
	    System.out.println(d);
	}
	System.out.println("Shorted E P L G: " + meal.getShortedEnergy() + " "
		+ meal.getShortedPro() + " " + meal.getShortedLip() + " " + meal.getShortedGlu());
    }

}
