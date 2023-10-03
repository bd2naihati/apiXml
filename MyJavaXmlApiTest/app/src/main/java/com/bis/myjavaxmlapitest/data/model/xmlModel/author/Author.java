package com.bis.myjavaxmlapitest.data.model.xmlModel.author;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "author")
public class Author {

    @Attribute(name="isbn")
    public Integer isbn;

    @Attribute(name="name")
    public String name;
    @Element(name = "title")
    public String title;

    @ElementList(name="books" ,required = false)
    public List<Book> bookList;
}


