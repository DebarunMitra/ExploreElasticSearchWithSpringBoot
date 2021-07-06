package com.esExampleTwo.studentDataElasticsearchEx.model;

import com.esExampleTwo.studentDataElasticsearchEx.helper.Indices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Document(indexName = Indices.INTERNSHIP_INDEX)
@Setting(settingPath = "static/es-settings.json")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HelloInterns {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String company;

    @Field(type = FieldType.Text)
    private String location;

    @Field(type = FieldType.Text)
    private String city;

    @Field(type = FieldType.Text)
    private String country;

    @Lob
    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String apply_url;

    @Field(type = FieldType.Text)
    private String start_date;

    @Field(type = FieldType.Text)
    private String no_of_openings;

    @Field(type = FieldType.Text)
    private String duration;

    @Field(type = FieldType.Text)
    private String expcode;

    @Field(type = FieldType.Text)
    private String jobtype;

    @Field(type = FieldType.Text)
    private String salary;

    @Field(type = FieldType.Text)
    private String skills;

    @Field(type = FieldType.Text)
    private String expiry_date;

    @Field(type = FieldType.Text)
    private String host;

    @Field(type = FieldType.Text)
    private String path;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Field(type = FieldType.Text)
    private String message;

    @Field(name = "@timestamp", type = FieldType.Date)
    private Date timestamp;

    @Field(name = "@version", type = FieldType.Text)
    private String version;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApply_url() {
        return apply_url;
    }

    public void setApply_url(String apply_url) {
        this.apply_url = apply_url;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getNo_of_openings() {
        return no_of_openings;
    }

    public void setNo_of_openings(String no_of_openings) {
        this.no_of_openings = no_of_openings;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getExpcode() {
        return expcode;
    }

    public void setExpcode(String expcode) {
        this.expcode = expcode;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
