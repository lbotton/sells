package com.botton.sells.config.persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.botton.sells.categoria.Categoria;
import com.botton.sells.categoria.CategoriaRepository;

@Component
public class DatabaseLoader {

  // class needs to be @Component
  @Bean
  CommandLineRunner init(CategoriaRepository repository) { // (1)

    return args -> { // (2)
      repository.save(new Categoria("grande mocha")); // (3)
      repository.save(new Categoria("venti hazelnut machiatto"));
    };
  }
}

