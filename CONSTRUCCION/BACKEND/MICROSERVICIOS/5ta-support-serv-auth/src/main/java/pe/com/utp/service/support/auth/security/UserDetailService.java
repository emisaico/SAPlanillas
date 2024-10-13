package pe.com.utp.service.support.auth.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.utp.service.support.auth.account.domain.dto.Usuario;
import pe.com.utp.service.support.auth.repository.UsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repositorio.findByEmail(username);

        if(usuario!=null) {
            System.out.println("UserDetail1: " + usuario);
            return User.builder()
                    .username(usuario.getEmail())
                    .password(usuario.getContrasenia())
                    .roles(usuario.getRol().getTipo_rol())
                    .build();
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado: "+username);
        }
    }
}
