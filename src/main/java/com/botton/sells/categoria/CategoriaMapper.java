package com.botton.sells.categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoriaMapper {

  Categoria map(CategoriaDTO source);

  @InheritInverseConfiguration
  CategoriaDTO map(Categoria source);



}
