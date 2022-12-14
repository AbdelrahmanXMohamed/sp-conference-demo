package com.example.conferencedemo.controllers;

import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;
    @GetMapping
    public List<Speaker> list()
    {
        return speakerRepository.findAll();
    }
    @GetMapping()
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker)
    {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}",method =RequestMethod.DELETE )
    public void delete(@PathVariable Long id )
    {
        speakerRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}",method =RequestMethod.PUT )
    public Speaker update(@PathVariable Long id,@RequestBody Speaker speaker )
    {
        Speaker exitingSession=speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,exitingSession,"speaker_id");
        return speakerRepository.saveAndFlush(exitingSession);
    }

}

