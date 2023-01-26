package springsecurity2.springsecurity2.repository;

import org.springframework.data.repository.CrudRepository;

import springsecurity2.springsecurity2.model.Usuario;



public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
}