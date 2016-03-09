package gottesman.paint;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private Tool tool;

	public ToolButton(Tool tool, String icon) {

		setBackground(Color.WHITE);
		this.tool = tool;

		this.setIcon(new ImageIcon(getClass().getResource(icon)));

	}

	public Tool getTool() {
		return tool;
	}
}
