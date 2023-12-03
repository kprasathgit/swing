package com.mkp.hotelroombooking.common;

import java.awt.Font;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonValues {

	private static int frmWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static int frmHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private static int compWidth = 110;
	private static int compHeight = 30;

	private static int internalFrameWidth;
	private static int internalFrameHeight;

	public static FormActions currentForm;

	private static String masterDb ;

	private static String tranDb;

	private static Date date = new Date();

	private static Font bigBoldf = new Font("Arial", Font.BOLD, 11);

	private static Font boldf = new Font("Arial", Font.BOLD, 10);

	private static Font plainf = new Font("Arial", Font.PLAIN, 10);
	private static Font italicf = new Font("Arial", Font.ITALIC, 8);

	public static Font getBigBoldf() {
		return bigBoldf;
	}

	public static Font getBoldf() {
		return boldf;
	}

	public static Font getPlainf() {
		return plainf;
	}

	public static Font getItalicf() {
		return italicf;
	}

	public static int getInternalFrameWidth() {
		return internalFrameWidth;

	}

	public static void setInternalFrameWidth(int internalFrameWidth) {
		CommonValues.internalFrameWidth = internalFrameWidth;
	}

	public static int getInternalFrameHeight() {
		return internalFrameHeight;
	}

	public static void setInternalFrameHeight(int internalFrameHeight) {
		CommonValues.internalFrameHeight = internalFrameHeight;
	}

	public static int getCompWidth() {
		return compWidth;
	}

	public static void setCompWidth(int compWidth) {
		CommonValues.compWidth = compWidth;
	}

	public static int getCompHeight() {
		return compHeight;
	}

	public static void setCompHeight(int compHeight) {
		CommonValues.compHeight = compHeight;
	}

	public static int getFrmWidth() {
		return frmWidth;
	}

	public static void setFrmWidth(int frmWidth) {
		CommonValues.frmWidth = frmWidth;
	}

	public static int getFrmHeight() {
		return frmHeight;
	}

	public static void setFrmHeight(int frmHeight) {
		CommonValues.frmHeight = frmHeight;
	}

	public static String getMasterDb() {
		return masterDb;
	}

	public static void setMasterDb(String string) {
		CommonValues.masterDb = "mkp";
	}

	public static String getTranDb() {
		return tranDb;
	}

	public static void setTranDb(String tranDb) {
		CommonValues.tranDb = "transac";
	}

	public static Date getDate() {
		return date;
	}



	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	public static SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
	public static DecimalFormat decimalFormat = new DecimalFormat("0.00");

	
}