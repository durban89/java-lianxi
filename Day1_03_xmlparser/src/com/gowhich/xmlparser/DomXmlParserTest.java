package com.gowhich.xmlparser;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXmlParserTest {
	
	@Test
	public void domXmlParser() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("book.xml");
		NodeList nodeList = document.getElementsByTagName("书名");
		Node node = nodeList.item(1);
		String content = node.getTextContent();
		System.out.println(content);
	}
	
	@Test
	public void domXmlModifyParser() throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("book.xml");
		NodeList nodeList = document.getElementsByTagName("书名");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			String content = node.getTextContent();
			System.out.println(content);
		}
		
		Node node = nodeList.item(1);
		node.setTextContent("书名2-改1");
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source xmlSource = new DOMSource(document);
		Result outputTarget = new StreamResult("book.xml");
		transformer.transform(xmlSource , outputTarget);
		
	}
}
