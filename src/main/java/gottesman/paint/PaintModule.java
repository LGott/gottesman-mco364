package gottesman.paint;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PaintModule implements Module {

	public void configure(Binder binder) {

		PaintProperties properties = new PaintProperties();

		binder.bind(PaintProperties.class).toInstance(properties);

		ToolButton[] buttons = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new RectangleTool(properties), "/square.png"),
				new ToolButton(new OvalTool(properties), "/circle.png"),
				new ToolButton(new PaintBucket(properties), "/bucket.png") };

		binder.bind(ToolButton[].class).toInstance(buttons);

	}

}
