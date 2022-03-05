package br.com.remsoft.equipe3.hackathon.repository;

import br.com.remsoft.equipe3.hackathon.model.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
