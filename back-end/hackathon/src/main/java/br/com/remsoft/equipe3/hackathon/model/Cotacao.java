package br.com.remsoft.equipe3.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.FileInputStream;
import java.time.LocalDate;

@Entity
@Table(name = "cotacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cotacao {
    private String tituloCotação;
    private String descricao;
    private LocalDate dataLimiteResposta;
    @OneToOne
    private Empresa empresa;
    private String arquivo;
}
