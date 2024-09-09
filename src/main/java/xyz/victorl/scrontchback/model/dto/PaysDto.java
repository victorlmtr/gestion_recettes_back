package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Pays;

import java.io.Serializable;

/**
 * DTO for {@link Pays}
 */
@Value
public class PaysDto implements Serializable {
    Integer id;
    String libPays;
    ContinentDto idContinent;
}