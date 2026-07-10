package com.javanauta.bffagendador.business;

import com.javanauta.bffagendador.business.dto.TarefasDTO;
import com.javanauta.bffagendador.business.enums.StatusNotificacaoEnum;
import com.javanauta.bffagendador.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);
    }
}