package com.tns.fooddeliverysystem.services;
import java.util.Scanner;

import com.tns.fooddeliverysystem.application.FoodDeliverySystem;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class RestaurantService {
    private static Scanner scanner = FoodDeliverySystem.scanner;

    public static void addRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Restaurant Name: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = new Restaurant(restaurantId, restaurantName);
        FoodDeliverySystem.restaurants.add(restaurant);
        System.out.println("Restaurant added successfully!");
    }
}
