package com.devjack.desafiobossabox.dto;


import com.devjack.desafiobossabox.model.Tools;

import java.util.List;

public record ToolsRequest(String titulo, String descricao, String link, List<String> tags) {

    public Tools toModel(){
        return new Tools(titulo,descricao,link,tags);
    }


}
