package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.NonFoodListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import xyz.victorl.scrontchback.model.entity.ListeCourses;
import xyz.victorl.scrontchback.model.entity.NonConsommable;
import xyz.victorl.scrontchback.model.entity.NonFoodList;

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