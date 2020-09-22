package com.botton.sells.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.botton.sells.domain.Categoria;

//nome do pacote deve ser .resources (nao controller)
@RestController
//nome do conceito no plural
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Informatica");
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias;
	}
	
}
