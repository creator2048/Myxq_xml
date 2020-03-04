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
		1.创建解析器工厂
		2.通过解析器工厂得到解析器
		3.通过解析器得到document对象
		4.获取具体的节点内容
	
		 */
		
		//1.创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		//2.通过解析器工厂得到解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//3.通过解析器得到document对象
		org.w3c.dom.Document doc = db.parse("src/com/Xml/parse/student.xml");
		//System.out.println(doc);
		
		//4.获取具体的节点内容
		NodeList list = doc.getElementsByTagName("name");
		Node name = list.item(0);
		System.out.println(name.getTextContent());
		
		
	}
}
