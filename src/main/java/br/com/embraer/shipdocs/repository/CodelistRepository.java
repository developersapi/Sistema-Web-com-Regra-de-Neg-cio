package br.com.embraer.shipdocs.repository;

import br.com.embraer.shipdocs.model.codelist.Codelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodelistRepository extends JpaRepository<Codelist, Long> {
}
