package com.mkp.hotelroombooking.service;

import java.util.List;

import com.mkp.hotelroombooking.model.Operator;

public interface OperatorService {

	public List<Operator> operatorView() throws Exception;

	public boolean loginCheck(int operCode, String password) throws Exception;

}