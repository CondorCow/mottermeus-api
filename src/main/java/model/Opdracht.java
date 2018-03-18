package model;

import model.Enums.Moeilijkheidsgraad;
import model.Enums.Status;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement

public class Opdracht implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    @OneToMany
    private List<Team> teams;
    private long achievablePoints;
    private Moeilijkheidsgraad difficulty;
    private Status status;

    @OneToMany
    private List<Muis> wonBy;
//    private long maxTime;

    public Opdracht(){super();}
    public Opdracht(String name, String description, long achievablePoints, Moeilijkheidsgraad difficulty) {
        this.name = name;
        this.description = description;
        this.achievablePoints = achievablePoints;
        this.difficulty = difficulty;
    }
    public Opdracht(String name, String description, long achievablePoints, Moeilijkheidsgraad difficulty, List<Team> teams) {
        this.name = name;
        this.description = description;
        this.achievablePoints = achievablePoints;
        this.difficulty = difficulty;
//        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public long getAchievablePoints() {
        return achievablePoints;
    }

    public void setAchievablePoints(long achievablePoints) {
        this.achievablePoints = achievablePoints;
    }

    public Moeilijkheidsgraad getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Moeilijkheidsgraad difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Muis> getWonBy() {
        return wonBy;
    }

    public void setWonBy(List<Muis> wonBy) {
        this.wonBy = wonBy;
    }
}
