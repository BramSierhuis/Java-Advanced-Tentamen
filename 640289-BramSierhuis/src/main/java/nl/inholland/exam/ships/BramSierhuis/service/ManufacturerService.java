package nl.inholland.exam.ships.BramSierhuis.service;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import nl.inholland.exam.ships.BramSierhuis.repository.ManufacturerRepository;
import nl.inholland.exam.ships.BramSierhuis.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
        return manufacturer;
    }
}
