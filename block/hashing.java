import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main{
    public static String generateHash(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = md.digest(data.getBytes());

        StringBuilder hexString = new StringBuilder();
        for(byte b: hashBytes){
            String hex = Integer.toHexString(0xff & b);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to hash: ");
        String input = scanner.nextLine();
        try {
            String hash = generateHash(input);
            System.out.println("SHA-256 Hash: "+hash);
        } catch (Exception e) {
            System.out.println("Algorithim not found");
        }
    }
}