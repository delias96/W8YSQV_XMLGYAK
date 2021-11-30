package hu.domparse.w8ysqv;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryW8YSQV {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// Létrehozás
		File xmlFile = new File("XMLW8YSQV.xml");
		// Builder + konvertálás
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		// Normalizálás
		doc.getDocumentElement().normalize();
		// Gyökérelem kiírása
		System.out.println("Gyökérelem: " + doc.getDocumentElement().getNodeName());
		// rendeles elemek nList-be illesztése
		NodeList nList = doc.getElementsByTagName("rendeles");
		System.out.println("--------------------------------------------------------");
		// Kiírás ciklusa; nList/nNode-on végighaladva az elkészített algoritmusokkal
		// kiírja a kért adatokat
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String id = elem.getAttribute("id");
				// Adatok átadása a node-okba
				Node node1 = elem.getElementsByTagName("termekek").item(0);
				String termekek = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("teljesAr").item(0);
				String teljesAr = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("idopont").item(0);
				String idopont = node3.getTextContent();
				//Az adott query feltétele
				if(termekek.equals("Fogkefe")) {
				// Kiírás
				System.out.println("Rendeles ID: " + id);
				System.out.println("Termék: " + termekek);
				System.out.println("Teljes Ár: " + teljesAr);
				System.out.println("Rendelés időpontja: " + idopont);
				// Metódus hívások
				System.out.println(termekek + " Gyártója:\n");
				listUgyfel(doc, id);
				System.out.println(termekek + " Raktár adatai:\n");
				listRaktar(doc, id);
				System.out.println(termekek + " Vásárló adatai:\n");
				listVasarlo(doc, id);
				System.out.println("\n");
				}
			}
		}
	}

	// Ügyfél adatainak kiírása az elõzõ módszer alapján
	public static void listUgyfel(Document doc, String Rid) {
		NodeList nList = doc.getElementsByTagName("ugyfel");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				if (elem.getAttribute("rid").toString().equals(Rid)) {
					String id = elem.getAttribute("id");
					Node node1 = elem.getElementsByTagName("nev").item(0);
					String nev = node1.getTextContent();
					Node node2 = elem.getElementsByTagName("adoAzonosito").item(0);
					String adoAzonosito = node2.getTextContent();
					Node node3 = elem.getElementsByTagName("cim").item(0);
					String cim = node3.getTextContent();
					System.out.println("Ügyfél id: " + id);
					System.out.println("Ügyfél neve: " + nev);
					System.out.println("Ügyfél adó azonosítója: " + adoAzonosito);
					System.out.println("Ügyfél adó cime: " + cim + "\n");
				}
			}
		}
	}

	// Raktár adatainak kiírása az elõzõ módszer alapján
	public static void listRaktar(Document doc, String Rid) {
		NodeList nList = doc.getElementsByTagName("raktar");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				if (elem.getAttribute("rid").toString().equals(Rid)) {
					String id = elem.getAttribute("id");
					Node node1 = elem.getElementsByTagName("mennyiseg").item(0);
					String mennyiseg = node1.getTextContent();
					Node node2 = elem.getElementsByTagName("termekek").item(0);
					String termekek = node2.getTextContent();
					Node node3 = elem.getElementsByTagName("ugyfelAzonosito").item(0);
					String ugyfelAzonosito = node3.getTextContent();
					System.out.println("Raktár id: " + id);
					System.out.println("Termék mennyiség: " + mennyiseg);
					System.out.println("Termék neve: " + termekek);
					System.out.println("Ügyfél azonosítója: " + ugyfelAzonosito + "\n");
				}
			}
		}
	}

	// Vásárló adatainak kiírása az elõzõ módszer alapján
	public static void listVasarlo(Document doc, String Rid) {
		NodeList nList = doc.getElementsByTagName("vasarlo");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				if (elem.getAttribute("rid").toString().equals(Rid)) {
					String id = elem.getAttribute("id");
					Node node1 = elem.getElementsByTagName("nev").item(0);
					String nev = node1.getTextContent();
					Node node2 = elem.getElementsByTagName("telefonszam").item(0);
					String telefonszam = node2.getTextContent();
					Node node3 = elem.getElementsByTagName("cim").item(0);
					String cim = node3.getTextContent();
					System.out.println("Vasarló ID: " + id);
					System.out.println("Vásárló neve: " + nev);
					System.out.println("Vásárló telefonszáma: " + telefonszam);
					System.out.println("Vásárló cime: " + telefonszam + "\n");
				}
			}
		}
	}

}
