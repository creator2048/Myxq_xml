package com.Xml.parse;

import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseClass {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		/*
		1.��������������
		2.ͨ�������������õ�������
		3.ͨ���������õ�document����
		4.��ȡ����Ľڵ�����
	
		 */
		
		//1.��������������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		//2.ͨ�������������õ�������
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//3.ͨ���������õ�document����
		org.w3c.dom.Document doc = db.parse("src/com/Xml/parse/student.xml");
		//System.out.println(doc);
		
		//4.��ȡ����Ľڵ�����
		NodeList list = doc.getElementsByTagName("name");
		Node name = list.item(0);
		System.out.println(name.getTextContent());
		
		
	}
}
