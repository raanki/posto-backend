package fr.posto.project.Posto.repository;

import fr.posto.project.Posto.model.Article;
import fr.posto.project.Posto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);
}
