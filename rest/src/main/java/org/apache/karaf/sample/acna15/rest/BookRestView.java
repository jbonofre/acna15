package org.apache.karaf.sample.acna15.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class BookRestView {

    @XmlElement(name = "id")
    public Long id;

    @XmlElement(name = "title")
    public String title;

    @XmlElement(name = "isbn")
    public String isbn;

}
