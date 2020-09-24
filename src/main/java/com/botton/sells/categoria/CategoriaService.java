package com.botton.sells.categoria;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {

  private final CategoriaRepository repo;

  private final CategoriaMapper categoriaMapper;

  public List<Categoria> findAll() {
    return (List<Categoria>) repo.findAll();
  }

  public Optional<Categoria> findById(Long id) {
    return repo.findById(id);
  }

  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  public Categoria update(CategoriaDTO c, Long id) {
    // if (!isValid(c)) {
    // return null;
    // }
    Categoria categoria = categoriaMapper.map(c);
    categoria.setId(id);
    return repo.save(categoria);
    // return repo.save(new Categoria());
  }

  public Categoria save(CategoriaDTO c) {
    // if (!isValid(c)) {
    // return null;
    // }

    return repo.save(categoriaMapper.map(c));
    // return repo.save(new Categoria());
  }

  // use this method when our business logic needs to read the saved changes at a later point during
  // the same transaction but before the commit.
  public Categoria saveAndFlush(Categoria c) {
    // if (!isValid(c)) {
    // return null;
    // }

    return repo.saveAndFlush(c);
  }

}
