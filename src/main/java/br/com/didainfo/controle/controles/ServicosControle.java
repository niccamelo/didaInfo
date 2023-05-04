package br.com.didainfo.controle.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.didainfo.controle.entidades.Servicos;
import br.com.didainfo.controle.repositorios.CaixaRepositorio;
import br.com.didainfo.controle.repositorios.ClienteRepositorio;
import br.com.didainfo.controle.repositorios.ServicosRepositorio;



@Controller
@RequestMapping("/servicos")
public class ServicosControle {

	

	    @Autowired
	    private ServicosRepositorio servicosRepositorio;

	    @Autowired
	    private ClienteRepositorio clienteRepositorio;
	    
	    @Autowired
	    private CaixaRepositorio caixaRepositorio;

	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("servicos/home");

	        modelAndView.addObject("servicos", servicosRepositorio.findAll());
	        return modelAndView;
	    }

	    @GetMapping("/{id}")
	    public ModelAndView detalhes(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("servicos/detalhes");

	        modelAndView.addObject("servicos", servicosRepositorio.getOne(id));
	        
	        return modelAndView;
	    }

	    @GetMapping("/cadastrar")
	    public ModelAndView cadastrar() {
	        ModelAndView modelAndView = new ModelAndView("servicos/formulario");

	        modelAndView.addObject("servicos", new Servicos());
	        modelAndView.addObject("clientes", clienteRepositorio.findAll());
	        modelAndView.addObject("caixa", caixaRepositorio.findAll());

	        return modelAndView;
	    }
	    
	    

	    @GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("servicos/formulario");

	        modelAndView.addObject("servicos", servicosRepositorio.getOne(id));
	        modelAndView.addObject("clientes", clienteRepositorio.findAll());
	        modelAndView.addObject("caixa", caixaRepositorio.findAll());
	        return modelAndView;
	    }

	    @PostMapping({"/cadastrar", "/{id}/editar"})
	    public String salvar(Servicos servicos) {
	    	servicosRepositorio.save(servicos);

	        return "redirect:/servicos";
	    }

	    @GetMapping("/{id}/excluir")
	    public String excluir(@PathVariable Long id) {
	    	servicosRepositorio.deleteById(id);

	        return "redirect:/servicos";
	    }
	    
	}
