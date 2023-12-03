package com.mkp.hotelroombooking.dao;

public interface MulControlDao {

	public String getBookingNo() throws Exception;

	public String getBillRefNo() throws Exception;

	public void updateBookingNo(int bookingNo) throws Exception;

	public void updateBillRefNo(int billRefNo) throws Exception;

}
