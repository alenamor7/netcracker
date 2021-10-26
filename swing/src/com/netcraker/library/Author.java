package com.netcraker.library;


public class Author {
    private String name;
    private String gender;
    private String country;

    public Author(String name, String gender, String country) {
        this.name = name;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name ='" + name + '\'' +
                ", country ='" + country + '\'' +
                ", gender ='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return author.name.equals(name) && author.gender.equals(gender) && author.country.equals(country);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }
}
