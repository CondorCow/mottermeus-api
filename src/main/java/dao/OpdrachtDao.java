package dao;

import model.Muis;
import model.Opdracht;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@JPA
@Stateless
public class OpdrachtDao extends FDao<Opdracht> implements IOpdrachtDao {

    @PersistenceContext(unitName = "MottermeusPU")
    private EntityManager em;

    public OpdrachtDao(){super(Opdracht.class);}

}

