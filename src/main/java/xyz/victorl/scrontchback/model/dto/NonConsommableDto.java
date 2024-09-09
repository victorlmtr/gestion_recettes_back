package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.NonConsommable;

import java.io.Serializable;

/**
 * DTO for {@link NonConsommable}
 */
@Value
public class NonConsommableDto implements Serializable {
    Integer id;
    String libNonConsommable;
}