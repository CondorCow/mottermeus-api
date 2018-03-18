package dao;

import model.Muis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@JPA
@Stateless
public class MuisDao extends FDao<Muis> implements IMuisDao {

    @PersistenceContext(unitName = "MottermeusPU")
    private EntityManager em;

    public MuisDao(){super(Muis.class);}

    public Muis findByUsername(String username) {
        try {
            return (Muis) em.createQuery("SELECT m FROM Muis m WHERE m.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) { return null; }
    }
}
