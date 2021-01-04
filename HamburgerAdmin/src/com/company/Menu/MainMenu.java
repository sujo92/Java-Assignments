package com.company.Menu;

import java.util.*;

public class MainMenu implements Menu {
    private Map<String,List<Item>> mainMenuTable = new HashMap<>();
    Scanner input = new Scanner(System.in);

    /**
     * adds new Main meny category and items
     */
    @Override
    public void createMenuEntry() {
        System.out.println("Press \n 1: Create new category \n 2: Create new Item in particular category");
        int choice = Integer.parseInt(input.nextLine());
        if(choice==1)
            addCategory();
        else if(choice==2)
            addNewItem();
        else
            System.out.println("Invalid Selection");
    }

    public void addCategory() {
        System.out.println("Enter the category name: ");
        String category1 = input.nextLine().toUpperCase();
        mainMenuTable.put(category1, new ArrayList<>());
    }

    public void addNewItem(){
        System.out.println("Enter the category name: ");
        String category1 = input.nextLine().toUpperCase();
        if(! mainMenuTable.containsKey(category1))
            mainMenuTable.put(category1,new ArrayList<>());
        boolean flag = false;
        while(! flag) {
            System.out.println("Enter the Item name: ");
            String item1 = input.nextLine();
            System.out.println("Enter the Item price: ");
            double price1 = Double.parseDouble(input.nextLine());
            System.out.println("Item comes with combo? \n 1:yes 2:no");
            int combo = Integer.parseInt(input.nextLine());
            Item newItem;
            if(combo==1){
                System.out.println("Enter combo price");
                double comboPrice = Double.parseDouble(input.nextLine());
                newItem = new Item(item1, price1,true,comboPrice);
            }else {
                newItem = new Item(item1, price1);
            }
            List<Item> items = mainMenuTable.get(category1);
            items.add(newItem);
            System.out.println("Do you want to add more Item in this category: 1: yes 2: No");
            int choice2 = Integer.parseInt(input.nextLine());
            if ((choice2) == 2) {
                System.out.println("ok");
                flag = true;
            }
        }
    }

    /**
     * Lists main menu
     */
    @Override
    public void readMenuEntry() {
        System.out.println("Press \n 1: List categories \n 2: List item in some category \n 3: Print main menu");
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 1) {
            readCategory();
        }
        else if (choice == 2) {
            readItemInCategory();
        }
        else if (choice == 3) {
            printMainMenu();
        }
        else {
            System.out.println("Invalid Selection");
        }
    }

    public void readCategory(){
        for(String category : mainMenuTable.keySet()){
            System.out.println(category);
        }
    }

    public void printMainMenu(){
        for(Map.Entry<String,List<Item>> e: mainMenuTable.entrySet()){
            System.out.println(e.getKey());
            System.out.println("=============");
            for(Item i: e.getValue()){
                System.out.println(i);
            }
        }
    }

    public void readItemInCategory(){
        System.out.println("Enter the category name: ");
        String category = input.nextLine().toUpperCase();
        for(Item i: mainMenuTable.get(category)){
            System.out.println(i.getName()+":"+i.getPrice());
        }
    }

    /**
     * Updates main menu
     */
    @Override
    public void updateMenuEntry() {
        System.out.println("Press \n 1: Update category name \n 2: Update Item in Category");
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 1)
            updateCategory();
        else if (choice == 2) {
            updateItemInCategory();
        }
        else
            System.out.println("Invalid Selection");
    }

    private void updateItemInCategory() {
        System.out.println("Enter the category name whose items needs to be updated: ");
        String category = input.nextLine().toUpperCase();
        List<Item> items = mainMenuTable.get(category);
        if(mainMenuTable.containsKey(category)) {
            System.out.println("Press \n 1: Update item name \n 2: Update Item price");
            int choice = Integer.parseInt(input.nextLine());
            if (choice == 1) {
                System.out.println("Enter old item name");
                String oldItem = input.nextLine();
                System.out.println("Enter new item name");
                String newItem = input.nextLine();
                for(Item i: items){
                    if(i.getName().equals(oldItem))
                        i.setName(newItem);
                }
            }
            else if (choice == 2) {
                System.out.println("Enter old item price");
                double oldItemPrice = Double.parseDouble(input.nextLine());
                System.out.println("Enter new item price");
                double newItemPrice = Double.parseDouble(input.nextLine());
                for(Item i: items){
                    if(i.getPrice() == oldItemPrice)
                        i.setPrice(newItemPrice);
                }
            }
            else{
                System.out.println("Invalid selection");
            }
        }else{
            System.out.println("No such category available");
        }
    }

    private void updateCategory() {
        System.out.println("Enter the old category name: ");
        String category = input.nextLine().toUpperCase();
        if(mainMenuTable.containsKey(category)){
            System.out.println("Enter the new category name: ");
            String newCategory = input.nextLine();
            List<Item> items = mainMenuTable.get(category);
            mainMenuTable.remove(category);
            mainMenuTable.put(newCategory,items);
        }else{
            System.out.println("No such category exist");
        }

    }

    /**
     * Deletes main menu items
     */
    @Override
    public void deleteMenuEntry() {
        System.out.println("Press \n 1: Delete category name \n 2: Delete Item in Category");
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 1) {
            System.out.println("Enter the category name: ");
            String category = input.nextLine().toUpperCase();
            mainMenuTable.remove(category);
        }
        else if (choice == 2) {
            deleteItemInCategory();
        }
        else
            System.out.println("Invalid Selection");
    }

    private void deleteItemInCategory() {
        printMainMenu();
        System.out.println("Enter the category name: ");
        String category = input.nextLine().toUpperCase();
        if(! mainMenuTable.containsKey(category))
            System.out.println("No such category found");
        else{
            List<Item> items= mainMenuTable.get(category);
            System.out.println("Enter item name: ");
            String deleteItem = input.nextLine();
            for(Item i: items){
                if(i.getName().equals(deleteItem)) {
                    items.remove(i);
                    printMainMenu();
                }
            }
        }
    }

    /**
     * main menu controller
     */
    @Override
    public void helper() {
        boolean flag=true;
        while(flag) {
            System.out.println("press \n 1: Add menu \n 2: List menu \n 3: Update menu \n 4: Delete menu \n 5: Exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    createMenuEntry();
                    break;
                case 2:
                    readMenuEntry();
                    break;
                case 3:
                    updateMenuEntry();
                    break;
                case 4:
                    deleteMenuEntry();
                    break;
                default:
                    System.out.println("Exiting");
                    flag=false;
                    break;
            }
        }
    }
}
