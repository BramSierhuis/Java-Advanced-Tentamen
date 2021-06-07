package nl.inholland.exam.ships.BramSierhuis.repository;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repository to interact with the db for manufacturers
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name); //Get a manufacturer by name
    Manufacturer findById(long name); //Get a manufacturer by Id
    List<Manufacturer> findManufacturersByAffiliation(String affiliation); //Get manufacturers by affiliation
}
