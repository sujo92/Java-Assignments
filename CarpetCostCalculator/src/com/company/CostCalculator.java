package com.company;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class CostCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Make selection to know to know extra charges for special fabric");
        System.out.println("Enter N-Nylon, P-Polyster, W-wool, X-none");
        String fabric = in.nextLine();

        System.out.println("Enter the length of the room: ");
        int length = in.nextInt();

        System.out.println("Enter the width of the room: ");
        int width = in.nextInt();

        System.out.println("Enter the cost per square feet of carpet: ");
        int cost = in.nextInt();

        int fabric_cost=0;
        if(fabric.equals("N") || fabric.equals("P") || fabric.equals("W")){
            FabricFactory fabricFactory = new FabricFactory();
            CarpetFabric carpetFabric = fabricFactory.getFabric(fabric);
            fabric_cost = carpetFabric.getCost();
            System.out.println("Special Fabric Cost:" + fabric_cost);
        }else{
            System.out.println("No special fabric chosen");
        }

        RoomDimension roomDimension = new RoomDimension(length, width);
        RoomCarpet roomCarpet = new RoomCarpet(roomDimension, cost);
        System.out.print("Cost of carpet for the room: " + roomCarpet.totalCarpetCost()+fabric_cost);
        System.out.println();
    }
}
