package com.rawalinfocom.rcontact.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rawalinfocom.rcontact.R;
import com.rawalinfocom.rcontact.constants.AppConstants;
import com.rawalinfocom.rcontact.helper.Utils;
import com.rawalinfocom.rcontact.model.MobileNumber;

import java.util.ArrayList;

/**
 * Created by Monal on 15/11/16.
 * <p>
 * Table operations rc_mobile_number_master
 */

public class TableMobileMaster {

    private DatabaseHandler databaseHandler;

    public TableMobileMaster(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    // Table Names
    static final String TABLE_RC_MOBILE_NUMBER_MASTER = "rc_mobile_number_master";

    // Column Names
    private static final String COLUMN_MNM_ID = "mnm_id";
    private static final String COLUMN_MNM_CLOUD_ID = "mnm_cloud_id";
    static final String COLUMN_MNM_MOBILE_NUMBER = "mnm_mobile_number";
    static final String COLUMN_MNM_NUMBER_TYPE = "mnm_number_type";
    private static final String COLUMN_MNM_CUSTOM_TYPE = "mnm_custom_type";
    static final String COLUMN_MNM_IS_PRIMARY = "mnm_is_primary";
    static final String COLUMN_MNM_NUMBER_PRIVACY = "mnm_number_privacy";
    private static final String COLUMN_MNM_IS_DEFAULT = "mnm_is_default";
    private static final String COLUMN_MNM_IS_VERIFIED = "mnm_is_verified";
    private static final String COLUMN_MNM_MOBILE_SERVICE_PROVIDER = "mnm_mobile_service_provider";
    private static final String COLUMN_MNM_CIRCLE_OF_SERVICE = "mnm_circle_of_service";
    private static final String COLUMN_MNM_SPAM_COUNT = "mnm_spam_count";
    static final String COLUMN_RC_PROFILE_MASTER_PM_ID = "rc_profile_master_pm_id";


    // Table Create Statements
    static final String CREATE_TABLE_RC_MOBILE_NUMBER_MASTER = "CREATE TABLE " +
            TABLE_RC_MOBILE_NUMBER_MASTER + " (" +
            " " + COLUMN_MNM_ID + " integer NOT NULL CONSTRAINT rc_mobile_number_master_pk " +
            "PRIMARY KEY AUTOINCREMENT," +
            " " + COLUMN_MNM_CLOUD_ID + " integer," +
            " " + COLUMN_MNM_MOBILE_NUMBER + " text NOT NULL," +
            " " + COLUMN_MNM_NUMBER_TYPE + " text," +
            " " + COLUMN_MNM_CUSTOM_TYPE + " text," +
            " " + COLUMN_MNM_IS_PRIMARY + " integer," +
            " " + COLUMN_MNM_NUMBER_PRIVACY + " integer DEFAULT 1," +
            " " + COLUMN_MNM_IS_DEFAULT + " integer," +
            " " + COLUMN_MNM_IS_VERIFIED + " integer," +
            " " + COLUMN_MNM_MOBILE_SERVICE_PROVIDER + " text," +
            " " + COLUMN_MNM_CIRCLE_OF_SERVICE + " text," +
            " " + COLUMN_MNM_SPAM_COUNT + " integer," +
            " " + COLUMN_RC_PROFILE_MASTER_PM_ID + " integer" +
            ");";

    // Adding new Mobile Number
    public void addMobileNumber(MobileNumber mobileNumber) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MNM_ID, mobileNumber.getMnmId());
        values.put(COLUMN_MNM_CLOUD_ID, mobileNumber.getMnmCloudId());
        values.put(COLUMN_MNM_MOBILE_NUMBER, mobileNumber.getMnmMobileNumber());
        values.put(COLUMN_MNM_NUMBER_TYPE, mobileNumber.getMnmNumberType());
        values.put(COLUMN_MNM_CUSTOM_TYPE, mobileNumber.getMnmCustomType());
        values.put(COLUMN_MNM_IS_PRIMARY, mobileNumber.getMnmIsPrimary());
        values.put(COLUMN_MNM_NUMBER_PRIVACY, mobileNumber.getMnmNumberPrivacy());
        values.put(COLUMN_MNM_IS_DEFAULT, mobileNumber.getMnmIsDefault());
        values.put(COLUMN_MNM_IS_VERIFIED, mobileNumber.getMnmIsVerified());
        values.put(COLUMN_MNM_MOBILE_SERVICE_PROVIDER, mobileNumber.getMnmMobileServiceProvider());
        values.put(COLUMN_MNM_CIRCLE_OF_SERVICE, mobileNumber.getMnmCircleOfService());
        values.put(COLUMN_MNM_SPAM_COUNT, mobileNumber.getMnmSpamCount());
        values.put(COLUMN_RC_PROFILE_MASTER_PM_ID, mobileNumber.getRcProfileMasterPmId());


