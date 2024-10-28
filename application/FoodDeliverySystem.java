package com.tns.fooddeliverysystem.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.OrderService;
import com.tns.fooddeliverysystem.entities.Restaurant;
import com.tns.fooddeliverysystem.services.CustomerService;
import com.tns.fooddeliverysystem.services.DeliveryPersonService;
import com.tns.fooddeliverysystem.services.FoodService;
import com.tns.fooddeliverysystem.services.RestaurantService;

public class FoodDeliverySystem {
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static Map<Integer, Order> orders = new HashMap<>();
    public static Map<Integer, Customer> customers = new HashMap<>();
    public static Map<Integer, DeliveryPerson> deliveryPersons = new HashMap<>();
    public static int orderCounter = 1;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Sample data for demonstration
            Restaurant restaurant1 = new Restaurant(1, "Pizza Place");
            restaurant1.addFoodItem(new FoodItem(1, "Margherita Pizza", 8.99));
            restaurant1.addFoodItem(new FoodItem(2, "Pepperoni Pizza", 9.99));
            restaurants.add(restaurant1);

            Restaurant restaurant2 = new Restaurant(2, "Sushi Spot");
            restaurant2.addFoodItem(new FoodItem(3, "California Roll", 5.99));
            restaurant2.addFoodItem(new FoodItem(4, "Spicy Tuna Roll", 7.99));
            restaurants.add(restaurant2);

            while (true) {
                System.out.println("\n-------------------------------------");
                System.out.println("1. Admin Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    System.out.println("-------------------------------------");
                    switch (choice) {
                        case 1:
                            adminMenu();
                            break;
                        case 2:
                            customerMenu();
                            break;
                        case 3:
                            System.out.println("Exiting the application.");
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Scanner closed. Application exited.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n-------------------------------------");
            System.out.println("Admin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                System.out.println("-------------------------------------");
                switch (choice) {
                    case 1:
                        RestaurantService.addRestaurant();
                        break;
                    case 2:
                        FoodService.addFoodItemToRestaurant();
                        break;
                    case 3:
                        FoodService.removeFoodItemFromRestaurant();
                        break;
                    case 4:
                        FoodService.viewRestaurantsAndMenus();
                        break;
                    case 5:
                        OrderService.viewOrders();
                        break;
                    case 6:
                        DeliveryPersonService.addDeliveryPerson();
                        break;
                    case 7:
                        OrderService.assignDeliveryPersonToOrder();
                        break;
                    case 8:
                        System.out.println("Exiting Admin Module");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred in Admin Menu: " + e.getMessage());
            }
        }
    }

    private static void customerMenu() {
        while (true) {
        	System.out.println("\n-------------------------------------");
            System.out.println("Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                System.out.println("-------------------------------------");
                switch (choice) {
                    case 1:
                        CustomerService.addCustomer();
                        break;
                    case 2:
                        FoodService.viewFoodItems();
                        break;
                    case 3:
                        CustomerService.addFoodToCart();
                        break;
                    case 4:
                        CustomerService.viewCart();
                        break;
                    case 5:
                        OrderService.placeOrder();
                        break;
                    case 6:
                        OrderService.viewOrders();
                        break;
                    case 7:
                        System.out.println("Exiting Customer Module");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred in Customer Menu: " + e.getMessage());
            }
        }
    }
}
