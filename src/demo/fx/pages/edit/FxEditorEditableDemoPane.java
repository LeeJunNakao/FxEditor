// Copyright © 2017-2019 Andy Goryachev <andy@goryachev.com>
package demo.fx.pages.edit;
import goryachev.fx.CPane;
import goryachev.fx.CssStyle;
import goryachev.fx.FX;
import goryachev.fx.FxCtl;
import goryachev.fx.edit.EditablePlainTextEditorModel;
import goryachev.fx.edit.FxEditor;
import javafx.geometry.Insets;
import javafx.scene.control.Label;


/**
 * Editable FxEditor Demo Pane.
 */
public class FxEditorEditableDemoPane
	extends CPane
{
	public static CssStyle EDITOR = new CssStyle("FxEditorEditableDemoPane_EDITOR");

	
	public FxEditorEditableDemoPane()
	{
		FX.style(this, EDITOR);
		
		FxEditor edit = new FxEditor(new EditablePlainTextEditorModel());
		edit.setContentPadding(new Insets(2, 5, 2, 5));
		edit.setMultipleSelectionEnabled(true);
		
		setTop(label("Editable Plain Text Model"));
		setCenter(edit);
	}
	
	
	protected Label label(String text)
	{
		return FX.label(text, FxCtl.BOLD, new Insets(2, 7, 2, 7));
	}
}
