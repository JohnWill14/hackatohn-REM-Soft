package br.com.remsoft.equipe3.hackathon.endpoint;

import br.com.remsoft.equipe3.hackathon.model.Cotacao;
import br.com.remsoft.equipe3.hackathon.service.CotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/cotacoes")
@AllArgsConstructor
public class CotacoesEndPoint {
    private CotacaoService cotacaoService;

    @PostMapping(value = "/", consumes = {
            "multipart/form-data",
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<?> save(Cotacao cotacao, @RequestParam("file")MultipartFile  file){
        Cotacao cotacoesSaved = cotacaoService.add(cotacao, file);
        return new ResponseEntity(cotacoesSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Cotacao> cotacaoAll = cotacaoService.findAll();
        return ResponseEntity.ok(cotacaoAll);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findAll(@RequestParam Long id){
        List<Cotacao> cotacoes = cotacaoService.findAllByIdEmpresa(id);
        return ResponseEntity.ok(cotacoes);
    }
}
