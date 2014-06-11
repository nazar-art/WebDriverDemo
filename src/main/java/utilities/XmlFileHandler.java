package utilities;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XmlFileHandler {

    private static Logger log = Logger.getLogger(XmlFileHandler.class);

    public String readXmlNode(InputSource source, String xpathNode) {
        String result = "";
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            result = xPath.evaluate(xpathNode, source);
        } catch (XPathExpressionException e) {
            log.error("Unable to read xml node. Details - ", e);
        }
        return result;
    }

/*    public static void main(String[] args) {
        XmlFileHandler handler = new XmlFileHandler();
        String result = handler.readXmlNode(new InputSource("src/main/resources/webAutomationConfig.xml"), "config");
        System.out.println("Here is result: " + result);
    }*/
}
