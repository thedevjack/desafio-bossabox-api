package com.devjack.desafiobossabox.controller;


import com.devjack.desafiobossabox.dto.ToolsRequest;
import com.devjack.desafiobossabox.dto.ToolsResponse;
import com.devjack.desafiobossabox.model.Tools;
import com.devjack.desafiobossabox.services.ToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tools")
public class ToolsController {

    private final ToolsService toolsService;

    @GetMapping({"/all"})
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(toolsService.getAll());
    }

    @GetMapping("/{tag}")
    public ResponseEntity<?> findToolsByTag(@RequestParam List<String> tag) {
        return ResponseEntity.ok(toolsService.getTollByTag(tag));
    }

    @PostMapping
    public ResponseEntity<?> saveTools(@RequestBody ToolsRequest toolsRequest) {
        Tools toolsToSave = toolsRequest.toModel();
        ToolsResponse toolsResponse = toolsService.saveTools(toolsToSave);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(toolsResponse.id())
                .toUri();


        return ResponseEntity.created(headerLocation).body(toolsResponse);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteTools(@RequestParam Long id){
        toolsService.deleteTools(id);
        return ResponseEntity.ok().body("INFO: Tool deletada");
    }

}
