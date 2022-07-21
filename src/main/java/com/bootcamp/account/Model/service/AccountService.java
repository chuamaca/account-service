package com.bootcamp.account.Model.service;

import com.bootcamp.account.Model.document.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AccountService { 

  Flux<Account> getAll() throws Exception;
  Mono<Account> save(Account account) throws Exception;
  Mono<Account> findById(String id) throws Exception;
  Mono<Boolean> existsById(String id) throws Exception;
  Mono<Void> deleteById(String id) throws Exception;
  Mono<Account> update (String id, Account account) throws Exception;
}
