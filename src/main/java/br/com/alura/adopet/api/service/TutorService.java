package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDTO;
import br.com.alura.adopet.api.dto.CadastroTutorDTO;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validations.TutorCadastradoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Autowired
    private TutorCadastradoValidation validation;

    public void cadastrar(CadastroTutorDTO dto) {
        Tutor tutor = new Tutor(dto);

        validation.validar(dto);

        repository.save(tutor);
    }

    public void atualizar(AtualizacaoTutorDTO dto) {
        Tutor tutor = repository.getReferenceById(dto.id());

        tutor.atualizarDados(dto);
    }
}
