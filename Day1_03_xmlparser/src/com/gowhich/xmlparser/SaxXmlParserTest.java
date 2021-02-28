package com.gowhich.xmlparser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class SaxXmlParserTest {

	@Test
	public void saxParser() throws Exception {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new MyHandler());
		xmlReader.parse("book.xml");
	}
	
	public class MyHandler implements ContentHandler{

		@Override
		public void setDocumentLocator(Locator locator) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void startDocument() throws SAXException {
			System.out.println("文档开始");
			
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("文档结束");
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			System.out.println("开始标签<"+qName+">");
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("结束标签<"+qName+">");
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String text = new String(ch, start, length);
			System.out.println("文本内容"+text);
		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void skippedEntity(String name) throws SAXException {
			// TODO Auto-generated method stub
			
		}
		
	}
}
