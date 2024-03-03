package lk.jwt.security.auth;

import lk.jwt.security.config.JWTService;
import lk.jwt.security.user.Role;
import lk.jwt.security.user.User;
import lk.jwt.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Gathsara
 * created : 2/29/2024 -- 9:10 PM
 **/

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .passWord(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        repository.save(user);
        return  null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return  null;
    }
}

