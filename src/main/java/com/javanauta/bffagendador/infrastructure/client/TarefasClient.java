package com.javanauta.bffagendador.infrastructure.client;

import com.javanauta.bffagendador.business.dto.in.TarefasDTORequest;
import com.javanauta.bffagendador.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "tarefas", url = "${agendador-tarefas.url}") // Ajuste o name/url se no seu original for diferente
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam("dataInicial") LocalDateTime dataInicial,
            @RequestParam("dataFinal") LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(
            @RequestParam("status") com.javanauta.bffagendador.business.enums.StatusNotificacaoEnum status,
            @RequestParam("id") String id,
            @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTOResponse dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);
}