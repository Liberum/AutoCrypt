import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Test {

    public void test(Object knopochka, final String hui, final String dPach,
	    final String dsk, final Object jp1) {
	JButton myKnopochka = (JButton) knopochka;
	final JPasswordField jp = (JPasswordField) jp1;
	myKnopochka.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent event) {
		RunDisk rd = new RunDisk();
		rd.mountDisk(new String(((JPasswordField) jp1).getPassword()),
			dsk, dPach);
		jp.setText(null);

		System.out.println(hui);
	    }

	});

    }
}
