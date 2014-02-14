import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Decryptor {

    public void decpt() {
	FileInputStream fis = null;
	try {
	    String keyfile = "c:\\AutoCrypt\\key.key";
	    String algorithm = "DESede";

	    fis = new FileInputStream(keyfile);
	    byte[] keyspecbytes = new byte[fis.available()];
	    fis.read(keyspecbytes);
	    SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
	    DESedeKeySpec keyspec = new DESedeKeySpec(keyspecbytes);
	    SecretKey key = skf.generateSecret(keyspec);
	    Cipher cipher = Cipher.getInstance(algorithm);
	    cipher.init(Cipher.DECRYPT_MODE, key);
	    ObjectInputStream ois = new ObjectInputStream(
		    new CipherInputStream(new FileInputStream(
			    "c:\\AutoCrypt\\11.txt"), cipher));
	    // String secret = (String) ois.readObject();

	    List<String> secret1 = (List<String>) ois.readObject();

	    StringBuilder sb = new StringBuilder();
	    String[] array = (String[]) secret1.toArray();
	    for (int i = 0; i < array.length; i++) {
		sb.append(array[i] + " ");
	    }
	    String secret2 = sb.toString();

	    System.out.println(secret2);
	    fis.close();
	    ois.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
