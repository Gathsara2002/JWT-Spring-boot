package lk.jwt.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

/**
 * @author : Gathsara
 * created : 2/28/2024 -- 8:22 PM
 **/

@Service
public class JWTService {

    private static final String secretKey = "4b81fc1b95cefe3823ba8bde7dbc4d5f20f9f0051255278c2b289e1abec9c22a6e48a753";

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSigningKey() {
        byte[] kBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(kBytes);
    }
}
