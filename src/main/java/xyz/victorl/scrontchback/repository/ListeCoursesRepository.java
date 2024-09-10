package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.ListeCourses;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListeCoursesRepository extends JpaRepository<ListeCourses, Integer> {
    @EntityGraph(attributePaths = {"ingredients", "nonFoodItems"})
    List<ListeCourses> findAll();

    @EntityGraph(attributePaths = {"ingredients", "nonFoodItems"})
    Optional<ListeCourses> findById(Integer id);
}