package gr.hua.dit.ds.springbootassignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import gr.hua.dit.ds.springbootassignment1.entity.User;

@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<User, Integer>{

	

}
