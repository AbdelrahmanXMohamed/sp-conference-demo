package com.example.conferencedemo.controllers;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;
    @GetMapping
    public List<Session> list()
    {
        return sessionRepository.findAll();
    }
    @GetMapping()
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id)
    {
        return sessionRepository.getOne(id);
    }
    @PostMapping
    public Session create(@RequestBody final Session session)
    {
        return sessionRepository.saveAndFlush(session);
    }
    @RequestMapping(value = "{id}",method =RequestMethod.DELETE )
    public void delete(@PathVariable Long id )
    {
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}",method =RequestMethod.PUT )
    public Session update(@PathVariable Long id,@RequestBody Session session )
    {
        Session exitingSession=sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,exitingSession,"session_id");
        return sessionRepository.saveAndFlush(exitingSession);
    }

}

