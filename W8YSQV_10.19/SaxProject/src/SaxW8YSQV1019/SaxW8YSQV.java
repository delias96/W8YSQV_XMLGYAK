package SaxW8YSQV1019;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxW8YSQV {
	
	public static void main(String[] args) {

	try {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		SaxHandler handler = new SaxHandler();
		saxParser.parse(new File("szemelyekW8YSQV.xml"), handler);
		
		
	} catch(IOException e){
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	}
	
}
}