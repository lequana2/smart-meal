/**
 * 
 */
package vn.hust.smie;

import java.util.ArrayList;


/**
 * @author Quan T. Nguyen <br>
 * Hanoi University of Science and Technology
 */
public class Dish {

    public static final int TYPE_GRAIN = 1;
    public static final int TYPE_VEGETABLE = 2;
    public static final int TYPE_PROTEIN = 3;
    public static final int TYPE_FRUIT = 4;
    public static final int TYPE_MIXED = 5;
    
    private int id;
    private String name;
    private int type;
    
    private int quantity;
    private String unit;
    
    private ArrayList<DishComponent> compList;
    
    /**
     * @param id
     * @param name
     * @param type
     * @param quantity
     * @param unit
     */
    public Dish(String id, String name, String type, String quantity, String unit) {
	this.id = Integer.parseInt(id);
	this.name = name;
	this.type = Integer.parseInt(type);
	this.quantity = Integer.parseInt(quantity);
	this.unit = unit;
	compList = new ArrayList<DishComponent>();
    }
    
    public void addComponent(DishComponent comp) {
	compList.add(comp);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @return the compList
     */
    public ArrayList<DishComponent> getCompList() {
        return compList;
    }
    
}