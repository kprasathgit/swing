package com.mkp.hotelroombooking.serviceimpl;

import java.util.List;

import com.mkp.hotelroombooking.dao.OperatorDao;
import com.mkp.hotelroombooking.daoimpl.OperatorDaoImpl;
import com.mkp.hotelroombooking.model.Operator;
import com.mkp.hotelroombooking.service.OperatorService;

public class OperatorServiceImpl implements OperatorService {

	@Override
	public List<Operator> operatorView() throws Exception {

		OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();

		return operatorDaoImpl.operatorView();

	}

	@Override
	public boolean loginCheck(int operCode, String password) throws Exception {
		OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();

		return operatorDaoImpl.loginCheck(operCode, password);
	}

}