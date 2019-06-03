package br.com.polizello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.polizello.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>, PaisRepositoryCustom {

}
