package nl.inholland.exam.ships.BramSierhuis.service;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.repository.ManufacturerRepository;
import nl.inholland.exam.ships.BramSierhuis.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Service to handle requests from the controller
@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    //Get all manufacturers
    public List<Manufacturer> getAllManufacturers(){
        return manufacturerRepository.findAll();
    }

    //Get all manufacturers by affiliation
    public List<Manufacturer> getAllManufacturersByAffiliation(String affiliation){
        return manufacturerRepository.findManufacturersByAffiliation(affiliation);
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer){
        //Check if name is in use
        if(manufacturerRepository.findByName(manufacturer.getName()) != null)
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Manufacturer name already in use");

        //Check if id is in use
        if(manufacturerRepository.findById(manufacturer.getId()) != null )
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Manufacturer id already in use");

        //Save and return created object
        manufacturerRepository.save(manufacturer);
        return manufacturer;
    }
}
