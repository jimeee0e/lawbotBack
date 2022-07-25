package bit.project.lawbot.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

@Component
public class JwtTokenProvider {
    public Claims parseJwtToken(String authorizationHeader){
        validationAuthorizationHeader(authorizationHeader);
        String token = extractToken(authorizationHeader);

        return Jwts.parser()
                .setSigningKey("ewfewfewfewfwefhewjnfhkjewhnfjkewhnfjkewhnfkjwehfkjewhfjkwehfkjhwejkfefwefewfwef")
                .parseClaimsJws(token)
                .getBody();
    }

    private void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException();
        }
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring("Bearer ".length());
    }

    public String makeJwtToken(){
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setIssuer("fresh") // (2)
                .setIssuedAt(now) // (3)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // (4)
                .claim("id", "아이디") // (5)
                .claim("email", "ajufresh@gmail.com")
                .claim("role", "USER")
                .signWith(SignatureAlgorithm.HS256, "ewfewfewfewfwefhewjnfhkjewhnfjkewhnfjkewhnfkjwehfkjewhfjkwehfkjhwejkfefwefewfwef") // (6)
                .compact();
    }
}
