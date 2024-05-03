package br.com.tools.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tools.dto.TransacaoDto;
import br.com.tools.service.TransacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao", consumes ="application/json", produces = "application/json")
public class TransacaoController {

    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWord() {
        return ResponseEntity.ok("Bem vindo!");
    }

    @PostMapping(value = "/pagamento")
    public ResponseEntity<TransacaoDto> processarPagamento(@Valid @RequestBody TransacaoDto transacao) {
        TransacaoDto transacaoDto = transacaoService.processarTransacao(transacao);
        return transacaoDto == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(transacaoDto);
    }

    @GetMapping(value = "/todosPagamentos")
    public ResponseEntity<List<TransacaoDto>> getAllPagamento() {
    	List<TransacaoDto> transacaoList = transacaoService.buscarTodosOsRegistros();
    	return transacaoList.isEmpty() ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(transacaoList);
    }
    
    @GetMapping(value = "/pagamento/{id}")
    public ResponseEntity<TransacaoDto> getPagamentoById(@PathVariable String id) {
        TransacaoDto transacaoDto = transacaoService.buscarTransacaoPorId(id);
        return transacaoDto == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(transacaoDto);
    }

    @GetMapping(value = "/estorno/{id}")
    public ResponseEntity<TransacaoDto> getEstornoById(@PathVariable String id) {
        TransacaoDto transacaoDto = transacaoService.buscarEstornoPorId(id);
        return transacaoDto == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(transacaoDto);
    }
}
