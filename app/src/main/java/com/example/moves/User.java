package com.example.moves;

public class User {

    private String name;
    private String realname;
    private String bio;
    private String imageurl;


    public User(String name, String realname, String bio, String imageurl) {
        this.name = name;
        this.realname = realname;
        this.bio = bio;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
