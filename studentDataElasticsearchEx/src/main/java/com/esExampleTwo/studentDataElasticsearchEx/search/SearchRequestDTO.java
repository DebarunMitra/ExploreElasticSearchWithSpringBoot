package com.esExampleTwo.studentDataElasticsearchEx.search;

import java.util.List;

public class SearchRequestDTO {

    private List<String> fields;
    private String searchTerm;
    private List<String> fieldLocation;
    private String searchLocation;
    private Integer searchLocationFrom;
    private Integer searchLocationSize;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchLocation() {
        return searchLocation;
    }

    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
    }

    public List<String> getFieldLocation() {
        return fieldLocation;
    }

    public void setFieldLocation(List<String> fieldLocation) {
        this.fieldLocation = fieldLocation;
    }

    public Integer getSearchLocationFrom() {return searchLocationFrom; }

    public void setSearchLocationFrom(Integer searchLocationFrom) {this.searchLocationFrom = searchLocationFrom; }

    public Integer getSearchLocationSize() {return searchLocationSize; }

    public void setSearchLocationSize(Integer searchLocationSize) {this.searchLocationSize = searchLocationSize; }
}
