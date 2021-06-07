package nl.inholland.exam.ships.BramSierhuis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ship {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    private Manufacturer manufacturer;

    private String type;
    private double length;
    private long cost;
}
