package com.rafaeldsal.ws.minhaprata.repository;

import com.rafaeldsal.ws.minhaprata.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

  Boolean existsByEmail(String email);

  Boolean existsByCpf(String cpf);

  Boolean existsByPhoneNumber(String phoneNumber);

  Boolean existsByEmailAndIdNot(String email, Long id);

  Boolean existsByPhoneNumberAndIdNot(String phoneNumber, Long id);

}
