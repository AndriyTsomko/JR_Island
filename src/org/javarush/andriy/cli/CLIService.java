package org.javarush.andriy.cli;

import java.util.Scanner;

public class CLIService {
    private final Scanner console = new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to island simulation!");
    }

    public int enterHeight(){
        System.out.println("Enter island height: ");
        return console.nextInt();
    }

    public int enterWidth(){
        System.out.println("Enter island width: ");
        return console.nextInt();
    }
}
