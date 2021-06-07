package nl.inholland.exam.ships.BramSierhuis.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private String reason;
    private String message;
}