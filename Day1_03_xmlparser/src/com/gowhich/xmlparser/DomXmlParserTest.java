package com.gowhich.xmlparser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
	
	public void domXmlModifyParser() {
		
	}
}
