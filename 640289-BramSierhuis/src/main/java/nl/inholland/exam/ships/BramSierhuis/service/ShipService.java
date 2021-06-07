package nl.inholland.exam.ships.BramSierhuis.service;

import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> getAllShips(){
        return shipRepository.findAll();
    }

    public Ship addShip(Ship ship){
        //TODO: Add error checking
        shipRepository.save(ship);
        return ship;
    }
}
