package br.com.remsoft.equipe3.hackathon.repository;

import br.com.remsoft.equipe3.hackathon.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
