package com.example.pmchm.common;

public interface Constants {

	String SP_NAME = "sp_secret";
	String SP_VER_MODE = "verificationMode";
	String SP_PWD_NUM = "passward_num";
	String SP_PWD_GES = "passward_ges";
	String SP_COOKIE = "cookie";
	String SP_ACCOUNT_NAME = "login_name";
	String SP_ACCOUNT_PWD = "login_pwd";
	String SP_HUANBAOJU = "seting_huanbaoju";
	String SP_US_EMBASSY = "seting_us_embassy";
	String SP_ALARM = "seting_alarms";

	int VERIFICATION_NUM = 0;
	int VERIFICATION_GES = 1;

	int AC_MAIN = 0;
	int AC_LOAD = 1;
	int AC_SET = 2;
	int AC_MY = 3;
	int AC_SECRET_MANAGER = 4;
	int AC_SET_GESTURE = 5;
	int AC_SET_NUMBER = 6;
	int AC_PRESIDEN = 7;
	int AC_DEVICES_MANAGER = 8;
	int AC_UPDATE_PWD = 9;
	int AC_FIND_PWD = 10;
	int AC_ABOUT = 11;
	int AC_AVERAGE = 12;

	// 接口
	String URL_LOGIN = "http://www.pmchn.com:3000/api/login";
	String URL_LOGOUT= "http://www.pmchn.com:3000/api/logout";
	String URL_DEVICES = "http://www.pmchn.com:3000/api/devices";
	String URL_DATA = "http://www.pmchn.com:3000/api/dtus";
	String URL_SYNC = " http://www.pmchn.com:3000/api/sync";
}
