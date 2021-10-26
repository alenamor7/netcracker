package com.netcracker.autowiring;

public class Russian implements Language{
    public void sayHi() {
        System.out.println("Привет");
    }

    public void sayBye() {
        System.out.println("До встречи");
    }
}
