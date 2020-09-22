package com.botton.sells.categoria;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {

  @Autowired
  private final CategoriaRepository repo;

  public List<Categoria> findAll() {
    return (List<Categoria>) repo.findAll();
  }

  public Optional<Categoria> findById(Long id) {
    return repo.findById(id);
  }

  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  public Categoria save(Categoria c) {
    // if (!isValid(c)) {
    // return null;
    // }

    return repo.save(c);
  }

}
