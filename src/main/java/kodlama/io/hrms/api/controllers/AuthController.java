package kodlama.io.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;
@RestController
@RequestMapping("api/auth/")
public class AuthController {
	
	private AuthService authService;
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	@PostMapping("register")
	public ResponseEntity<Result> register(@Valid @RequestBody Jobseeker jobseeker)
	{
		return ResponseEntity.ok(this.authService.register(jobseeker));
	}


	
}
