package xyz.victorl.scrontchback.model.dto;

import xyz.victorl.scrontchback.model.entity.ListeCourses;
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