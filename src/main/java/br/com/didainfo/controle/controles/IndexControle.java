package br.com.didainfo.controle.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.didainfo.controle.entidades.Servicos;
import br.com.didainfo.controle.repositorios.ClienteRepositorio;
import br.com.didainfo.controle.repositorios.ServicosRepositorio;


@Controller
public class IndexControle {
	
    @Autowired
    private ServicosRepositorio servicosRepositorio;
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
	
	@Autowired
	@GetMapping("/login")
	public String login() {
		return "index/login";
	}
	
	
@RequestMapping("/index")
	@Autowired
	@GetMapping
	    public ModelAndView index() {
	        ModelAndView modelAndView = new ModelAndView("index/index");

	        modelAndView.addObject("servicos", servicosRepositorio.findAll());
	        modelAndView.addObject("cliente", clienteRepositorio.findAll());

	        return modelAndView;
	    }

}