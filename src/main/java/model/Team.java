package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
public class Team implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private List<Muis> muizen;

    public Team(){super();}
    public Team(List<Muis> muizen){
        this.muizen = muizen;
    }
    public List<Muis> getMuizen() {
        return muizen;
    }

    public void setMuizen(List<Muis> muizen) {
        this.muizen = muizen;
    }

    public Muis addMuis(Muis m){
        if(muizen == null || muizen.contains(m)) return null;

        muizen.add(m);
        return m;
    }
}
