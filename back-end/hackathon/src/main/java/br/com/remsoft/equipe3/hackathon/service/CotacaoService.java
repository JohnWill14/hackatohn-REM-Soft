package br.com.remsoft.equipe3.hackathon.service;

import br.com.remsoft.equipe3.hackathon.model.Cotacao;
import br.com.remsoft.equipe3.hackathon.repository.CotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CotacaoService {
    @Value("ocument.upload-directory")
    private String caminhoImage;
    private final CotacaoRepository cotacaoRepository;

    public Cotacao add(Cotacao cotacao, MultipartFile file){
        Cotacao cotacaoSave = cotacaoRepository.save(cotacao);
        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Path caminho = Paths.get(caminhoImage+cotacaoSave.getId()+file.getOriginalFilename());
                Files.write(caminho,  bytes);
            }
            cotacaoSave.setArquivoURL(cotacaoSave.getId()+file.getOriginalFilename());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao salvar imagem");
        }
        return cotacaoSave;
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
