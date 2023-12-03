package com.mkp.hotelroombooking.logic;

import java.util.List;

import com.mkp.hotelroombooking.model.Operator;
import com.mkp.hotelroombooking.serviceimpl.OperatorServiceImpl;

public class OperatorLogic {

	public List<Operator> operatorView() throws Exception {

		OperatorServiceImpl operatorServiceImpl = new OperatorServiceImpl();

		return operatorServiceImpl.operatorView();
	}

	public boolean loginCheck(int operCode, String password) throws Exception {

		OperatorServiceImpl operatorServiceImpl = new OperatorServiceImpl();

		return operatorServiceImpl.loginCheck(operCode, password);

	}

}