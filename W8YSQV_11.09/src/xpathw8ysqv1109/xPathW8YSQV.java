package xpathw8ysqv1109;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xPathW8YSQV {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory documFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("studentW8YSQV.xml");
			document.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "class";
			String expression1 = "class/student";
			String expression2 = "//student[@id=1]";
			String expression3 = "//student";
			String expression4 = "class/student[2]";
			String expression5 = "class/student[last()]";
			String expression6 = "class/student[last()-1]";
			String expression7 = "class/student[position()<3]";
			String expression8 = "class/*";
			String expression9 = "class/student[@*]";
			String expression10 = "//*";
			String expression11 = "class/student[kor>20]";
			String expression12 = "class/student/keresztnev | class/student/vezeteknev";
			NodeList nodeList = (NodeList) xPath.compile(expression12).evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("\n Aktuális elem: " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID:" + element.getAttribute("id"));
					System.out.println("Hallgató keresztneve:"
							+ element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Hallgató vezetekneve:"
							+ element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println(
							"Hallgató beceneve:" + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Hallgató kora:" + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathException e) {
			e.printStackTrace();
		}

	}

}
