package com.mkp.hotelroombooking.daoimpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mkp.hotelroombooking.common.DatabaseConnection;
import com.mkp.hotelroombooking.dao.OperatorDao;
import com.mkp.hotelroombooking.model.Operator;
import com.mkp.hotelroombooking.query.OperatorQuery;

public class OperatorDaoImpl implements OperatorDao {

	public List<Operator> operatorView() throws Exception {

		ResultSet resultSet;
		Statement statement = DatabaseConnection.dbconn.createStatement();

		OperatorQuery operatorQuery = new OperatorQuery();
		resultSet = statement.executeQuery(operatorQuery.operatorView());

		/*
		 * if (resultSet.isFirst()) { JOptionPane.showMessageDialog(null,
		 * "operator list is empty "); resultSet.close(); statement.close(); return
		 * null; }
		 */

		List<Operator> lstOperators = new ArrayList<Operator>();
		while (resultSet.next()) {

			Operator operator = new Operator();

			operator.setOpercode(resultSet.getInt("opercode"));
			operator.setOpername(resultSet.getString("opername"));
			operator.setPassword(resultSet.getString("password"));
			operator.setActive(resultSet.getString("active"));

			lstOperators.add(operator);

		}

		resultSet.close();
		statement.close();
		return lstOperators;

	}

	public boolean loginCheck(int operCode, String password) throws Exception {

		ResultSet resultSet;
		Statement statement = DatabaseConnection.dbconn.createStatement();

		OperatorQuery operatorQuery = new OperatorQuery();
		resultSet = statement.executeQuery(operatorQuery.loginCheck(operCode, password));

		if (resultSet.next()) {

			resultSet.close();
			statement.close();
			return true;
		}

		else {

			resultSet.close();
			statement.close();
			return false;
		}

	}

}