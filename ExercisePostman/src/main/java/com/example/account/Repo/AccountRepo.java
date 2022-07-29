package com.example.account.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.model.Account;


@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account,Long> {
@Query(value="select * from account where name=?1", nativeQuery=true)
List<Account>findAccountByName(String name);
}
