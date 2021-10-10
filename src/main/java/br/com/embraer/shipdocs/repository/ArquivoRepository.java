package br.com.embraer.shipdocs.repository;

import br.com.embraer.shipdocs.model.manual.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}
