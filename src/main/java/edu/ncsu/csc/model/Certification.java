package edu.ncsu.csc.model;

import java.util.Date;

public class Certification {
    private String acronym;
    private String name;
    private Date dateCertified;
    private Date expirationDate;

    public Certification(String acronym, String name, Date dateCertified, Date expirationDate) {
        this.acronym = acronym;
        this.name = name;
        this.dateCertified = dateCertified;
        this.expirationDate = expirationDate;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCertified() {
        return dateCertified;
    }

    public void setDateCertified(Date dateCertified) {
        this.dateCertified = dateCertified;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}