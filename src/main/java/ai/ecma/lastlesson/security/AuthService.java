package ai.ecma.lastlesson.security;

import ai.ecma.lastlesson.entity.User;
import ai.ecma.lastlesson.entity.enums.RoleName;
import ai.ecma.lastlesson.exception.ResourceNotFoundException;
import ai.ecma.lastlesson.exception.UserNotFoundException;
import ai.ecma.lastlesson.payload.ApiResponse;
import ai.ecma.lastlesson.payload.ApiResponseModel;
import ai.ecma.lastlesson.payload.JwtResponse;
import ai.ecma.lastlesson.payload.ReqSignUp;
import ai.ecma.lastlesson.repository.RoleRepository;
import ai.ecma.lastlesson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MessageSource messageSource;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phoneNumber)
            throws UsernameNotFoundException {
        User user;

        Optional<User> userOptionalPhoneNumber = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptionalPhoneNumber.isPresent()) {
            user = userOptionalPhoneNumber.get();
        } else {
            throw new UserNotFoundException("user topilmadi");
        }


        return user;
    }

    public User loadUserByUsernameForFeign(String email)
            throws UsernameNotFoundException {
        User user;

        Optional<User> userOptionalPhoneNumber = userRepository.findByPhoneNumber(email);
        if (userOptionalPhoneNumber.isPresent()) {
            user = userOptionalPhoneNumber.get();
        } else {
            throw new UserNotFoundException("user topilmadi");
        }


        return user;
    }

    @Transactional
    public UserDetails loadUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return user;
    }

    public ApiResponseModel register(ReqSignUp reqSignUp) {


//        Optional<User> checkUserName = userRepository.findByUserName(reqSignUp.getUserName());
        Optional<User> checkPhone = userRepository.findByPhoneNumber(reqSignUp.getPhoneNumber());
//        Optional<User> checkEmail = userRepository.findByEmail(reqSignUp.getEmail());
        if (checkPhone.isPresent() && checkPhone.get().getPhoneNumber() != null) {
            return new ApiResponseModel(false, "Bunday raqam tizimda mavjud!");
        } else {
            User user = new User(

                    reqSignUp.getPhoneNumber(),
                    passwordEncoder.encode(reqSignUp.getPassword()),
                    roleRepository.findAllByName(RoleName.ROLE_USER),
                    reqSignUp.getFullName()
            );


            userRepository.save(user);
            return new ApiResponseModel(true, "Muvaffaqiyatli ro'yxatdan o'tdingiz!");
        }
    }


    public ApiResponse checkPhone(String phoneNumber) {
//        Optional<User> checkUserName = userRepository.findByUserName(reqSignUp.getUserName());
        Optional<User> checkPhone = userRepository.findByPhoneNumber(phoneNumber);

        if (checkPhone.isPresent() && checkPhone.get().getPhoneNumber() != null) {
            return new ApiResponse("Bunday raqam tizimda mavjud!", false);
        }
        return new ApiResponse("Bunday raqam tizimda mavjud emas!", true);
    }

    public HttpEntity<?> getApiToken(String userName, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }


}
