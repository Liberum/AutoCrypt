import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Encryptor {

    public void cpt() {
	FileOutputStream fos = null;
	String secret = "Тестовая секретная информация";

	String password = "123";
	String dsk = "o";
	String dPath = "d:\\myCrypt";

	MountAdapter ma = new MountAdapter();
	List<String> path = ma.path(password, dsk, dPath);

	try {
	    String keyfile = "c:\\AutoCrypt\\key.key";
	    String algorithm = "DESede";

	    KeyGenerator kg = KeyGenerator.getInstance(algorithm);
	    SecretKey key = kg.generateKey();

	    Cipher cipher = Cipher.getInstance(algorithm);
	    cipher.init(Cipher.ENCRYPT_MODE, key);

	    ObjectOutputStream oos = new ObjectOutputStream(
		    new CipherOutputStream(new FileOutputStream(
			    "c:\\AutoCrypt\\11.txt"), cipher));
	    oos.writeObject(path);

	    fos = new FileOutputStream(keyfile);
	    SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
	    DESedeKeySpec keyspec = (DESedeKeySpec) skf.getKeySpec(key,
		    DESedeKeySpec.class);
	    fos.write(keyspec.getKey());
	    fos.close();
	    oos.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
