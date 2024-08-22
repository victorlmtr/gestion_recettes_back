package com.gestionrecettes.back.model.dto;

import com.gestionrecettes.back.model.dto.UtilisateurDto;
import com.gestionrecettes.back.model.entity.ListeCourses;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ListeCourses}
 */
@Value
public class ListeCoursesDto implements Serializable {
    Integer id;
    UtilisateurDto idUtilisateur;
    List<IngredientDto> ingredientDtoList;
    List<NonConsommableDto> nonConsommableDtoList;
}