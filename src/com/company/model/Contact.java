package com.company.model;

public class Contact {
    private String name;
    private int age;
    private String phoneNumber;

    public Contact(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber= " + phoneNumber +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getage() {
        return age;
    }

}
