package com.netcracker.homework.one.book;

public class Author {

    private String name;
    private char gender;
    private String email;

    public Author() {
    }

    public Author(String name, char gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    * It's possible to use Objects.hash() and Objects.equals()
    * for equals() and hashCode() methods,
    * but we learned to do it by another way
    * */
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof Author)){
            return true;
        }
        Author author = (Author) o;
        return name.equals(author.name) && email.equals(author.email) && gender == author.gender;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + gender;
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + getName() + '\'' +
                ", gender=" + getGender() +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