        // Inserting Row
        db.insert(TABLE_RC_MOBILE_NUMBER_MASTER, null, values);
        // insertWithOnConflict
        db.close(); // Closing database connection
    }

    // Adding array Mobile Number
    public void addArrayMobileNumber(ArrayList<MobileNumber> arrayListMobileNumber) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

//        ContentValues values = new ContentValues();
        for (int i = 0; i < arrayListMobileNumber.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_MNM_ID, arrayListMobileNumber.get(i).getMnmId());
            values.put(COLUMN_MNM_CLOUD_ID, arrayListMobileNumber.get(i).getMnmCloudId());
            values.put(COLUMN_MNM_MOBILE_NUMBER, arrayListMobileNumber.get(i).getMnmMobileNumber());
            values.put(COLUMN_MNM_NUMBER_TYPE, arrayListMobileNumber.get(i).getMnmNumberType());
            values.put(COLUMN_MNM_CUSTOM_TYPE, arrayListMobileNumber.get(i).getMnmCustomType());
            values.put(COLUMN_MNM_IS_PRIMARY, arrayListMobileNumber.get(i).getMnmIsPrimary());
            values.put(COLUMN_MNM_NUMBER_PRIVACY, arrayListMobileNumber.get(i)
                    .getMnmNumberPrivacy());
            values.put(COLUMN_MNM_IS_DEFAULT, arrayListMobileNumber.get(i).getMnmIsDefault());
            values.put(COLUMN_MNM_IS_VERIFIED, arrayListMobileNumber.get(i).getMnmIsVerified());
            values.put(COLUMN_MNM_MOBILE_SERVICE_PROVIDER, arrayListMobileNumber.get(i)
                    .getMnmMobileServiceProvider());
            values.put(COLUMN_MNM_CIRCLE_OF_SERVICE, arrayListMobileNumber.get(i)
                    .getMnmCircleOfService());
            values.put(COLUMN_MNM_SPAM_COUNT, arrayListMobileNumber.get(i).getMnmSpamCount());
            values.put(COLUMN_RC_PROFILE_MASTER_PM_ID, arrayListMobileNumber.get(i)
                    .getRcProfileMasterPmId());

            // Inserting Row
            db.insert(TABLE_RC_MOBILE_NUMBER_MASTER, null, values);
        }
        db.close(); // Closing database connection
    }

    // Getting single Mobile Number
    public MobileNumber getMobileNumber(int mnmId) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RC_MOBILE_NUMBER_MASTER, new String[]{COLUMN_MNM_ID,
                COLUMN_MNM_CLOUD_ID, COLUMN_MNM_MOBILE_NUMBER, COLUMN_MNM_NUMBER_TYPE,
                COLUMN_MNM_CUSTOM_TYPE, COLUMN_MNM_IS_PRIMARY, COLUMN_MNM_NUMBER_PRIVACY,
                COLUMN_MNM_IS_DEFAULT, COLUMN_MNM_IS_VERIFIED,
                COLUMN_MNM_MOBILE_SERVICE_PROVIDER, COLUMN_MNM_CIRCLE_OF_SERVICE,
                COLUMN_MNM_SPAM_COUNT, COLUMN_RC_PROFILE_MASTER_PM_ID}, COLUMN_MNM_ID + "=?", new
                String[]{String.valueOf(mnmId)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MobileNumber mobileNumber = new MobileNumber();
        if (cursor != null) {
            mobileNumber.setMnmId(cursor.getString(0));
            mobileNumber.setMnmCloudId(cursor.getString(1));
            mobileNumber.setMnmMobileNumber(cursor.getString(2));
            mobileNumber.setMnmNumberType(cursor.getString(3));
            mobileNumber.setMnmCustomType(cursor.getString(4));
            mobileNumber.setMnmIsPrimary(cursor.getString(5));
            mobileNumber.setMnmNumberPrivacy(cursor.getString(6));
            mobileNumber.setMnmIsDefault(cursor.getString(7));
            mobileNumber.setMnmIsVerified(cursor.getString(8));
            mobileNumber.setMnmCircleOfService(cursor.getString(9));
            mobileNumber.setMnmSpamCount(cursor.getString(10));
            mobileNumber.setRcProfileMasterPmId(cursor.getString(11));

            cursor.close();
        }

        db.close();

        // return Mobile Number
        return mobileNumber;
    }

    // Getting All Mobile Numbers
    public ArrayList<MobileNumber> getAllMobileNumbers() {
        ArrayList<MobileNumber> arrayListMobileNumber = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RC_MOBILE_NUMBER_MASTER;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MobileNumber mobileNumber = new MobileNumber();
                mobileNumber.setMnmId(cursor.getString(0));
                mobileNumber.setMnmCloudId(cursor.getString(1));
                mobileNumber.setMnmMobileNumber(cursor.getString(2));
                mobileNumber.setMnmNumberType(cursor.getString(3));
                mobileNumber.setMnmCustomType(cursor.getString(4));
                mobileNumber.setMnmIsPrimary(cursor.getString(5));
                mobileNumber.setMnmNumberPrivacy(cursor.getString(6));
                mobileNumber.setMnmIsDefault(cursor.getString(7));
                mobileNumber.setMnmIsVerified(cursor.getString(8));
                mobileNumber.setMnmCircleOfService(cursor.getString(9));
                mobileNumber.setMnmSpamCount(cursor.getString(10));
                mobileNumber.setRcProfileMasterPmId(cursor.getString(11));
                // Adding Mobile Number to list
                arrayListMobileNumber.add(mobileNumber);
            } while (cursor.moveToNext());

            cursor.close();

        }

        db.close();

        // return Mobile Number list
        return arrayListMobileNumber;
    }

    // Getting All Mobile Numbers from Profile Master Id
    public ArrayList<MobileNumber> getMobileNumbersFromPmId(int pmId) {
        ArrayList<MobileNumber> arrayListMobileNumber = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_RC_MOBILE_NUMBER_MASTER + " WHERE " +
                COLUMN_RC_PROFILE_MASTER_PM_ID + " = " + pmId;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MobileNumber mobileNumber = new MobileNumber();
                mobileNumber.setMnmId(cursor.getString(0));
                mobileNumber.setMnmCloudId(cursor.getString(1));
                mobileNumber.setMnmMobileNumber(cursor.getString(2));
                mobileNumber.setMnmNumberType(cursor.getString(3));
                mobileNumber.setMnmCustomType(cursor.getString(4));
                mobileNumber.setMnmIsPrimary(cursor.getString(5));
                mobileNumber.setMnmNumberPrivacy(cursor.getString(6));
                mobileNumber.setMnmIsDefault(cursor.getString(7));
                mobileNumber.setMnmIsVerified(cursor.getString(8));
                mobileNumber.setMnmCircleOfService(cursor.getString(9));
                mobileNumber.setMnmSpamCount(cursor.getString(10));
                mobileNumber.setRcProfileMasterPmId(cursor.getString(11));
                // Adding Mobile Number to list
                arrayListMobileNumber.add(mobileNumber);
            } while (cursor.moveToNext());

            cursor.close();

        }

        db.close();

        // return Mobile Number list
        return arrayListMobileNumber;
    }

    // Getting Own Verified Mobile Number
    public MobileNumber getOwnVerifiedMobileNumbersFromPmId(Context context) {

        String pmId = Utils.getStringPreference(context, AppConstants.PREF_USER_PM_ID, "0");
        String rcpType = String.valueOf(context.getResources().getInteger(R.integer
                .rcp_type_primary));

        String selectQuery = "SELECT * FROM " + TABLE_RC_MOBILE_NUMBER_MASTER + " WHERE " +
                COLUMN_RC_PROFILE_MASTER_PM_ID + " = " + pmId + " AND " + COLUMN_MNM_IS_PRIMARY +
                " = " + rcpType;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        MobileNumber mobileNumber = new MobileNumber();

        if (cursor.moveToFirst()) {

            mobileNumber.setMnmId(cursor.getString(0));
            mobileNumber.setMnmCloudId(cursor.getString(1));
            mobileNumber.setMnmMobileNumber(cursor.getString(2));
            mobileNumber.setMnmNumberType(cursor.getString(3));
            mobileNumber.setMnmCustomType(cursor.getString(4));
            mobileNumber.setMnmIsPrimary(cursor.getString(5));
            mobileNumber.setMnmNumberPrivacy(cursor.getString(6));
            mobileNumber.setMnmIsDefault(cursor.getString(7));
            mobileNumber.setMnmIsVerified(cursor.getString(8));
            mobileNumber.setMnmCircleOfService(cursor.getString(9));
            mobileNumber.setMnmSpamCount(cursor.getString(10));
            mobileNumber.setRcProfileMasterPmId(cursor.getString(11));

            cursor.close();

        }

        db.close();

        return mobileNumber;
    }

    // Getting Mobile Number Count
    public int getMobileNumberCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RC_MOBILE_NUMBER_MASTER;
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        // return count
        return count;
    }

    // Updating single Mobile Number
    public int updateMobileNumber(MobileNumber mobileNumber) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MNM_ID, mobileNumber.getMnmId());
        values.put(COLUMN_MNM_CLOUD_ID, mobileNumber.getMnmCloudId());
        values.put(COLUMN_MNM_MOBILE_NUMBER, mobileNumber.getMnmMobileNumber());
        values.put(COLUMN_MNM_NUMBER_TYPE, mobileNumber.getMnmNumberType());
        values.put(COLUMN_MNM_CUSTOM_TYPE, mobileNumber.getMnmCustomType());
        values.put(COLUMN_MNM_IS_PRIMARY, mobileNumber.getMnmIsPrimary());
        values.put(COLUMN_MNM_NUMBER_PRIVACY, mobileNumber.getMnmNumberPrivacy());
        values.put(COLUMN_MNM_IS_DEFAULT, mobileNumber.getMnmIsDefault());
        values.put(COLUMN_MNM_IS_VERIFIED, mobileNumber.getMnmIsVerified());
        values.put(COLUMN_MNM_MOBILE_SERVICE_PROVIDER, mobileNumber.getMnmMobileServiceProvider());
        values.put(COLUMN_MNM_CIRCLE_OF_SERVICE, mobileNumber.getMnmCircleOfService());
        values.put(COLUMN_MNM_SPAM_COUNT, mobileNumber.getMnmSpamCount());
        values.put(COLUMN_RC_PROFILE_MASTER_PM_ID, mobileNumber.getRcProfileMasterPmId());

        // updating row
        int isUpdated = db.update(TABLE_RC_MOBILE_NUMBER_MASTER, values, COLUMN_MNM_ID + " = ?",
                new String[]{String.valueOf(mobileNumber.getMnmId())});

        db.close();

        return isUpdated;
    }

    // Deleting single Mobile Number
    public void deleteMobileNumber(MobileNumber mobileNumber) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(TABLE_RC_MOBILE_NUMBER_MASTER, COLUMN_MNM_ID + " = ?",
                new String[]{String.valueOf(mobileNumber.getMnmId())});
        db.close();
    }
}