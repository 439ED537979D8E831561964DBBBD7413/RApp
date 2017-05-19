package com.rawalinfocom.rcontact.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.rawalinfocom.rcontact.model.ContactRequestData;
import com.rawalinfocom.rcontact.model.NotificationStateData;

/**
 * Created by Maulik on 15/05/17.
 * Table operations rc_notification_state
 */

public class TableNotificationStateMaster {

    private DatabaseHandler databaseHandler;

    public TableNotificationStateMaster(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    // Table Names
    private static final String TABLE_NOTIFICATION_STATE_MASTER = "rc_notification_state";

    // Column Names
    private static final String COLUMN_NS_ID = "ns_id";

    private static final String COLUMN_NS_STATE = "ns_state";
//    1:unread,2:read

    private static final String COLUMN_NS_TYPE = "ns_type";
//    1:TimeLine,2:Rate,3:Comments,4:Request,5:RUpdate

    private static final String COLUMN_NS_CLOUD_NOTIFICATION_ID = "ns_cloud_notification_id";
    private static final String COLUMN_NS_CREATED_AT = "ns_created_at";
    private static final String COLUMN_NS_UPDATED_AT = "ns_updated_at";

    // Table Create Statements
    static final String CREATE_TABLE_NOTIFICATION_STATE_MASTER = "CREATE TABLE " + TABLE_NOTIFICATION_STATE_MASTER +
            " (" +
            " " + COLUMN_NS_ID + " integer NOT NULL CONSTRAINT rc_notification_state_pk PRIMARY KEY AUTOINCREMENT," +
            " " + COLUMN_NS_STATE + " integer NOT NULL DEFAULT 1," +
            " " + COLUMN_NS_TYPE + " integer NOT NULL," +
            " " + COLUMN_NS_CLOUD_NOTIFICATION_ID + " text NOT NULL," +
            " " + COLUMN_NS_CREATED_AT + " datetime NOT NULL," +
            " " + COLUMN_NS_UPDATED_AT + " datetime NOT NULL" +
            ");";

    // Adding new Event
    public void addNotificationState(NotificationStateData notification) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NS_STATE, notification.getNotificationState());
        values.put(COLUMN_NS_TYPE, notification.getNotificationType());
        values.put(COLUMN_NS_CLOUD_NOTIFICATION_ID, notification.getCloudNotificationId());
        values.put(COLUMN_NS_CREATED_AT, notification.getCreatedAt());
        values.put(COLUMN_NS_UPDATED_AT, notification.getUpdatedAt());

        db.insert(TABLE_NOTIFICATION_STATE_MASTER, null, values);
        db.close(); // Closing database connection
    }


    public int updatePrivacySetting(ContactRequestData obj, String cloudMongoId) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NS_STATE, obj.getEventDatetime());
        // updating row
        int isUpdated = db.update(TABLE_NOTIFICATION_STATE_MASTER, values, COLUMN_NS_CLOUD_NOTIFICATION_ID + " =" +
                        " ?",
                new String[]{cloudMongoId});

        db.close();

        return isUpdated;
    }
}