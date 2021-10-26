package com.netcracker.shared;

import java.io.Serializable;

public class Author implements Serializable {
    String name;
    String surname;


    public Author(){}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Author)){
            return true;
        }
        Author author = (Author)obj;
        return author.name.equals(this.name) && author.surname.equals(this.surname);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
