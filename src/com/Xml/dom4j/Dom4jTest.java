package com.Xml.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {
	public static void main(String[] args) throws Exception{
		
		//1.创建SAXReader
		SAXReader reader = new SAXReader();
		Document  doc = reader.read("src\\com\\Xml\\dom4j\\student.xml");
		//2.获取根元素
		Element rootElement = doc.getRootElement();
		//3.给根元素添加元素和属性，并返回添加的元素
		Element stuEle = rootElement.addElement("student").addAttribute("number", "aooo3");
		stuEle.addElement("name").setText("Annie");
		stuEle.addElement("age").setText("18");
		stuEle.addElement("sex").setText("girl");
			 
		//Pretty print the document to system.out
		OutputFormat format = OutputFormat.createPrettyPrint();
		Writer wr = new OutputStreamWriter(new FileOutputStream("src/com/Xml/dom4j/student.xml"),"UTF-8");
		XMLWriter writer = new XMLWriter(wr,format);
		writer.write(doc);
		wr.close();
		
		/*
		Writer wr = new OutputStreamWriter(new FileOutputStream("src/com/Xml/dom4j/student.xml"),"UTF-8");
		doc.write(wr);
		wr.close();
		*/
	}
	
	
	static void test1() throws Exception{
		//获取所有指定标签内容
		//1.创建SAXReader
		SAXReader reader = new SAXReader();
		Document  doc = reader.read("src\\com\\Xml\\dom4j\\student.xml");
		//2.获取根元素
		Element rootElement = doc.getRootElement();
		//3.根据名称获取根元素下所有的元素
		List<Element> stuList = rootElement.elements("student");
		//4.遍历每一个子元素
		for(Element stuEle : stuList) {
		//Element nameEle = stuEle.element("name");
		//System.out.println(nameEle.getText());
					
		String name = stuEle.elementText("name");
		String age = stuEle.elementText("age");
		String sex = stuEle.elementText("sex");
		String num = stuEle.attributeValue("number");
		System.out.println(name);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(num);
		System.out.println("---------");
		}

	}

}
