package com.example.pmchm.utils;

import android.content.Context;

/**
 * 提示信息的管理
 */
public class PromptManager {
	private static CustomProgressDialog progressDialog;

	public static void showProgressDialog(Context context) {
		progressDialog = CustomProgressDialog.createDialog(context);
		progressDialog.setMessage("正在领取…");
		progressDialog.show();
	}
	
	public static void showClearDialog(Context context) {
		progressDialog = CustomProgressDialog.createDialog(context);
		progressDialog.setMessage("正在清理…");
		progressDialog.show();
	}

	public static void showLoadingDialog(Context context) {
		progressDialog = CustomProgressDialog.createDialog(context);
		progressDialog.show();
	}

	public static void closeProgressDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}

	public static void showLoadingDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}
}
