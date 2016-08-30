package com.brunosimioni.gateway;

import lombok.Data;

@Data
public class ProductDTO {
    public Integer id;
    public String name;
    public String category;
    
    public ProductDTO(Integer id, String name, String category) {
    	this.id = id;
    	this.name = name;
    	this.category = category;
    }
}
