package dao;

import model.Muis;

import java.util.List;

public interface IMuisDao {
    Muis findById(long id);

    Muis findByUsername(String username);

    List<Muis> findAll();

    Muis create(Muis entity);

    Muis update(Muis entity);

    void remove(Muis entity);
}
