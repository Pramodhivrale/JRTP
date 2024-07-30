package com.bindings;

import java.io.Serializable;

import lombok.Data;

@Data
public class Binding implements Serializable{
	
	private Integer id;
	private String name;
	private String countryCode;

}
