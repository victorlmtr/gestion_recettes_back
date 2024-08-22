package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.NonFoodList;
import com.gestionrecettes.back.model.entity.NonFoodListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFoodListRepository extends JpaRepository<NonFoodList, NonFoodListId> {
}
