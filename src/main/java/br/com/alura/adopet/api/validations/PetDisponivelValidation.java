package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetDisponivelValidation implements SolicitacaoAdocaoValidation {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        if (petRepository.existsByIdAndAdotado(dto.idPet(), true)) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}
