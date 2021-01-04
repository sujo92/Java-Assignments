package com.company.Location;

import com.company.Location.Location;

import java.util.*;

public class Franchise{
    Map<String, Location> franchiseTable = new HashMap<>();
    Scanner input = new Scanner(System.in);

    /**
     * Adds new franchise
     */
    public void addFranchise() {
        System.out.println("Enter new franchise latitude");
        double lat = Double.parseDouble(input.nextLine());
        System.out.println("Enter new franchise longitude");
        double lon = Double.parseDouble(input.nextLine());
        System.out.println("Enter new franchise city");
        String city = input.nextLine();
        System.out.println("Enter new franchise address");
        String addr = input.nextLine();
        System.out.println("Enter new franchise contact no");
        String contact = input.nextLine();
        Location newLocaltion = new Location(lat, lon, contact,addr);
        franchiseTable.put(city,newLocaltion);
    }

    /**
     * Lists all franchise
     */
    public void listFranchise() {
        for(Map.Entry<String,Location> loc :  franchiseTable.entrySet()){
            System.out.println(loc.getKey());
            System.out.println("=============");
            System.out.println(loc.getValue());
        }
    }

    /**
     * Updates franchise state
     */
    public void updateFranchise() {
        System.out.println("Enter franchise city");
        String city = input.nextLine();
        if(franchiseTable.containsKey(city)){
            Location loc = franchiseTable.get(city);
            System.out.println("press \n 1: Update lat \n 2: Update long \n 3: Update addr \n 4: Update number");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Enter new lat");
                    double lat = Double.parseDouble(input.nextLine());
                    loc.setLatitude(lat);
                    break;
                case 2:
                    System.out.println("Enter new lon");
                    double lon = Double.parseDouble(input.nextLine());
                    loc.setLongitude(lon);
                    break;
                case 3:
                    System.out.println("Enter new address");
                    String addr = input.nextLine();
                    loc.setAddress(addr);
                    break;
                case 4:
                    System.out.println("Enter new number");
                    String number = input.nextLine();
                    loc.setPhone(number);
                    break;
            }
        }else{
            System.out.println("No such franchise city found");
        }
    }

    /**
     * De;ets franchise
     */
    public void deleteFranchise() {
        System.out.println("Enter new franchise city");
        String city = input.nextLine();
        if(franchiseTable.containsKey(city)) {
            franchiseTable.remove(city);
        } else{
            System.out.println("No such city found");
        }
    }

    /**
     * Franchise controller
     */
    public void helper() {
        boolean flag=true;
        while(flag) {
            System.out.println("press \n 1: Add new franchise \n 2: List all franchise \n 3: Update franchise info \n 4: DeleteFranchise \n 5: Exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    addFranchise();
                    break;
                case 2:
                    listFranchise();
                    break;
                case 3:
                    updateFranchise();
                    break;
                case 4:
                    deleteFranchise();
                    break;
                case 5:
                    System.out.println("Exiting");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid key pressed");
                    break;
            }
        }
    }
}
