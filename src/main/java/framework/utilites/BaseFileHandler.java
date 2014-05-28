package framework.utilites;

import org.xml.sax.InputSource;

public abstract class BaseFileHandler {
    public InputSource readXmlFile(String filePath) {
//        todo add file validation
        if (!filePath.endsWith(".xml")) {
            throw new IllegalArgumentException("need to be xml file path!");
        }
        return new InputSource(filePath);
    }
}
