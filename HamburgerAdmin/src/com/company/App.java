package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hamburger Admin App
 */
public class App 
{
    static Scanner input = new Scanner(System.in);

    public static void main( String[] args )
    {
        boolean flag = true;
        while(flag) {
            System.out.println("press \n 1: Franchise \n 2: Menu \n 3: Exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    Franchise franchise = new Franchise();
                    franchise.helper();
                    break;
                case 2:
                    menuOptions();
                    break;
                case 3:
                    System.out.println("Exit");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
        }

    }

    public static void menuOptions(){
        System.out.println("press \n 1: Main menu \n 2: Special menu");
        int choice= Integer.parseInt(input.nextLine());
        switch(choice){
            case 1:
                Menu mainMenu = new MainMenu();
                mainMenu.helper();
                break;
            case 2:
                Menu specialMenu = new SpecialMenu();
                specialMenu.helper();
                break;
            default:
                System.out.println("Invalid Entry");
        }
    }
}
