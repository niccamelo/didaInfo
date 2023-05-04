package br.com.didainfo.controle.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.didainfo.controle.entidades.Adms;
import br.com.didainfo.controle.entidades.UserDetailsImpl;
import br.com.didainfo.controle.repositorios.AdmsRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdmsRepositorio admsRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Adms adms = admsRepositorio.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new UserDetailsImpl(adms);
    }
    
}
