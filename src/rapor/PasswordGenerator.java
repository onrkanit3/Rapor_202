// Onur Kanıt 170503026
package rapor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author izmir
 */
public class PasswordGenerator {
    public static String getSHA512Password (String passwordToEncrypt,byte[] s) throws NoSuchAlgorithmException{
        String generatedPassword = null;
        try
        {
            
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(s);
                byte[] bytes = md.digest(passwordToEncrypt.getBytes());

                StringBuilder sb = new StringBuilder();

                for(int i=0; i < bytes.length; i++)
                { //Convert back
                   sb.append(Integer.toString((bytes[i] & 0xff)+ 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString(); 
            }
            
        
        catch (NoSuchAlgorithmException e)
        {
            System.err.println(e.getMessage());
            
        }
        
        return generatedPassword;
            
    }
    
    public static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte [] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
}
