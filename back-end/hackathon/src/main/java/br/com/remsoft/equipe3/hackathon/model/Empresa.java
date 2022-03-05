package br.com.remsoft.equipe3.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String senha;
    private String whatsapp;
}
