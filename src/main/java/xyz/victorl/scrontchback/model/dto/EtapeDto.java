package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Etape;
import xyz.victorl.scrontchback.model.entity.TypeEtape;

import java.io.Serializable;
import java.time.Duration;


/**
 * DTO for {@link Etape}
 */
@Value
public class EtapeDto implements Serializable {
    Integer id;
    Duration dureeEtape;
    String instructionsEtape;
    String imageEtape;
    TypeEtapeDto idTypeEtape;

    /**
     * DTO for {@link TypeEtape}
     */
    @Value
    public static class TypeEtapeDto implements Serializable {
        Integer id;
        String libTypeEtape;
    }
}