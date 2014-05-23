package framework.seleniumEngine;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-21.
 */
public class UIMapping {

    private SearchLevelType searchLevelType;
    private SearchType searchType;
    private String locator;
    private Class controlType;

    public UIMapping(SearchLevelType searchLevelType, SearchType searchType, String locator, Class controlType) {
        this.searchLevelType = searchLevelType;
        this.searchType = searchType;
        this.locator = locator;
        this.controlType = controlType;
    }

    public SearchLevelType getSearchLevelType() {
        return searchLevelType;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public String getLocator() {
        return locator;
    }

    public Class getControlType() {
        return controlType;
    }
}
