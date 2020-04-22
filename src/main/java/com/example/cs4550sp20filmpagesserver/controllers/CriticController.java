package com.example.cs4550sp20filmpagesserver.controllers;

import com.example.cs4550sp20filmpagesserver.models.Critic;
import com.example.cs4550sp20filmpagesserver.services.CriticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://cs4550-sp20-filmpages-demo2.herokuapp.com",
        "https://cs4550-sp20-filmpages-final.herokuapp.com"},
        allowCredentials = "true")
public class CriticController {
    @Autowired
    CriticService service;

    @PostMapping("/api/critics")
    public Critic createCritic(HttpSession session,
                               @RequestBody Critic critic) {
        Critic newCritic = service.createCritic(critic);
        if (newCritic != null) {
            session.setAttribute("profile", newCritic);
        }
        return service.createCritic(critic);
    }

    @PutMapping("/api/critics/{criticId}")
    public int updateCritic(@PathVariable("criticId") Integer criticId, @RequestBody Critic critic) {
        return service.updateCritic(criticId, critic);
    }

    @DeleteMapping("/api/critics/{criticId}")
    public int deleteCritic(@PathVariable("criticId") Integer criticId) {
        return service.deleteCritic(criticId);
    }

    @GetMapping("/api/critics")
    public List<Critic> findAllCritics() {
        return service.findAllCritics();
    }

    @GetMapping("/api/critics/{criticId}")
    public Critic findCriticById(@PathVariable("criticId") Integer criticId) {
        return service.findCriticById(criticId);
    }

    @GetMapping("/api/critics/{username}/{password}")
    public Critic findCriticByCredentials(@PathVariable("username") String username,
                                          @PathVariable("password") String password) {
        return service.findCriticByCredentials(username, password);
    }

}
