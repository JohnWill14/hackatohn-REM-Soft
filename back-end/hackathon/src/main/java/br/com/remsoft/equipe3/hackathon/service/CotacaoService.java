package br.com.remsoft.equipe3.hackathon.service;

import br.com.remsoft.equipe3.hackathon.model.Cotacao;
import br.com.remsoft.equipe3.hackathon.model.Empresa;
import br.com.remsoft.equipe3.hackathon.repository.CotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CotacaoService {
    private final CotacaoRepository cotacaoRepository;

    public Cotacao add(Cotacao cotacao){
        return cotacaoRepository.save(cotacao);
    }

    public List<Cotacao> findAll(){
        return cotacaoRepository.findAll();
    }

    public List<Cotacao> findAllByIdEmpresa(Long id){
        return cotacaoRepository.findAll().stream()
                .filter(c -> c.getEmpresa().getId().equals(id))
                .collect(Collectors.toList());
    }
}
