package nl.inholland.exam.ships.BramSierhuis.service;

import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.model.dto.ShipDTO;
import nl.inholland.exam.ships.BramSierhuis.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service to handle requests from the controller
@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    //Get all ships
    public List<Ship> getAllShips(){
        return shipRepository.findAll();
    }

    //Add a ship
    public Ship addShip(ShipDTO shipDTO){

        //Convert DTO to ship object
        Ship ship = new Ship(shipDTO);
        shipRepository.save(ship);

        //return created ship
        return ship;
    }
}
