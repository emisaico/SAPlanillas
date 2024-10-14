package pe.com.utp.service.support.have.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HaveUtil {

    public static String validStringNullOrEmpty(String string) {

        return (Objects.isNull(string) || string.isEmpty()) ? null : string;

    }

    public static Map<String, Object> validToken(String authorization) {

        String token = authorization.replaceFirst(Constantes.BASIC, Constantes.TEXTO_VACIO);
        Map<String, Object> response = new HashMap<>();

        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(Constantes.SECRET_KEY.getBytes()))  // Convertir clave a Base64
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println(claims);
            response.put("id", claims.getId());
            response.put("user_name", claims.get("user_name", String.class));
            response.put("rol", claims.get("descripcion rol", String.class));
            response.put("fecha y hora", claims.get("fecha y hora", String.class));
            response.put("expiration", claims.getExpiration());
            response.put("estado", true);

        } catch (Exception e) {
            response.put("mensaje", "Token no válido o clave incorrecta");
            response.put("estado", false);
        }

        return response;
    }

    public static Date convertStringToDate(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Manejo de errores
        }
    }

}
