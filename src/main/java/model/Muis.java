package model;

import model.Enums.Rang;
import model.Enums.Role;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Muis implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String username;
    private String password;
    private int age;
    private Rang rank;
    private Role role;
    private String nickname;
    private long points = 0;

    @OneToMany
    private List<Prijs> rewards;


    public Muis(){ super(); }

    public Muis(String username, String password, String name, int age, String nickname) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.nickname = nickname;
        rewards = new ArrayList<>();
        rank = Rang.MUIZENJONG;
        role = Role.USER;
    }
    public Muis(String username, String password, String name, int age, String nickname, boolean isAdmin) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.nickname = nickname;
        rewards = new ArrayList<>();
        rank = Rang.MUIZENJONG;
        if(isAdmin) role = Role.ADMIN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rang getRank() {
        return rank;
    }

    public void setRank(Rang rank) {
        this.rank = rank;
    }

    public Role getRol() {
        return role;
    }

    public void setRol(Role rol) {
        this.role = rol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public List<Prijs> getRewards() {
        return rewards;
    }

    public void setRewards(List<Prijs> rewards) {
        this.rewards = rewards;
    }
}

