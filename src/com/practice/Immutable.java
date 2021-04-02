package com.practice;

public final class Immutable {

    private final int id;
    private final String name;
    private final Age age;

    public Immutable(int id, String name, Age age){
        this.id = id;
        this.name = name;
        Age cloneAge = new Age();
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
}

class Age{
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
