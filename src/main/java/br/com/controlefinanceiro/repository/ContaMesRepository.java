package br.com.controlefinanceiro.repository;

import br.com.controlefinanceiro.model.ContaMes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaMesRepository extends JpaRepository<ContaMes, Integer> {
}