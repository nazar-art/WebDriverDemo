package framework.utilites;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class XmlFileHandler extends BaseFileHandler {
    private static Logger log = Logger.getLogger(XmlFileHandler.class);

    public String readXmlNode(InputSource source, String xpathNode) {
        String result = "";
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            result = xPath.evaluate(xpathNode, source);
        } catch (XPathExpressionException e) {
            log.error("Unable to read xml node. Details -", e);
//            System.out.println("Unable to read xml node. Details -" + e.getCause());
        }
        return result;
    }
}
