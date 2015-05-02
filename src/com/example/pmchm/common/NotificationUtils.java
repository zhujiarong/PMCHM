package com.example.pmchm.common;

import com.example.pmchm.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class NotificationUtils {
	/**
	 * 发送文字通知
	 * @param context
	 * @param Msg
	 * @param Title
	 * @param content
	 * @param i 
	 */
	@SuppressWarnings("deprecation")
	public static void sendText(Context context, String Msg, String Title,
			String content, Intent i) {
		NotificationManager mn = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher,
				Msg, System.currentTimeMillis());
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, i,
				PendingIntent.FLAG_UPDATE_CURRENT);
		notification.setLatestEventInfo(context, Title, content, contentIntent);
		mn.notify(0, notification);
	}
}
