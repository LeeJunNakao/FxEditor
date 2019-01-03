// Copyright © 2016-2019 Andy Goryachev <andy@goryachev.com>
package demo.fx.pages;
import goryachev.fx.CPane;
import goryachev.fx.FX;
import goryachev.fx.FxButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;


/**
 * This pane demonstrates the CPane functionality.
 */
public class DemoLoginPane
	extends CPane
{
	public final TextFlow infoField;
	public final TextField userNameField;
	private final PasswordField passwordField;
	public final FxButton loginButton;
	
	
	public DemoLoginPane()
	{
		String info = "This demonstrates table layout capabilities of CPane component.  CPane is easier to use than GridPane because one does not have to set so many constraints on the inidividual nodes, and you also have border layout capability as well.";

		infoField = new TextFlow(new Text(info));

		userNameField = new TextField();

		passwordField = new PasswordField();

		loginButton = new FxButton("Login");
		loginButton.setMinWidth(100);

		setGaps(10, 7);
		setPadding(10);
		addColumns
		(
			10,
			CPane.PREF,
			CPane.FILL,
			CPane.PREF,
			10
		);
		addRows
		(
			10,
			CPane.PREF,
			CPane.PREF,
			CPane.PREF,
			CPane.PREF,
			CPane.FILL,
			10
		);
		int r = 1;
		add(1, r, 3, 1, infoField); 
		r++;
		add(1, r, FX.label("User name:", TextAlignment.RIGHT));
		add(2, r, 2, 1, userNameField);
		r++;
		add(1, r, FX.label("Password:", TextAlignment.RIGHT));
		add(2, r, 2, 1, passwordField);
		r++;
		add(3, r, loginButton);
	}
}
