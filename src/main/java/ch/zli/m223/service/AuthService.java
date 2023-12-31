package ch.zli.m223.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Credential;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    @Inject
    UserService userService;

    public Response authenticate(Credential credential) {
        Optional<ApplicationUser> principal = userService.findByEmail(credential.getEmail());

        try {
            if (principal.isPresent() && principal.get().getPassword().equals(credential.getPassword())) {
                Instant expiration = Instant.now().plus(Duration.ofHours(24));
                String token = Jwt
                    .issuer("https://zli.example.com/")
                    .upn(credential.getEmail())
                    .groups(new HashSet<>(Arrays.asList("member", "admin")))
                    .expiresAt(expiration)
                    .sign();
                return Response
                    .ok(principal.get())
                    .cookie(new NewCookie("coworkingspace", token))
                    .header("Authorization", "Bearer " + token)
                    .build();
            } else {
                return Response.status(400, "Daten ungültig").build();
            }
        } catch (Exception e) {
            System.err.println("Signature exception");
            return Response.status(400, "Es ist ein Problem aufgetreten").build();
        }
    }
}
