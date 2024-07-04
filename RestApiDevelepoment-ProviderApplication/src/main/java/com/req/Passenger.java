package com.req;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Passenger 
{
	private String fname;
	private String lastname;
	private String form;
	private String to;
	private String trainno;
	private String doj;
	

}
