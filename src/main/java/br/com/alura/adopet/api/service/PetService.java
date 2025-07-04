package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDTO;
import br.com.alura.adopet.api.dto.PetDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDTO> listarTodosDisponiveis() {
        return repository.findAllByAdotado(false).stream().map(PetDTO::new).toList();
    }

    public void cadastrarPet(Abrigo abrigo, @Valid CadastroPetDTO dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
