package model;

import model.Enums.Status;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Prijs implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private Status status;
    private long points;

    public Prijs(){super();}

    public Prijs(String name, String description, long points) {
        this.name = name;
        this.description = description;
        this.points = points;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
