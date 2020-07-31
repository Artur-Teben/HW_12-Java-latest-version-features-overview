package model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;

    public User(String firstName, String lastName, Integer age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String formFirstName = String.format("First Name = %-8s", firstName);
        String formLastName = String.format("Last Name = %-8s", lastName);
        String formAge = String.format("Age = %-3s", age);
        String formPhoneNumber = String.format("Phone number = %-10s", phoneNumber);
        return  formFirstName +
                " | " + formLastName +
                " | " + formAge +
                " | " + formPhoneNumber +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(age, user.age) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, phoneNumber);
    }
}
