package nl.inholland.exam.ships.BramSierhuis.configuration;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.repository.ManufacturerRepository;
import nl.inholland.exam.ships.BramSierhuis.repository.ShipRepository;
import nl.inholland.exam.ships.BramSierhuis.service.ManufacturerService;
import nl.inholland.exam.ships.BramSierhuis.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

//Runner class to add default data to the database
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Autowired
    ShipRepository shipRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Create manufacturers
        Manufacturer corellian = new Manufacturer();
        corellian.setId(1000001);
        corellian.setName("Corellian Engineering Corporation");
        corellian.setAffiliation("Rebel Alliance");
        corellian.setCeo("Corran Destt");

        Manufacturer kuat = new Manufacturer();
        kuat.setId(1000002);
        kuat.setName("Kuat Drive Yards");
        kuat.setAffiliation("Galactic Republic");
        kuat.setCeo("Kuat of Kuat");

        Manufacturer sienar = new Manufacturer();
        sienar.setId(1000003);
        sienar.setName("Sienar Fleet Systems");
        sienar.setAffiliation("Galactic Republic");
        sienar.setCeo("Raith Sienar");

        //Create ships
        Ship cr90 = new Ship();
        cr90.setName("CR90");
        cr90.setManufacturerId(1000001);
        cr90.setType("Corvette");
        cr90.setLength(150);
        cr90.setCost(2700000);

        Ship executor = new Ship();
        executor.setName("Executor");
        executor.setManufacturerId(1000002);
        executor.setType("Dreadnought");
        executor.setLength(19000);
        executor.setCost(325000000);

        Ship tie = new Ship();
        tie.setName("TIE");
        tie.setManufacturerId(1000003);
        tie.setType("Fighter");
        tie.setLength(6.3);
        tie.setCost(60000);

        Ship lambda = new Ship();
        lambda.setName("Lambda");
        lambda.setManufacturerId(1000003);
        lambda.setType("Lambda");
        lambda.setLength(20);
        lambda.setCost(140000);

        //Add manufacturers to list
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(corellian);
        manufacturers.add(kuat);
        manufacturers.add(sienar);

        //Add ships to list
        List<Ship> ships = new ArrayList<>();
        ships.add(cr90);
        ships.add(executor);
        ships.add(tie);
        ships.add(lambda);

        //Save lists to db
        manufacturers.forEach(manufacturerRepository::save);
        ships.forEach(shipRepository::save);
    }
}
