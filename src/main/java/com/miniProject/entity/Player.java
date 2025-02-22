package com.miniProject.entity;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "players")
public class Player implements Externalizable {
    @Serial
    private static final long serialVersionUID = 4638201649372946388L;

    @Id
    @Column
    private String userName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @Column(name = "image_path")
    private String imagePath;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private Feedback feedback;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(userName);
        out.writeObject(fullName);
        out.writeObject(password);
        out.writeObject(feedback);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userName = (String) in.readObject();
        fullName = (String) in.readObject();
        password = (String) in.readObject();
        feedback = (Feedback) in.readObject();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player p1) {
            return this.userName.equals(p1.userName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
