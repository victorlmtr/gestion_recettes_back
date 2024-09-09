package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.NonFoodList;
import xyz.victorl.scrontchback.model.entity.NonFoodListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFoodListRepository extends JpaRepository<NonFoodList, NonFoodListId> {
}
