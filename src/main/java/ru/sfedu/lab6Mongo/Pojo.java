package ru.sfedu.lab6Mongo;


import java.util.List;
import java.util.Objects;

public class Pojo implements AbsPojo{

    private int _id ;
    private String name;
    private Role role;
    private List<AbsPojo> mirror;

    public Pojo(){}

    enum Role    {
        nana,
        lala,
        haha,
        tada,
        gaga;
    }

    public Pojo(int _id, String name, Role role, List<AbsPojo> mirror) {
        this._id = _id;
        this.name = name;
        this.role = role;
        this.mirror = mirror;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public List<AbsPojo> getMirror() {
        return mirror;
    }
    public void setMirror(List<AbsPojo> mirror) {
        this.mirror = mirror;
    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public AbsPojo Mirror() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pojo)) return false;
        Pojo pojo = (Pojo) o;
        return get_id() == pojo.get_id() && getName()
                .equals(pojo.getName()) && getRole() == pojo.getRole() && getMirror()
                .equals(pojo.getMirror());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getName(), getRole(), getMirror());
    }
}
