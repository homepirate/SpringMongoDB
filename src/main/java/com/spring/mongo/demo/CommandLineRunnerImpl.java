package com.spring.mongo.demo;

import com.spring.mongo.demo.model.Deal;
import com.spring.mongo.demo.model.Home;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private HomeService homeService;
    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData(){
//        List<Home> homes = homeService.getAll();
//        System.out.println(homes);

//        List<Home> homes = homeService.findHomeByType("flat");
//        System.out.println(homes);

//       Home home = homeService.updateCity(9996, "Luberzy");
//        System.out.println(home);
//
//        Owner owner = new Owner("Jack", "Loginov", 66);
//        Deal deal = new Deal("12.03.1995", 10000);
//        Home home = new Home("", "flat", "Moscow", 50, owner, 10000, deal);
//        Home h = homeService.createHome(home);
//        System.out.println(h);
//        homeService.removeHomeById(h.getId());

        System.out.println(homeService.getCountByCity("Moscow"));

        System.out.println(homeService.getHomeStatsByTypeAndSquare());
    }
}
