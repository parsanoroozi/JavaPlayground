package volumeII;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlSample {
    /**
     * To process an XML document, you need to parse it. A parser is a program that
     * reads a file, confirms that the file has the correct format, breaks it up into the
     * constituent elements, and lets a programmer access those elements. The Java
     * library supplies two kinds of XML parsers:
     * • Tree parsers, such as the Document Object Model (DOM) parser, that read
     * an XML document into a tree structure.
     * • Streaming parsers, such as the Simple API for XML (SAX) parser, that generate
     * events as they read an XML document.
     * */

    /**
     * To read an XML document, you need a DocumentBuilder object that you get from a
     * DocumentBuilderFactory like this:
     * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     * DocumentBuilder builder = factory.newDocumentBuilder();
     * */
    public static void main() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File f = new File("xmlSample.xml");
        Document doc = builder.parse(f);
        /**
         *Alternatively, you can use a URL:
         * URL u = . . .
         * Document doc = builder.parse(u);
         * You can even specify an arbitrary input stream:
         * InputStream in = . . .
         * Document doc = builder.parse(in);
         *
         * • Document parse(File f)
         * • Document parse(String url)
         * • Document parse(InputStream in)
         * parses an XML document from the given file, URL, or input stream and returns the
         * parsed document
         * */
        System.out.println(doc);
        Element root = doc.getDocumentElement();
        System.out.println(root.getTagName());
        NodeList nodes = root.getChildNodes();
        System.out.println(nodes.getLength());
        for(int i = 0; i< nodes.getLength(); i++){
            Node child = nodes.item(i);
            if(child instanceof Element){
                Element childElement = (Element) child;
                NodeList innerNodes = childElement.getChildNodes();
                for(int j = 0; j< innerNodes.getLength(); j++){
                    Node innerChild = innerNodes.item(j);
                    if(innerChild instanceof Element){
                        Element innerChildElement = (Element) innerChild;
                        System.out.println(innerChildElement.getFirstChild().getTextContent());
                    }
                }
            }
        }
        /**
         * You can also get the last child with the getLastChild method, and the next sibling of
         * a node with getNextSibling. Therefore, another way of traversing a node’s children is
         * for (Node childNode = element.getFirstChild();
         *  childNode != null;
         *  childNode = childNode.getNextSibling())
         * {
         *  . . .
         * }*/

        /**
         *  you can define a structure as a standard structure for xml files and validate
         *  them with that pattern. => 1) DTD(Document Type Definitions) 2) XML Schema
         *
         *
         *
         * */


    }
}
