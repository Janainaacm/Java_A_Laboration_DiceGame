package com.Janaina.demo.templates;

import java.util.Scanner;

public class GetInput {


    public int scannerNumber() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        System.out.println("Invalid input, try again!");
        return scannerNumber();
    }

    public String scannerText() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println("Invalid input, try again!");
            return scannerText();
        } else {
            return sc.nextLine();
        }

    }



}
