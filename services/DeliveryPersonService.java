package com.tns.fooddeliverysystem.services;
import java.util.Scanner;

import com.tns.fooddeliverysystem.application.FoodDeliverySystem;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;

public class DeliveryPersonService {
    private static Scanner scanner = FoodDeliverySystem.scanner;

    public static void addDeliveryPerson() {
        System.out.print("Enter Delivery Person ID: ");
        int deliveryPersonId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Delivery Person Name: ");
        String name = scanner.nextLine(); 
        System.out.print("Enter Contact No.: ");
        long contactNo = scanner.nextLong();
        DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryPersonId, name, contactNo);
        FoodDeliverySystem.deliveryPersons.put(deliveryPersonId, deliveryPerson);
        System.out.println("Delivery person added successfully!");
    }
}
