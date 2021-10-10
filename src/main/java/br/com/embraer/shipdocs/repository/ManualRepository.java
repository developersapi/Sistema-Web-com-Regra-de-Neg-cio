package br.com.embraer.shipdocs.repository;

import br.com.embraer.shipdocs.model.manual.Manual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualRepository extends JpaRepository<Manual, Long> {
}
