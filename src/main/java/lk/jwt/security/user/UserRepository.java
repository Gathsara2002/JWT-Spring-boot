package lk.jwt.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : Gathsara
 * created : 2/28/2024 -- 5:54 PM
 **/

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
