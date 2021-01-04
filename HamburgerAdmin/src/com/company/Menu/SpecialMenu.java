package com.company.Menu;

import java.util.*;

public class SpecialMenu implements Menu {
    Map<String, Item> specialMenuTable = new HashMap<>();
    Scanner input = new Scanner(System.in);

    /**
     * adds special item for each day
     */
    @Override
    public void createMenuEntry() {
        System.out.println("Enter day in which item is to be added");
        String day = input.nextLine().toLowerCase();
        System.out.println("Enter the Item name: ");
        String item = input.nextLine();
        System.out.println("Enter the Item price: ");
        String price = input.nextLine();
        Item newItem = new Item(item, Double.valueOf(price));
        specialMenuTable.put(day,newItem);
    }

    /**
     * Lists all special items
     */
    @Override
    public void readMenuEntry() {
        for(Map.Entry<String, Item> e: specialMenuTable.entrySet()) {
            System.out.println(e.getKey());
            System.out.println("=============");
            System.out.println(e.getValue());
        }
    }

    /**
     * Updates items in special menu
     */
    @Override
    public void updateMenuEntry() {
        System.out.println("Enter day in which item is to be update");
        String day = input.nextLine().toLowerCase();
        Item oldItem = specialMenuTable.get(day);
        System.out.println("Enter the new Item name: ");
        String newItemName = input.nextLine();
        System.out.println("Enter the new Item price: ");
        double newItemPrice = Double.parseDouble(input.nextLine());
        oldItem.setName(newItemName);
        oldItem.setPrice(newItemPrice);
    }

    /**
     * deletes items in special menu
     */
    @Override
    public void deleteMenuEntry() {
        System.out.println("Enter day whose entry needs to be deleted");
        String day = input.nextLine().toLowerCase();
        if(specialMenuTable.containsKey(day))
            specialMenuTable.remove(day);
        else
            System.out.println("No such day available");
    }

    /**
     * Special menu controller
     */
    @Override
    public void helper(){
        boolean flag=true;
        while(flag) {
            System.out.println("press \n 1:add  \n 2:read \n 3:update \n 4:delete \n 5:Exit");
            int choice = Integer.valueOf(input.nextLine());
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
