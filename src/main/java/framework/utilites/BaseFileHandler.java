package framework.utilites;

import org.xml.sax.InputSource;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public abstract class BaseFileHandler {
    public InputSource readXmlFile(String filePath) {
//        todo add file validation
        return new InputSource(filePath);
    }
}
