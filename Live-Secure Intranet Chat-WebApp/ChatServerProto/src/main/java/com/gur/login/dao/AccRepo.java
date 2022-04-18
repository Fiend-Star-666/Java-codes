package com.gur.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gur.login.model.Account;
/**
 * @implNote: Repository Creation
 * @author gurms
 *
 */
@Repository
public interface AccRepo extends JpaRepository<Account, String> {
}