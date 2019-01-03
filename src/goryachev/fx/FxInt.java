// Copyright © 2018-2019 Andy Goryachev <andy@goryachev.com>
package goryachev.fx;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * Alias for SimpleIntegerProperty.
 */
public class FxInt
	extends SimpleIntegerProperty
{
	public FxInt(int initialValue)
	{
		super(initialValue);
	}
	
	
	public FxInt()
	{
	}
}
