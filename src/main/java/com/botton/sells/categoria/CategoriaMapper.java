package com.botton.sells.categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  CategoriaDTO map(Categoria source);

  @InheritInverseConfiguration
  Categoria map(CategoriaDTO source);

}
