package com.melina.beauty_salon_booking_backend.service.impl;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;
import com.melina.beauty_salon_booking_backend.mapper.ClientMapper;
import com.melina.beauty_salon_booking_backend.model.Client;
import com.melina.beauty_salon_booking_backend.repository.ClientRepository;
import com.melina.beauty_salon_booking_backend.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper clientMapper) {
        this.repository = repository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto request) {
        Client client = clientMapper.toEntity(request);
        Client savedClient = repository.save(client);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public ClientResponseDto getClientByCuit(String cuit) {
        Client client = repository.findByCuit(cuit)
                .orElseThrow(() -> new RuntimeException("Client not found with cuit: " + cuit));
        return clientMapper.toDto(client);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        List<Client> clients = repository.findAll();
        return clients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto updateClient(String cuit, ClientRequestDto request) {
        Client clientUpdate = repository.findByCuit(cuit)
                .orElseThrow(() -> new RuntimeException("Client not found with cuit_: " + cuit));

        clientUpdate.setName(request.getName());
        clientUpdate.setLastname(request.getLastname());
        clientUpdate.setAddress(request.getAddress());
        clientUpdate.setPhone(request.getPhone());
        clientUpdate.setEmail(request.getEmail());

        Client savedClient = repository.save(clientUpdate);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public void deleteClient(String cuit) {
        Client clientDelete = repository.findByCuit(cuit)
                .orElseThrow(() -> new RuntimeException("Client not found with cuit: " + cuit));
        repository.delete(clientDelete);

    }

    @Override
    public ClientResponseDto getClientByDni(String dni) {
        Client client = repository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Client not found with dni9: " + dni));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientResponseDto getClientByEmail(String email) {
        Client client = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found with email: " + email));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientResponseDto enableClient(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        client.setActivo(true);
        return clientMapper.toDto(repository.save(client));
    }

    @Override
    public ClientResponseDto disableClient(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        client.setActivo(false);
        return clientMapper.toDto(repository.save(client));
    }

}
