package main.java.np.com.prayashsapkota.functionality;

import main.java.np.com.prayashsapkota.restaurantsManagement.RestaurantManager;
import main.java.np.com.prayashsapkota.base.MenuItem;
import main.java.np.com.prayashsapkota.base.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiteMoreFoodDeliverySystem {
    private static final List<MenuItem> selectedItems = new ArrayList<>();
    private static final List<List<MenuItem>> allSelectedItems = new ArrayList<>();

    private static int userInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static void mainMenu(List<MenuItem> selectedItems) {
        System.out.println(" ");
        System.out.println("Welcome to Bite More");
        System.out.println(" ");
        System.out.println("1. Browse Restaurants");
        System.out.println("2. View Cart");
        System.out.println("3. Checkout");
        System.out.println("4. Exit");
        System.out.print("\nPlease choose a option : ");
        int choice = userInput();
        switch (choice) {
            case 1 -> browseRestaurants();
            case 2 -> viewCart(selectedItems);
            case 3 -> checkout(selectedItems);
            case 4 -> exit();
            default -> {
                System.out.println("Please enter a valid choice!!!!!");
                mainMenu(selectedItems);
            }
        }

    }

    private static void browseRestaurants() {
        RestaurantManager restaurantManager = new RestaurantManager();
        restaurantManager.initializeRestaurantsAndMenu();
        List<Restaurant> restaurantList = restaurantManager.getRestaurantsList();
        System.out.println("\nAvailable Restaurants");
        System.out.println(" ");
        for (int i = 0; i < restaurantList.size(); i++) {
            Restaurant restaurant = restaurantList.get(i);
            System.out.println((i + 1) + ". " + restaurant.getName());
        }
        System.out.print("\nPlease choose an option or Press 0 to go to main menu: ");
        int option = userInput();
        if (option > 0 && option <= restaurantList.size()) {
            Restaurant selectRestaurant = restaurantList.get(option - 1);
            displayMenu(selectRestaurant);
        } else if (option == 0) {
            List<MenuItem> selectedItems = new ArrayList<>();
            mainMenu(selectedItems);
        } else {
            System.out.println("Please choose a valid option");
            browseRestaurants();
        }
    }

    private static void displayMenu(Restaurant restaurant) {

        System.out.println("\nAvailable Menus");
        System.out.println(" ");
        List<MenuItem> menuList = restaurant.getMenu();
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getName() + " Rs." + menuList.get(i).getPrice());
        }


        System.out.print("\nPlease choose an option or Press 0 to go to main menu : ");
        int option = userInput();
        if (option >= 1 && option <= menuList.size()) {
            MenuItem selectedItem = menuList.get(option - 1);
            System.out.print("Please enter the quantity of the item" + "(eg 1 or 2 or 3 etc) or Press 0 to go to main menu  : ");
            int choice = userInput();
            if (choice > 0) {
                MenuItem orderedItem = new MenuItem(selectedItem.getName(), selectedItem.getPrice(), choice);
                selectedItems.add(orderedItem);
                System.out.println("\nItems added to cart!!!!");
                System.out.print("\nPlease enter 0 to go back to main menu or Press 9 to view cart : ");
                int goBack = userInput();
                if (goBack == 0) {
                    mainMenu(selectedItems);
                } else if (goBack == 9) {
                    viewCart(selectedItems);
                } else {
                    System.out.println("Please enter a valid option!!!");
                    displayMenu(restaurant);
                }
            } else {
                System.out.println("Please choose a valid choice");
                mainMenu(selectedItems);
            }
            allSelectedItems.add(selectedItems);
        } else if (option == 0) {
            mainMenu(selectedItems);
        } else {
            System.out.println("Please enter a valid option!!!");
            displayMenu(restaurant);
        }
    }

    private static void viewCart(List<MenuItem> selectedItems) {
        if (selectedItems.isEmpty()) {
            System.out.println("\nYour cart is empty!!!");
            System.out.println("Please add items to your cart!!!");
            System.out.println(" ");
            System.out.print("Press 0 to go to main menu : ");
            int choice = userInput();
            if (choice == 0) {
                mainMenu(selectedItems);
            } else {
                System.out.println("Please enter a valid choice");
                viewCart(selectedItems);
            }

        } else {
            System.out.println("\nYour cartList : ");
            System.out.println(" ");
            double totalPrice = 0;
            int i = 1;
            for (MenuItem item : selectedItems) {
                System.out.println(i + ". " + item.getName() + " Rs." + item.getPrice() + " x" + (int) item.getQuantity());
                double totalCost = item.getPrice() * item.getQuantity();
                System.out.println("   Total price : " + totalCost);
                totalPrice += totalCost;
                i++;
            }
            System.out.println(" ");
            System.out.println("Final Price : " +totalPrice);
            System.out.println(" ");
            System.out.print("Please 0 to go to main menu to or Press 9 to go to checkout : ");
            int choice = userInput();
            if (choice == 0) {
                mainMenu(selectedItems);
            } else if (choice == 9) {
                checkout(selectedItems);
            } else {
                System.out.println("Please enter a valid number!!!");
                viewCart(selectedItems);
            }
        }
    }

    private static void checkout(List<MenuItem> selectedItems) {

        if (selectedItems.isEmpty()) {
            System.out.println("\nYour cart is empty!!!");
            System.out.println("Please add items to your cart!!!");
            System.out.println(" ");
            System.out.print("Press 0 to go to main menu : ");
            int choice = userInput();
            if (choice == 0) {
                mainMenu(selectedItems);
            } else {
                System.out.println("Please enter a valid choice!!!");
                checkout(selectedItems);
            }
            mainMenu(selectedItems);
        } else {
            System.out.println("\nYour cartList");
            System.out.println(" ");
            double totalPrice = 0;
            int i = 1;
            for (MenuItem item : selectedItems) {
                System.out.println(i + ". " + item.getName() + " Rs." + item.getPrice() + " x" + (int) item.getQuantity());
                double totalCost = item.getPrice() * item.getQuantity();
                System.out.println("   Total price : " + totalCost);
                totalPrice += totalCost;
                i++;
            }
            System.out.println(" ");
            System.out.println("Final Total Price : " + totalPrice);
            System.out.println(" ");
            System.out.println("Checkout Options");
            System.out.println(" ");
            System.out.println("1. Esewa");
            System.out.println("2. Khalti");
            System.out.println("3. Mobile Banking");
            System.out.println("4. fonPay");
            System.out.println("5. Cash on Delivery");
            System.out.print("\nPlease choose an option to checkout or Press 0 to go to main menu : ");
            int choice = userInput();
            if (choice > 0 && choice <= 5) {
                System.out.println(" ");
                System.out.print("Your order will be delivered soon. Thank you for using BiteMore!!!!");
                System.out.println(" ");
                selectedItems.clear();
                System.out.print("\nPress any number to go to main menu : ");
                userInput();
                mainMenu(selectedItems);
            } else if (choice == 0) {
                mainMenu(selectedItems);
            } else {
                System.out.print("Please enter a valid option!!!");
                checkout(selectedItems);
            }
        }
    }

    private static void exit() {
        System.out.println("Thank you for using Bite More. Have a wonderful time!!!!");
        System.out.println(" ");
    }

    public static void runBiteMoreSystem() {
        List<MenuItem> selectedItems = new ArrayList<>();
        mainMenu(selectedItems);
    }
}
