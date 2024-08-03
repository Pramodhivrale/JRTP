package com.data;

public class DAO_IMPL implements DAO
{

	@Override
	public String findNameById(Integer id) {
		System.out.println("findNameById method called");
		return "Jhon cena";
	}

	@Override
	public String findEmailbyId(Integer id) {
		System.out.println("findEmailbyId method called");
		return "pramodgivrale4@gmail.com";
	}
	

}
