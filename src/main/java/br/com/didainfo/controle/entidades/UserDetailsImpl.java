package br.com.didainfo.controle.entidades;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.didainfo.controle.entidades.Adms;

public class UserDetailsImpl implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Adms adms;

    public UserDetailsImpl(Adms adms) {
        this.adms = adms;
    }

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * Perfil perfil = funcionario.getCargo().getNome().equals("Gerente") ?
	 * Perfil.ADMIN : Perfil.USER;
	 * 
	 * return AuthorityUtils.createAuthorityList(perfil.toString()); }
	 */

    @Override
    public String getPassword() {
        return adms.getSenha();
    }

    @Override
    public String getUsername() {
        return adms.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
