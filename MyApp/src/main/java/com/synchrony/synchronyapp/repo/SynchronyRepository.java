package com.synchrony.synchronyapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synchrony.synchronyapp.model.SynchronyUser;

@Repository
public interface SynchronyRepository extends JpaRepository<SynchronyUser, String> {

}
