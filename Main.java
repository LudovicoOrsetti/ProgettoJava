package mvc;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				View view = new View();
				Model model = new Model();
				// AVVIO IL CONTROLLER
				view.ListenerView();

				Controller controller = new Controller(view, model);
				view.ListenerView();
				controller.ListenerController();
			}
		});
	}
}
