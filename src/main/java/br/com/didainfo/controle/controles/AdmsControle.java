package br.com.didainfo.controle.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.didainfo.controle.entidades.Adms;
import br.com.didainfo.controle.entidades.UF;
import br.com.didainfo.controle.repositorios.AdmsRepositorio;
import br.com.didainfo.controle.utils.SenhaUtils;


@Controller
@RequestMapping("/adms")

public class AdmsControle {

    @Autowired
    private AdmsRepositorio admsRepositorio;

    

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("adms/home");

        modelAndView.addObject("adms", admsRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("adms/detalhes");

        modelAndView.addObject("adms", admsRepositorio.getOne(id));

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("adms/formulario");

        modelAndView.addObject("adms", new Adms());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }
    
   

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("adms/formulario");

        modelAndView.addObject("adms", admsRepositorio.getOne(id));
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Adms adms) {
        String senhaEncriptada = SenhaUtils.encode(adms.getSenha());

        adms.setSenha(senhaEncriptada);
        admsRepositorio.save(adms);

        return "redirect:/adms";
    }

    @PostMapping("/{id}/editar")
    public String editar(Adms adms, @PathVariable Long id) {
        String senhaAtual = admsRepositorio.getOne(id).getSenha();
        adms.setSenha(senhaAtual);

        admsRepositorio.save(adms);

        return "redirect:/adms";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
    	admsRepositorio.deleteById(id);

        return "redirect:/adms";
    }
    
}
