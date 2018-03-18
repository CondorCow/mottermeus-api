package service;

import com.mysql.cj.core.util.StringUtils;
import dao.IMuisDao;
import dao.JPA;
import model.Challenge;
import model.Enums.Rang;
import model.Enums.Role;
import model.Muis;
import model.Opdracht;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MuisService {

    @Inject
    @JPA
    IMuisDao dao;

    public MuisService(){super();}

    public List<Muis> getAllUsers() {
        return dao.findAll();
    }

    public Muis addMuis(String username, String password, String name, int age, String nickname){
        if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(username)) return null;
        return dao.create(new Muis(username, password, name, age, nickname));
    }

    public Muis addMuis(String username, String password, String name, int age, String nickname, boolean isAdmin){
        if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(username)) return null;
        return dao.create(new Muis(username, password, name, age, nickname, isAdmin));
    }

    public Muis findByUsername(String username){
        if(StringUtils.isNullOrEmpty(username)) return null;
        return dao.findByUsername(username);
    }

    public Muis updateMuis(Muis toUpdateMuis){
        Muis muis = dao.findByUsername(toUpdateMuis.getUsername());
        if(muis == null) return null;

        int age = toUpdateMuis.getAge();
        Rang rank = toUpdateMuis.getRank();
        Role role = toUpdateMuis.getRol();
        String nickname = toUpdateMuis.getNickname();
        long points = toUpdateMuis.getPoints();

        muis.setAge(age);
        if(rank != null) muis.setRank(rank);
        if(role != null) muis.setRol(role);
        if(nickname != null) muis.setNickname(nickname);
        muis.setPoints(points);

        return dao.update(muis);
    }

    public void deleteMuis(long toDeleteMuisId){
        Muis muis = dao.findById(toDeleteMuisId);
        if(muis != null) {
            dao.remove(muis);
        }
    }
    
    public Muis assignNewRank(long id, Rang rank){
        Muis muis = dao.findById(id);
        if(muis == null || rank == null) return null;
        
        muis.setRank(rank);
        return dao.update(muis);
    }

    public boolean authorizeUser(Muis muis) {
        Muis originalMuis = dao.findByUsername(muis.getUsername());
        return originalMuis != null && originalMuis.getPassword().equals(muis.getPassword());
    }
}
