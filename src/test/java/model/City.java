package model;

public class City {
    public Integer id;
    public String name;
    public String zip;
    public String coordinates;
    public String country;

    public City setName(String name){
        this.name = name;
        return this;
    }

    public City setId(Integer id){
        this.id = id;
        return this;
    }
}
