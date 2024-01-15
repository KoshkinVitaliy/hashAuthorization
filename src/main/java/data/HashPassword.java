package data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashPassword {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Создаем объект MessageDigest с использованием алгоритма SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Преобразуем пароль в байтовый массив и вычисляем хэш-значение
        byte[] hash = md.digest(password.getBytes());

        // Кодируем хэш-значение в Base64
        String encodedHash = Base64.getEncoder().encodeToString(hash);

        return encodedHash;
    }
}
