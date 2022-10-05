package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner input = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    private int printStudents() {
        if(!students.isEmpty()) {
            System.out.println("Choose the student: ");
            for (int i = 0; i < students.size(); i++) {
                System.out.println(i + 1 + ". student: " + students.get(i).getName());
            }
            int ID = input.nextInt() - 1;
            return ID;
        } else {
            System.out.println("There is no students.");
            return 0;
        }
    }

    private int printBooks() {
        System.out.println("Choose the book: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". book: " + books.get(i).getTitle());
        }
        int ID = input.nextInt() - 1;
        return ID;
    }

    private Book enterBook(Book scan) {
        if (scan.getTitle() == null) {
            System.out.println("Please, enter the Title: ");
            String variable = input.nextLine();
            scan.setTitle(variable);
        }
        if (scan.getAuthor() == null) {
            System.out.println("Please, enter the Author: ");
            String variable = input.nextLine();
            scan.setAuthor(variable);
        }
        if (scan.getIsbn() == null) {
            System.out.println("Please, enter the ISBN: ");
            String variable = input.nextLine();
            scan.setIsbn(variable);
        }
        if (scan.getYear() == 0) {
            System.out.println("Please, enter the Year: ");
            int variable = input.nextInt();
            scan.setYear(variable);
        }
        if (scan.getQuantity() == 0) {
            System.out.println("Please, enter the Quantity: ");
            int variable = input.nextInt();
            scan.setQuantity(variable);
        }
        return scan;
    }

    private Student enterStudent(Student scan) {
        if(scan.getId() == 0) {
            System.out.println("Please, enter the ID: ");
            int variable = input.nextInt();
            scan.setId(variable);
        }
        if(scan.getName() == null) {
            System.out.println("Please, enter the Name: ");
            String variable = input.nextLine();
            scan.setName(variable);
        }
        if(scan.getSurname() == null) {
            System.out.println("Please, enter the Surname: ");
            String variable = input.nextLine();
            scan.setSurname(variable);
        }
        if(scan.getGroup() == null) {
            System.out.println("Please, enter the Group: ");
            String  variable = input.nextLine();
            scan.setGroup(variable);
        }
        return scan;
    }

    public void addBook() {
        System.out.println("(Type 0 to quit) Enter the title, author, ISBN, year, quantity: ");
        if(input.nextInt() != 0) {
            String title = input.next();
            String author = input.next();
            String isbn = input.next();
            int year = input.nextInt();
            int quantity = input.nextInt();
            Book book = new Book(title, author, isbn, year, quantity);
            book = enterBook(book);
            books.add(book);
            System.out.println("Book added to library.");
        }
    }

    public void addStudent() {
        System.out.println("(Type 0 to quit) Enter the name, surname, group, id: ");
        if (input.nextInt() != 0) {
            String name = input.next();
            String surname = input.next();
            String group = input.next();
            int id = input.nextInt();
            Student student = new Student(id, name, surname, group);
            student = enterStudent(student);
            students.add(student);
            System.out.println("Student added to library.");
        }
    }

    public void addBookToStudent() {;
        System.out.println("Type 0 to quit or 1 to continue: ");
        if (input.nextInt() != 0) {
            if (!books.isEmpty()) {
                int ID = printBooks();
                Book book = books.get(ID);
                if (!students.isEmpty()) {
                    ID = printStudents();
                    Student student = students.get(ID);
                    student.getBorrowedBooks().add(book);
                    if (book.getQuantity() > 1) {
                        book.setQuantity(book.getQuantity() - 1);
                    } else {
                        books.remove(ID);
                    }
                    System.out.println("Book added to Student.");
                } else {
                    System.out.println("There are no students.");
                }
            } else {
                System.out.println("There are no books.");
            }
        }
    }

    public void returnBookFromStudent() {
        System.out.println("Type 0 to quit or 1 to continue: ");
        if (input.nextInt() != 0) {
            if (!students.isEmpty()) {
                int ID = printStudents();
                Student student = students.get(ID);
                if (!student.getBorrowedBooks().isEmpty()) {
                    student.printBooks();
                    ID = input.nextInt() - 1;
                    Book book = student.getBorrowedBooks().get(ID);
                    student.removeBook(ID);
                    boolean helper = false;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getTitle().equals(book.getTitle())) {
                            helper = true;
                            break;
                        }
                    }
                    if (helper) {
                        book.setQuantity(book.getQuantity() + 1);
                    } else {
                        books.add(book);
                    }
                    System.out.println("Book returned from student.");
                } else {
                    System.out.println("There are no borrowed books.");
                }
            } else {
                System.out.println("There are no students.");
            }
        }
    }

    public void printBooksInformation() {
        System.out.println("Type 0 to quit or 1 to continue: ");
        if (input.nextInt() != 0) {
            if (!books.isEmpty()) {
                int ID = printBooks();
                Book book = books.get(ID);
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Year: " + book.getYear());
                System.out.println("Quantity: " + book.getQuantity());
            } else {
                System.out.println("Thre are no books.");
            }
        }
    }

    public void printStudentsInformation() {
        System.out.println("Type 0 to quit or 1 quit: ");
        if (input.nextInt() != 0) {
            if (!students.isEmpty()) {
                int ID = printStudents();
                Student student = students.get(ID);
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Surname: " + student.getSurname());
                System.out.println("Group: " + student.getGroup());
                System.out.print("Borrowed Books: ");
                student.printBooks();
            } else {
                System.out.println("There are no students.");
            }
        }
    }

    public void printStudentsBooks() {
        System.out.println("Type 0 to quit or 1 to continue: ");
        if (input.nextInt() != 0) {
            if (!students.isEmpty()) {
                int ID = printStudents();
                if (!students.get(ID).getBorrowedBooks().isEmpty()) {
                    students.get(ID).printBooks();
                } else {
                    System.out.println("There are no borrowed books.");
                }
            } else {
                System.out.println("There are no students.");
            }
        }
    }
}
