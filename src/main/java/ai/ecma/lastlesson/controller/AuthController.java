package ai.ecma.lastlesson.controller;

import ai.ecma.lastlesson.entity.User;
import ai.ecma.lastlesson.payload.*;
import ai.ecma.lastlesson.security.AuthService;
import ai.ecma.lastlesson.security.CurrentUser;
import ai.ecma.lastlesson.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody ReqSignUp reqSignUp) {
        ApiResponseModel response = authService.register(reqSignUp);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ApiResponse(response.getMessage(), true));
    }





    @PostMapping("/login")
    public HttpEntity<?> login( @RequestBody ReqSignIn reqSignIn) {
        return ResponseEntity.ok(authService.getApiToken(reqSignIn.getPhoneNumber(), reqSignIn.getPassword()));
    }



    @PostMapping("/checkPhone")
    public HttpEntity<?> checkPhone(@RequestBody ResUser reqUser) {
        return ResponseEntity.ok(authService.checkPhone(reqUser.getPhoneNumber()));
    }






    @GetMapping("/me")
    public ResUser getUser(@CurrentUser User user) {
        if (user == null) return null;

        return new ResUser(user);
    }






}
