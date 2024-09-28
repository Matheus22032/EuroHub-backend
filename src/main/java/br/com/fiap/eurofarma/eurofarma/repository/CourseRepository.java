package br.com.fiap.eurofarma.eurofarma.repository;

import br.com.fiap.eurofarma.eurofarma.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
