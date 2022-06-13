package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id) {
        return clientRepository.findClientById(id);
    }

    @GetMapping("/iin/{iin}")
        public Client getClientByIin(@PathVariable Integer iin) {
        return clientRepository.findUserByIin(iin);
        }
}
