package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.println("Welcome to the AITU Library");
            System.out.println("1. Add book");
            System.out.println("2. Add student");
            System.out.println("3. Give book to student");
            System.out.println("4. Return book from student");
            System.out.println("5. Print books information");
            System.out.println("6. Print students information");
            System.out.println("7. Print student's books");
            System.out.println("0. Exit");

            choice = input.nextInt();

            switch (choice) {

                case 1: library.addBook(); break;

                case 2: library.addStudent(); break;

                case 3: library.addBookToStudent(); break;

                case 4: library.returnBookFromStudent(); break;

                case 5: library.printBooksInformation(); break;

                case 6: library.printStudentsInformation(); break;

                case 7: library.printStudentsBooks(); break;

            }
        }
    }
}
