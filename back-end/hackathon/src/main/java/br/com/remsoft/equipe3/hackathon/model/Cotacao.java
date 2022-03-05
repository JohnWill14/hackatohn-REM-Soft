package br.com.remsoft.equipe3.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cotacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cotacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tituloCotacao;
    private String descricao;
    private LocalDate dataLimiteResposta;
    @OneToOne
    private Empresa empresa;
    private String arquivoURL;
}
