// Copyright © 2016-2019 Andy Goryachev <andy@goryachev.com>
package demo.fx.pages.edit;
import goryachev.common.util.CList;
import goryachev.fx.edit.AbstractPlainTextEditorModel;
import goryachev.fx.edit.Edit;
import goryachev.fx.edit.LineBox;
import java.text.NumberFormat;
import demo.edit.Segment;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 * test plain text model with up to 2 billion rows
 */
public class TestFxColorEditorModel_OLD
	extends AbstractPlainTextEditorModel
{
	private NumberFormat format = NumberFormat.getInstance();
	private int lineCount;
	
	
	public TestFxColorEditorModel_OLD(int lineCount)
	{
		this.lineCount = lineCount;
	}
	
	
	public LineBox getLineBox(int line)
	{
		CList<Segment> ss = getSegments(line, true);
		
		LineBox box = new LineBox();
		for(Segment s: ss)
		{
			Text t = new Text(s.text);
			t.setFill(s.color);
			
			box.addText(t);
		}
		return box;
	}
	

	public LoadInfo getLoadInfo()
	{
		return null; 
	}


	public int getLineCount()
	{
		return lineCount;
	}


	protected CList<Segment> getSegments(int line, boolean styles)
	{
		String s = String.valueOf(line);
		int sz = s.length();
		
		CList<Segment> ss = new CList<>();
		
		ss.add(new Segment(Color.LIGHTGRAY, "Line " + format.format(line) + ": "));
		
		for(int i=0; i<sz; i++)
		{
			char c = s.charAt(i);
			String w = toWord(c);
			
			ss.add(new Segment(styles ? toColor(c) : null, w));
		}
		
		if(line % 5 == 0)
		{
			ss.add(new Segment(Color.BLACK, " The second law of thermodynamics states that the total entropy of an isolated system can only increase over time. It can remain constant in ideal cases where the system is in a steady state (equilibrium) or undergoing a reversible process. The increase in entropy accounts for the irreversibility of natural processes, and the asymmetry between future and past."));
		}
		
		if(line % 7 == 0)
		{
			ss.add(new Segment(Color.BLACK, " 熱力学第二برگشت‌ناپذیر法則（ねつりきがくだいにほうそく、英: second law of thermodynamics）は、エネルギーのبرگشت‌ناپذیر 移動の方向とエネルギーの質に関する法則である。"));
		}
		
		if(line % 13 == 0)
		{
			ss.add(new Segment(Color.BLACK, " Второе начало термодинамики (второй закон термодинамики) устанавливает существование энтропии[1] как функции состояния термодинамической системы и вводит понятие абсолютной термодинамической температуры, то есть «второе начало представляет собой закон об энтропии» и её свойствах[4]. В изолированной системе энтропия остаётся либо неизменной, либо возрастает (в неравновесных процессах), достигая максимума при достижении термодинамического равновесия (закон возрастания энтропии). Встречающиеся в литературе различные формулировки второго начала термодинамики представляют собой собой частные выражения общего закона возрастания энтропии."));
		}
		
		if(line % 17 == 0)
		{
			// FIX selection shape is incorrect if mixing LTR and RTL languages
			ss.add(new Segment(Color.BLACK, "قانون دوم ترمودینامیک بیان می‌کند که در یک پروسهٔ طبیعی ترمودینامیکی جمع انتروپی تک‌افتادهٔ سیستم‌های شرکت کننده در آن پروسه، همواره با گذشت زمان افزایش می‌یابد، (تنها اگر در شرایط ایده‌آل حالت دایمی، یا تحت فرایند برگشت‌پذیری قرار داشته‌باشد، ثابت می‌ماند). به بیان دیگر هیچ پروسهٔ ترمودینامیکی وجود ندارد که با گذشت زمان با افزایش انتروپی همراه نباشد. این افزایش آنتروپی برابر است با افزایش اتلاف انرژی، (و سازگار با فرایند برگشت‌ناپذیر و اصل نابرابری گذشته و آینده)."));
		}
		
		if(line % 31 == 0)
		{
			ss.add(new Segment(Color.BLACK, "ऊष्मागतिकी का द्वितीय सिद्धान्त प्राकृतिक प्रक्रमों के अनुत्क्रमणीयता को प्रतिपादित करता है। यह कई प्रकार से कहा जा सकता है। आचार्यों ने इस नियम के अनेक रूप दिए हैं जो मूलत: एक ही हैं। यह ऊष्मागतिक निकायों में 'एण्ट्रोपी' (Entropy) नामक भौतिक राशि के अस्तित्व को इंगित करता है। ऐसे उष्मिक इंजन का निर्माण करना संभव नहीं जो पूरे चक्र में काम करते हुए केवल एक ही पिंड से उष्मा ग्रहण करे और काम करनेवाले निकाय में बिना परिवर्तन लाए उस संपूर्ण उष्मा को काम में बदल दे (प्लांक-केल्विन)। बिना बाहरी सहायता के कोई भी स्वत: काम करनेवाली मशीन उष्मा को निम्नतापीय पिंड से उच्चतापीय में नहीं ले जा सकती, अर्थात् उष्मा ठंडे पिंड से गरम में स्वत: नहीं जा सकती (क्लाज़िउस)। "));
		}
		
		return ss;
	}
	
	
	protected String toWord(char c)
	{
		switch(c)
		{
		case '0': return "zero ";
		case '1': return "one ";
		case '2': return "two ";
		case '3': return "three ";
		case '4': return "four ";
		case '5': return "five ";
		case '6': return "six ";
		case '7': return "seven ";
		case '8': return "eight ";
		case '9': return "nine ";
		default: return String.valueOf(c);
		}
	}
	
	
	protected Color toColor(char c)
	{
		switch(c)
		{
		case '0': return c(0);
		case '1': return c(1);
		case '2': return c(2);
		case '3': return c(3);
		case '4': return c(4);
		case '5': return c(5);
		case '6': return c(6);
		case '7': return c(7);
		case '8': return c(8);
		case '9': return c(9);
		default: return null;
		}
	}
	
	
	protected Color c(int angle)
	{
		return Color.hsb(36.0 * angle + 1, 1.0, 0.7);
	}
	
	
	public Edit edit(Edit ed) throws Exception
	{
		throw new Exception();
	}
}
