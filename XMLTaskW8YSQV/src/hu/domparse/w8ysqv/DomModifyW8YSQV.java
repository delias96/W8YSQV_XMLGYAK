package hu.domparse.w8ysqv;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyW8YSQV {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		File xmlFile = new File("XMLW8YSQV.xml");
        File xmlFileMODIFIED = new File("XMLW8YSQVMODIFIED.xml");
        //Scanner nyitása a  beolvasáshoz
        Scanner sc = new Scanner(System.in);
        //Builder + konvertálás
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        //Normalizálás
        doc.getDocumentElement().normalize();
        //A rendeles elemek kiválasztása.
        NodeList nList = doc.getElementsByTagName("rendeles");
        //ciklus a változtatásokhoz
        for (int i = 0; i < nList.getLength(); i++) { 
            Node nNode = nList.item(i);
            Element elem = (Element) nNode;
            //Termék bekérése
            Node node1 = elem.getElementsByTagName("termekek").item(0);
            String nev = node1.getTextContent();
            //Átadás a node-nak
            System.out.println("A jelenlegi termék neve:" + nev + "\n");
            System.out.println("Add meg az új termék nevét: \n");
            //Bekérés billentyûzeten
            String modifiedname = sc.next();
            //Beállítás node-on keresztül
            node1.setTextContent(modifiedname);
        }
        //Scanner zárása
        sc.close();
        //transformer és domsource használatával változtatjuk a fájlt
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        //A változtatás a result-ba került
        StreamResult result = new StreamResult(xmlFileMODIFIED);
        //Beírásra kerül a módosított fájlba a módosítás
        transformer.transform(source, result);

	}

}
