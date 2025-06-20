package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastroAbrigoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbrigoCadastradoValidation {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public void validar(CadastroAbrigoDTO dto) {
        if (abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(),  dto.telefone(), dto.email())) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
    }
}
