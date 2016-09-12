package com.model;

public class ProjectMember {
    private String name;
    private String function;
    private String email;
    private boolean active;

    public ProjectMember(String name, String function, String email, boolean active) {
        this.name = name;
        this.function = function;
        this.email = email;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
