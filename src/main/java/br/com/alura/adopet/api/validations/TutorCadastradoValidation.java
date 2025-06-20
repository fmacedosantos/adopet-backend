package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastroTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorCadastradoValidation {

    @Autowired
    TutorRepository tutorRepository;

    public void validar(CadastroTutorDTO dto) {
        if (tutorRepository.existsByEmailOrTelefone(dto.email(), dto.telefone())) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }
    }
}
