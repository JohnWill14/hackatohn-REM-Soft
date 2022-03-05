package br.com.remsoft.equipe3.hackathon.service;

import br.com.remsoft.equipe3.hackathon.error.BadRequestException;
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
    @Value("document.upload-directory")
    private String caminhoImage;
    private final CotacaoRepository cotacaoRepository;

    public Cotacao save(Cotacao cotacao){
        Cotacao cotacaoSave = cotacaoRepository.save(cotacao);
        return cotacaoSave;
    }

    public void addImage(Long id, MultipartFile file ){
        Cotacao cotacao = findById(id);
        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Path caminho = Paths.get(caminhoImage+cotacao.getId()+file.getOriginalFilename());
                Files.write(caminho,  bytes);
            }
            cotacao.setArquivoURL(cotacao.getId()+file.getOriginalFilename());
            save(cotacao);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao salvar imagem");
        }
    }

    public List<Cotacao> findAll(){
        return cotacaoRepository.findAll();
    }

    public Cotacao findById(Long id){
        return cotacaoRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("id nao encontrado"));
    }

    public List<Cotacao> findAllByIdEmpresa(Long id){
        return cotacaoRepository.findAll().stream()
                .filter(c -> c.getEmpresa().getId().equals(id))
                .collect(Collectors.toList());
    }
}
