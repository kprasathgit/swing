package com.mkp.hotelroombooking.query;

public class OperatorQuery {

//Done
	public String operatorView() {

		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("select opercode,opername,password,active from Operator order by opercode");

		return stringBuilder.toString();
	}

//Done	
	public String loginCheck(int operCode, String password) {

		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("select opercode,opername,password,active from Operator where opercode =");
		stringBuilder.append(operCode);
		stringBuilder.append(" and password ='");
		stringBuilder.append(password).append("'");

		return stringBuilder.toString();
	}

}