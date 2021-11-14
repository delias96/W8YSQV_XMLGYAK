package domw8ysqv1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomReadW8YSQV {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xmlFile = new File("usersw8ysqv.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		//A DocumentBuilderFactoryb�l megkapjuk a DocumentBuildert
		//A DocumentBuilder tartalmazza az Api-t a Dom-dokumentum p�ld�nyok XML-dokumentumb�l val�
		
		Document doc = dBuilder.parse(xmlFile);
		//A parse() met�dus elemzi az XML f�jlt a document.
		doc.getDocumentElement().normalize();
		//A dokumentum normaliz�l�sa seg�t a helyess eredm�nyek el�r�s�ben.
		System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
		//megkapjuk a gy�k�r elemet
		NodeList nList = doc.getElementsByTagName("user");
		for (int i = 0; i < nList.getLength(); i++) {
			//a list�n for ciklussal megy�nk v�gig
			Node nNode = nList.item(i);
			System.out.println("\n Current Element: "+ nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("id");
				//Az elem attrib�tumot a getAttribute() seg�ts�g�vvel kapjuk meg.
				Node node1 = elem.getElementsByTagName("firstname").item(0);
				String fname = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("profession").item(0);
				String profession = node3.getTextContent();
				System.out.println("User id:"+ uid );
				System.out.println("Firstname: "+fname);
				System.out.println("Lastname: "+lname);
				System.out.println("Profession: "+profession);
			}
		}
	}

}
