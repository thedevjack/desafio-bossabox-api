package com.devjack.desafiobossabox.repository;

import com.devjack.desafiobossabox.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {

    List<Tools> findByTagsIn(List<String> tag);

}
