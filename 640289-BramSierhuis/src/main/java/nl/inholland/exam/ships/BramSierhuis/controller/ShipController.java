package nl.inholland.exam.ships.BramSierhuis.controller;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.model.dto.ShipDTO;
import nl.inholland.exam.ships.BramSierhuis.service.ManufacturerService;
import nl.inholland.exam.ships.BramSierhuis.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ships")
public class ShipController {

    @Autowired
    private ShipService shipService;

    //Gets all ships and returns them as a list in JSON
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ship>> getAllManufacturers(){
        List<Ship> ships = shipService.getAllShips();
        return ResponseEntity.status(HttpStatus.OK).body(ships);
    }

    //Add a ship to the db
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ship> createShip(@Validated @RequestBody ShipDTO shipDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shipService.addShip(shipDTO));
    }
}
