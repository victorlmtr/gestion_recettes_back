package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.NonConsommableDto;
import com.gestionrecettes.back.model.dto.NonFoodListDto;
import com.gestionrecettes.back.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NonFoodListMapper {

    @Mapping(target = "idListeCourses", source = "id.idListeCourses")
    @Mapping(target = "idNonConsommable", source = "id.idNonConsommable")
    NonFoodListDto toDto(NonFoodList entity);

    @Mapping(target = "id.idListeCourses", source = "idListeCourses")
    @Mapping(target = "id.idNonConsommable", source = "idNonConsommable")
    NonFoodList toEntity(NonFoodListDto dto);

    default ListeCourses map(Integer idListeCourses) {
        if (idListeCourses == null) {
            return null;
        }
        ListeCourses listeCourses = new ListeCourses();
        listeCourses.setId(idListeCourses);
        return listeCourses;
    }

    default NonConsommable mapNonConsommable(Integer idNonConsommable) {
        if (idNonConsommable == null) {
            return null;
        }
        NonConsommable nonConsommable = new NonConsommable();
        nonConsommable.setId(idNonConsommable);
        return nonConsommable;
    }

    default Integer map(ListeCourses listeCourses) {
        return listeCourses != null ? listeCourses.getId() : null;
    }

    default Integer mapNonConsommable(NonConsommable nonConsommable) {
        return nonConsommable != null ? nonConsommable.getId() : null;
    }
}