package br.com.remsoft.equipe3.hackathon.service;

import br.com.remsoft.equipe3.hackathon.error.BadRequestException;
import br.com.remsoft.equipe3.hackathon.model.Empresa;
import br.com.remsoft.equipe3.hackathon.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public Empresa findByIdOrThrowException(Long id){
        Optional<Empresa> byId = empresaRepository.findById(id);
        return byId.orElseThrow(()-> new BadRequestException("id nao encontrado"));
    }

    public Empresa add(Empresa empresa){
        return empresaRepository.save(empresa);
    }
}
