package com.devjack.desafiobossabox.dto;

import java.util.List;

public record ToolsResponse(Long id, String titulo, String descricao, String link, List<String> tags) {


}
