package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Challenge {

    @Id
    @GeneratedValue
    private long id;

    private Muis challenger;
    private Muis challenged;
    private Opdracht opdracht;
    private long multiplier;

    public Challenge(){super();}
    public Challenge(Muis challenger, Muis challenged, Opdracht opdracht, long multiplier) {
        this.challenger = challenger;
        this.challenged = challenged;
        this.opdracht = opdracht;
        this.multiplier = multiplier;
    }

    public Muis getChallenger() {
        return challenger;
    }

    public void setChallenger(Muis challenger) {
        this.challenger = challenger;
    }

    public Muis getChallenged() {
        return challenged;
    }

    public void setChallenged(Muis challenged) {
        this.challenged = challenged;
    }

    public Opdracht getOpdracht() {
        return opdracht;
    }

    public void setOpdracht(Opdracht opdracht) {
        this.opdracht = opdracht;
    }

    public long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(long multiplier) {
        this.multiplier = multiplier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
