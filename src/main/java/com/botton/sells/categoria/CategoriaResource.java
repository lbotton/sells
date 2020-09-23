package com.botton.sells.categoria;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// nome do pacote deve ser .resources (nao controller)
@RestController
// nome do conceito no plural
@RequestMapping(value = "/categorias")
public class CategoriaResource {

  @Autowired
  private CategoriaService service;

  // GET all
  @GetMapping()
  public List<Categoria> all() {
    return service.findAll();
  }

  // GET id
  @GetMapping("/{id}")
  public EntityModel<Categoria> get(@PathVariable Long id) {
    Optional<Categoria> categoria = service.findById(id);
    if (!categoria.isPresent())
      throw new CategoriaNotFoundException("id-" + id);
    EntityModel<Categoria> resource = EntityModel.of(categoria.get());
    addLinksToResource(resource);
    return resource;
  }

  // POST
  @PostMapping()
  public ResponseEntity<Object> create(@RequestBody CategoriaDTO categoriaDTO) {
    Categoria categoriaSalva = service.save(categoriaDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(categoriaSalva.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  // PUT
  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@RequestBody CategoriaDTO categoriaDTO,
      @PathVariable Long id) {
    Optional<Categoria> categoriaOptional = service.findById(id);
    if (!categoriaOptional.isPresent())
      return ResponseEntity.notFound().build();

    service.update(categoriaDTO, id);
    return ResponseEntity.noContent().build();
  }

  // DELETE
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteById(id);

  }

  private void addLinksToResource(EntityModel<Categoria> resource) {
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).all());
    resource.add(linkTo.withRel("all-categorias"));
  }

}
