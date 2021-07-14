package com.sundingyi.libmanager.model;

import java.io.Serializable;

import lombok.Data;

/**
 * book
 *
 * @author
 */
@Data
public class Book implements Serializable {
    private Long id;
    
    private String bookname;
    
    private String author;
    
    private Integer borrowed;
    
    private String borrowedTo;
    
    private static final long serialVersionUID = 1L;
}