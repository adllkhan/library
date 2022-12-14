package com.company;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String group;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(int id, String name, String surname, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void removeBook(int bookID){
        borrowedBooks.remove(bookID);
    }

    public void printBooks() {
        for (int i = 0; i < borrowedBooks.size(); ++i) {
            System.out.println(i + 1 + ". book: " + borrowedBooks.get(i).getTitle());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
