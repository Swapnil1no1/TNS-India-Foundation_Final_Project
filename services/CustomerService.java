package com.tns.fooddeliverysystem.services;
import java.util.Scanner;

import com.tns.fooddeliverysystem.application.FoodDeliverySystem;
import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class CustomerService {
    private static Scanner scanner = FoodDeliverySystem.scanner;

    public static void addCustomer() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Username: ");
        String username = scanner.nextLine(); 
        System.out.print("Enter Contact No.: ");
        long contactNo = scanner.nextLong();
        Customer customer = new Customer(userId, username, contactNo);
        FoodDeliverySystem.customers.put(userId, customer);
        System.out.println("Customer created successfully!");
    }

    public static void addFoodToCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = FoodDeliverySystem.customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        Restaurant restaurant = FoodService.findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        int foodItemId = scanner.nextInt();
        FoodItem foodItem = restaurant.getMenu().stream()
                .filter(item -> item.getId() == foodItemId)
                .findFirst()
                .orElse(null);
        if (foodItem == null) {
            System.out.println("Food item not found!");
            return;
        }
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food item added to cart!");
    }

    public static void viewCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = FoodDeliverySystem.customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.println("Cart details: ");
        customer.getCart().getItems().forEach((foodItem, quantity) ->
                System.out.println(foodItem.getName() + " x" + quantity));
        System.out.println("Total Cost: $" + customer.getCart().getTotalCost());
    }
}
