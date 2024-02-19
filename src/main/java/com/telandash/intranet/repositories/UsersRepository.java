package com.telandash.intranet.repositories;

import com.telandash.intranet.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    Optional<UsersModel> findByUsername(String username);
}
