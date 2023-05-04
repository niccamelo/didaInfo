package br.com.didainfo.controle.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.didainfo.controle.entidades.Fornecedor;
import br.com.didainfo.controle.repositorios.FornecedorRepositorio;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorControle {
			
	@Autowired
    private FornecedorRepositorio fornecedorRepositorio;

		    @GetMapping
		    public ModelAndView home() {
		        ModelAndView modelAndView = new ModelAndView("fornecedor/home");
		        modelAndView.addObject("fornecedor", fornecedorRepositorio.findAll());
		        return modelAndView;
		    }

		    @GetMapping("/{id}")
		    public ModelAndView detalhes(@PathVariable Long id) {
		        ModelAndView modelAndView = new ModelAndView("fornecedor/detalhes");
		        modelAndView.addObject("fornecedor", fornecedorRepositorio.getOne(id));
		        return modelAndView;
		    }

		    @GetMapping("/cadastrar")
		    public ModelAndView cadastrar() {
		        ModelAndView modelAndView = new ModelAndView("fornecedor/formulario");
		        modelAndView.addObject("fornecedor", new Fornecedor());
		        return modelAndView;
		    }
		    
		    @GetMapping("/{id}/editar")
		    public ModelAndView editar(@PathVariable Long id) {
		        ModelAndView modelAndView = new ModelAndView("fornecedor/formulario");
		        modelAndView.addObject("fornecedor", fornecedorRepositorio.getOne(id));
		        return modelAndView;
		    }

		    @PostMapping({"/cadastrar", "/{id}/editar"})
		    public String salvar(Fornecedor fornecedor) {
		    	fornecedorRepositorio.save(fornecedor);
		        return "redirect:/fornecedor";
		    }

		    @GetMapping("/{id}/excluir")
		    public String excluir(@PathVariable Long id) {
		    	fornecedorRepositorio.deleteById(id);
		        return "redirect:/fornecedor";
		    }
		    
}
