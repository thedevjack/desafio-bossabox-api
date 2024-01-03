package com.devjack.desafiobossabox.services;

import com.devjack.desafiobossabox.dto.ToolsResponse;
import com.devjack.desafiobossabox.model.Tools;
import com.devjack.desafiobossabox.repository.ToolsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToolsService {

    private final ToolsRepository toolsRepository;

    public List<Tools> getAll(){
        List<Tools> toolsList = toolsRepository.findAll();
        return toolsList;
    }

    public Optional<Tools> getById(Long id){
        return toolsRepository.findById(id);
    }

    public List<Tools> getTollByTag(List<String> tags){
        List<Tools> toolsList = toolsRepository.findByTagsIn(tags);
        return toolsList;
    }

    public ToolsResponse saveTools(Tools tools){
        toolsRepository.save(tools);
        ToolsResponse toolsResponse = new ToolsResponse(
                tools.getId(),
                tools.getTitulo(),
                tools.getLink(),
                tools.getDescricao(),
                tools.getTags()
        );
        return toolsResponse;
    }

    public void deleteTools(Long id){
        toolsRepository.deleteById(id);
    }

    public boolean existById(Long id){
        boolean existTools = toolsRepository.existsById(id);
        return existTools;
    }



}
