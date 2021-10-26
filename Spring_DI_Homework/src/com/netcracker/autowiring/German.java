package com.netcracker.autowiring;

public class German implements Language{
    public void sayHi() {
        System.out.println("Guten Morgen");
    }

    public void sayBye() {
        System.out.println("Auf Wiedersehen");
    }
}
