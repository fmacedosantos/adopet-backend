package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    boolean existsByIdAndAdotado(Long petId, boolean adotado);

    List<Pet> findAllByAdotado(boolean adotado);

    List<Pet> findByAbrigo(Abrigo abrigo);
}
