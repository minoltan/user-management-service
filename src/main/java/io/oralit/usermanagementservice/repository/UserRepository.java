package io.oralit.usermanagementservice.repository;

import io.oralit.usermanagementservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMsisdn(String msisdn);
}
