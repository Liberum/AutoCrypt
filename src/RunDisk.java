import java.io.IOException;
import java.util.List;

public class RunDisk {

    public void mountDisk(String password, String dsk, String dPath) {
	MountAdapter ma = new MountAdapter();
	List<String> path = ma.path(password, dsk, dPath);
	ProcessBuilder b = new ProcessBuilder(path);
	try {
	    b.start();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    // запуск диска с передачей параметров
    public void mountDskCpt(List<String> mount) {
	// TODO попа
	ProcessBuilder b = new ProcessBuilder(mount);
	try {
	    b.start();
	} catch (IOException e) {
	    // TODO 4len vsynyt v peremennyiy
	    e.printStackTrace();
	}
    }

    public void UnMount(String nDisk) {
	List<String> params = java.util.Arrays.asList(
		"C:\\Program Files\\TrueCrypt\\truecrypt.exe", "/d", nDisk,
		"/q");
	ProcessBuilder b = new ProcessBuilder(params);
	try {
	    b.start();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
