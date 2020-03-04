package com.Xml.parse;

import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseClass {

	public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
		
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
		//test1(doc);
		//test2(doc);
		//test3(doc);
		//test4(doc);
		test5(doc);
	}
	
	static void test5(org.w3c.dom.Document doc) throws TransformerFactoryConfigurationError, Exception{
		//1.��ȡҪ������ԵĽڵ�
		Node stu = doc.getElementsByTagName("student").item(0);
		//2.�ѻ�ȡ�Ľڵ�ǿ��ת����element
		Element ele = (Element)stu;
		//3.��������
		ele.setAttribute("ID", "0001");
		//4.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource((org.w3c.dom.Document) doc),new StreamResult("src/com/Xml/parse/student.xml"));
	}
	
	static void test4(org.w3c.dom.Document doc) throws TransformerFactoryConfigurationError, Exception{
		//1.��ȡһ���ڵ�
		Node addressNode = doc.getElementsByTagName("address").item(0);
		//2.��ȡ�ýڵ�ĸ��ڵ㣬�Ӹ��ڵ㵱���Ƴ�
		addressNode.getParentNode().removeChild(addressNode);
		//3.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource((org.w3c.dom.Document) doc),new StreamResult("src/com/Xml/parse/student.xml"));
			
	}
	
	static void test3(org.w3c.dom.Document doc) throws TransformerFactoryConfigurationError, Exception {
		//1.����һ���ڵ�
		Element addressEle = doc.createElement("address");
		//2.����Ԫ������
		addressEle.setTextContent("��ַ1");
		//3.��ȡҪ���Ԫ�صĸ����
		Node stuNode = doc.getElementsByTagName("student").item(0);
		//4.��ӽڵ�
		stuNode.appendChild(addressEle);
		//5.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource((org.w3c.dom.Document) doc),new StreamResult("src/com/Xml/parse/student.xml"));
	}
	
	//�޸�Ԫ������
	static void test2(org.w3c.dom.Document doc) throws TransformerFactoryConfigurationError, Exception {
		//1.��ȡ����ָ���ڵ�
		NodeList agelist = ((org.w3c.dom.Document) doc).getElementsByTagName("age");
		//2.��ȡҪ�޸ĵĽڵ�
		Node ageNode = agelist.item(1);
		//3.�޸�Ԫ������
		ageNode.setTextContent("20");
		//4.���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource((org.w3c.dom.Document) doc),new StreamResult("src/com/Xml/parse/student.xml"));
			
	}
	
	static void test1(org.w3c.dom.Document doc) {
		NodeList list = ((org.w3c.dom.Document) doc).getElementsByTagName("name");
		Node name = list.item(0);
		System.out.println(name.getTextContent());
	}
}
