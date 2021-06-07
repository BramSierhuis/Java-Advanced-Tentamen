package nl.inholland.exam.ships.BramSierhuis.controller;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.service.ManufacturerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Class to handle requests to /manufacturers
@Controller
@RequestMapping("manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    //Gets all manufacturers and returns them as a list in JSON
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }

    //Gets all manufacturers with a specific affiliation and returns them as a list in JSON
    @GetMapping(value = "{affiliation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manufacturer>> getAllManufacturersByAffiliation(@PathVariable String affiliation){
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturersByAffiliation(affiliation);
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }

    //Add a manufacturer to the db
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manufacturer> createManufacturer(@Validated @RequestBody Manufacturer manufacturer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manufacturerService.addManufacturer(manufacturer));
    }
}
