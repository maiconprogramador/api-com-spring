package com.company.nomoprojeto.api_com_spring.tarefas.api;

import com.company.nomoprojeto.api_com_spring.tarefas.dto.TarefaDto;
import com.company.nomoprojeto.api_com_spring.tarefas.facade.TarefaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.XmlEventDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasApi {
    @Autowired
    private TarefaFacade tarefaFacade;

    @PostMapping
    @ResponseBody
    public TarefaDto criar(@RequestBody TarefaDto tarefaDto) {
       return tarefaFacade.criarTarefa(tarefaDto);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDto atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDto tarefaDto){
        return  tarefaFacade.atualizar(tarefaDto, tarefaId);
    }
    @GetMapping
    @ResponseBody
    public List<TarefaDto> getAll() {
        return tarefaFacade.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String delete (@PathVariable("tarefaId") Long tarefaId) {
        return  tarefaFacade.deleteTarefa(tarefaId);
    }
}
