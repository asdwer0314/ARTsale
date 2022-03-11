package ru.sfedu.lab6Mongo;


import java.util.List;
import java.util.Objects;

public class Product implements AbsProducts{

    private int _id ;
    private String name;
    private Sphere  sphere;
    private List<AbsProducts> mirror;


    public Product(){}

    enum Sphere    {
        nana,
        lala,
        haha,
        tada,
        gaga;
    }

    public Product(int _id, String name, Sphere sphere, List<AbsProducts> mirror) {
        this._id = _id;
        this.name = name;
        this.sphere = sphere;
        this.mirror = mirror;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public AbsProducts Mirror() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public List<AbsProducts> getMirror() {
        return mirror;
    }

    public void setMirror(List<AbsProducts> mirror) {
        this.mirror = mirror;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return _id == product._id && getName().equals(product.getName()) && sphere == product.sphere && mirror.equals(product.mirror);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, getName(), sphere, mirror);
    }
}
