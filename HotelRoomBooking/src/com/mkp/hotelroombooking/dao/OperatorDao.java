package com.mkp.hotelroombooking.dao;

import java.util.List;

import com.mkp.hotelroombooking.model.Operator;

public interface OperatorDao {
	
	public List<Operator> operatorView() throws Exception;
	
	public boolean loginCheck(int operCode, String password) throws Exception;

}
