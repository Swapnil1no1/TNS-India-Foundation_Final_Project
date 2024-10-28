package com.tns.fooddeliverysystem.services;
import java.util.Scanner;

import com.tns.fooddeliverysystem.application.FoodDeliverySystem;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class FoodService {
    public static void addFoodItemToRestaurant() {
    	Scanner scanner = FoodDeliverySystem.scanner;
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = FoodDeliverySystem.scanner.nextInt();
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        int foodItemId = FoodDeliverySystem.scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Food Item Name: ");
        String foodItemName = FoodDeliverySystem.scanner.nextLine(); 
        System.out.print("Enter Food Item Price: ");
        double foodItemPrice = FoodDeliverySystem.scanner.nextDouble();
        restaurant.addFoodItem(new FoodItem(foodItemId, foodItemName, foodItemPrice));
        System.out.println("Food item added successfully!");
    }

    public static void removeFoodItemFromRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = FoodDeliverySystem.scanner.nextInt();
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID to remove: ");
        int foodItemId = FoodDeliverySystem.scanner.nextInt();
        restaurant.removeFoodItem(foodItemId);
        System.out.println("Food item removed successfully!");
    }

    public static void viewRestaurantsAndMenus() {
        System.out.println("Restaurants and Menus:");
        for (Restaurant restaurant : FoodDeliverySystem.restaurants) {
            System.out.println(restaurant + "\n");
        }
    }

    public static void viewFoodItems() {
        System.out.println("Available Food Items:");
        for (Restaurant restaurant : FoodDeliverySystem.restaurants) {
            restaurant.getMenu().forEach(System.out::println);
        }
    }

    public static Restaurant findRestaurantById(int id) {
        return FoodDeliverySystem.restaurants.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }
}
