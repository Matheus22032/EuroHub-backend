package br.com.fiap.eurofarma.eurofarma.repository;

import br.com.fiap.eurofarma.eurofarma.model.CourseStatus;
import br.com.fiap.eurofarma.eurofarma.model.CourseStatusKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStatusRepository extends JpaRepository<CourseStatus, CourseStatusKey> {
}
