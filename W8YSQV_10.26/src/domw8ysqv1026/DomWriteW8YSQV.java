package domw8ysqv1026;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomWriteW8YSQV {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		Document doc = dBuilder.newDocument();
		
		Element root = doc.createElementNS("domw8ysqv","users");
		doc.appendChild(root);
		root.appendChild(createUser(doc,"1","Pal","Kiss","programmer"));
		root.appendChild(createUser(doc,"2","Piroska","Zold","Writer"));
		root.appendChild(createUser(doc,"3","Alma","Gorson","teacher"));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");
		
		DOMSource source = new DOMSource(doc);
		
		File myfile = new File("users1.xml");
		StreamResult consol = new StreamResult(System.out);
		StreamResult file = new StreamResult(myfile);
		transformer.transform(source, consol);
		transformer.transform(source, file);
	}

	private static Node createUser(Document doc, String id, String firstname, String lastname, String profession) {

		Element user = doc.createElement("user");
		user.setAttribute("id", id);
		user.appendChild(createUserElement(doc,"firstname",firstname));
		user.appendChild(createUserElement(doc,"lastname",lastname));
		user.appendChild(createUserElement(doc,"profession",profession));
		
		return user;
		
	}

	private static Node createUserElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}
