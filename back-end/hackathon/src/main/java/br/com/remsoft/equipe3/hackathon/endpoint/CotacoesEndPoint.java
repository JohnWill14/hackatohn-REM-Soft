package br.com.remsoft.equipe3.hackathon.endpoint;

import br.com.remsoft.equipe3.hackathon.model.Cotacao;
import br.com.remsoft.equipe3.hackathon.service.CotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cotacoes")
@AllArgsConstructor
public class CotacoesEndPoint {
    private CotacaoService cotacaoService;

    @PostMapping
    public ResponseEntity<?> save(Cotacao cotacao){
        Cotacao cotacoesSaved = cotacaoService.add(cotacao);
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
