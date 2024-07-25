package com.gestionrecettes.back.model.dto;

import com.gestionrecettes.back.model.entity.Etape;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetTime;
import java.util.Set;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Etape}
 */
@Value
public class EtapeDto implements Serializable {
    Integer id;
    OffsetTime dureeEtape;
    String instructionsEtape;
    byte[] imageEtape;
    TypeEtapeDto idTypeEtape;

    /**
     * DTO for {@link com.gestionrecettes.back.model.entity.TypeEtape}
     */
    @Value
    public static class TypeEtapeDto implements Serializable {
        Integer id;
        String libTypeEtape;
    }
}