package br.com.remsoft.equipe3.hackathon.endpoint;

import br.com.remsoft.equipe3.hackathon.model.Empresa;
import br.com.remsoft.equipe3.hackathon.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresas")
@AllArgsConstructor
public class EmpresaEndPoint {
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> save(Empresa empresa){
        Empresa empresaSaved = empresaService.add(empresa);
        return new ResponseEntity(empresa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Empresa> serviceAll = empresaService.findAll();
        return ResponseEntity.ok(serviceAll);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@RequestParam Long id){
        Empresa empresa = empresaService.findByIdOrThrowException(id);
        return ResponseEntity.ok(empresa);
    }
}
