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
		//A DocumentBuilderFactoryból megkapjuk a DocumentBuildert
		//A DocumentBuilder tartalmazza az Api-t a Dom-dokumentum példányok XML-dokumentumból való
		
		Document doc = dBuilder.parse(xmlFile);
		//A parse() metódus elemzi az XML fájlt a document.
		doc.getDocumentElement().normalize();
		//A dokumentum normalizálása segít a helyess eredmények elérésében.
		System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
		//megkapjuk a gyökér elemet
		NodeList nList = doc.getElementsByTagName("user");
		for (int i = 0; i < nList.getLength(); i++) {
			//a listán for ciklussal megyünk végig
			Node nNode = nList.item(i);
			System.out.println("\n Current Element: "+ nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("id");
				//Az elem attribútumot a getAttribute() segítségévvel kapjuk meg.
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
