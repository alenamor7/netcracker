package com.netcracker.homework.one;

public class Employee {

    private static int id = 0;
    private String name;
    private String surname;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        id = ++id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return getSalary() * 12;
    }

    public void raiseSalary(int percent) {
        this.salary = getSalary() + getSalary() * percent / 100;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof Employee)){
            return true;
        }
        Employee emp = (Employee)o;
        return emp.id == id && emp.name.equals(name)
                && emp.surname.equals(surname) && emp.salary == salary;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + id;
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
