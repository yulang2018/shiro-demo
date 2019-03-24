package com.shiro.shirodemo.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer rid;
    private String name;
    private Set<Permision> permisionSet =new HashSet<>();
    private Set<User> users=new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permision> getPermisionSet() {
        return permisionSet;
    }

    public void setPermisionSet(Set<Permision> permisionSet) {
        this.permisionSet = permisionSet;
    }
}
