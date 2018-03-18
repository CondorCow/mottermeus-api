package service;

import model.Enums.Rang;
import model.Muis;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class StartUp {

    @Inject
    MuisService muisService;// = new MuisService();

    @PostConstruct
    public void initData(){
        //Change to call service
        Muis wart = muisService.addMuis("wartje123","ikbenlelijk", "Wart", 12, "Kwartje");
        muisService.assignNewRank(wart.getId(), Rang.MOTTERMEUS);
    }
}
