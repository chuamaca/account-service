package com.bootcamp.account.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.account.Model.document.Account;
import com.bootcamp.account.Model.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller for accounts
 * 
 * @author aafernandez
 *
 */

@Validated
@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping()
	@Operation(summary = "Get list of account")
	public ResponseEntity<Flux<Account>> getAccount() throws Exception {
		Flux<Account> response = accountService.getAll();
		return new ResponseEntity<Flux<Account>>(response, HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = { "{id}" })
	@Operation(summary = "Get list of account by ID")
	public ResponseEntity<Mono<Account>> getAccountByID(@PathVariable("id") String id) throws Exception {
		Mono<Account> response = accountService.findById(id);
		return new ResponseEntity<Mono<Account>>(response, HttpStatus.OK);
	}

	/**
	 * 
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@Operation(summary = "Register new account")
	public Mono<Account> register(@RequestBody Account account) throws Exception {
		return accountService.save(account);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(path = { "{id}" })
	@Operation(summary = "Delete a account by Id")
	public Mono<Void> delete(@PathVariable("id") String id) throws Exception {
		return accountService.deleteById(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping(path = {"{id}"}, produces = { "application/json" })
	@Operation(summary = "Update a account by Id")
	public Mono<Account> update(@PathVariable("id") String id, @Valid @RequestBody Account account) throws Exception {
		return accountService.update(id,account);
	}
}
