package nl.inholland.exam.ships.BramSierhuis.model.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ShipDTO {
    @NotNull
    private String name;
    @NotNull
    private long manufacturerId;
    @NotNull
    private String type;
    @NotNull
    private double length;
    @NotNull
    private long cost;
}
