package com.tns.fooddeliverysystem.entities;
import com.tns.fooddeliverysystem.application.FoodDeliverySystem;

public class OrderService {
    public static void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int customerId = FoodDeliverySystem.scanner.nextInt();
        Customer customer = FoodDeliverySystem.customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        Order order = new Order(FoodDeliverySystem.orderCounter++, customer);
        customer.getCart().getItems().forEach(order::addItem);
        FoodDeliverySystem.orders.put(order.getOrderId(), order);
        System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
    }

    public static void viewOrders() {
        System.out.println("Orders:");
        for (Order order : FoodDeliverySystem.orders.values()) {
            System.out.println(order);
        }
    }

    public static void assignDeliveryPersonToOrder() {
        System.out.print("Enter Order ID: ");
        int orderId = FoodDeliverySystem.scanner.nextInt();
        Order order = FoodDeliverySystem.orders.get(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }
        System.out.print("Enter Delivery Person ID: ");
        int deliveryPersonId = FoodDeliverySystem.scanner.nextInt();
        DeliveryPerson deliveryPerson = FoodDeliverySystem.deliveryPersons.get(deliveryPersonId);
        if (deliveryPerson == null) {
            System.out.println("Delivery person not found!");
            return;
        }
        order.assignDeliveryPerson(deliveryPerson);
        System.out.println("Delivery person assigned to order successfully!");
    }
}
