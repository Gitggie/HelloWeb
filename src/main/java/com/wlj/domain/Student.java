package com.wlj.domain;

public class Student {

    private int id;
    private String name;
    private String picture;
    private int major;
    private String detail;
    private int status;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", major=" + major +
                ", detail='" + detail + '\'' +
                ", status=" + status +
                '}';
    }

    public Student(int id, String name, String picture, int major, String detail, int status) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.major = major;
        this.detail = detail;
        this.status = status;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
