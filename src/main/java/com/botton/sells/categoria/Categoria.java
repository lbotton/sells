package com.botton.sells.categoria;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.botton.sells.config.persistence.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
// serializable: permite que os objetos sejam convertidos em uma sequencia de bytes
public class Categoria extends BaseEntity<Long> {

  private static final long serialVersionUID = 1L;

  private String nome;

  // associacoes


  // construtores



  // getters and setters

  // necessarios para comparar por valor
  // implementacao padrao: apenas id



}
