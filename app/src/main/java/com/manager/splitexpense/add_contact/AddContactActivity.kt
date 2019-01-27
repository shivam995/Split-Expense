package com.manager.splitexpense.add_contact

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.manager.splitexpense.R
import com.manager.splitexpense.utils.Utils


class AddContactActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {


    private var mContext: Context? = null
    private val RC_CONTACT_PERMISSION = 111
    private var adapter: SimpleCursorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(R.layout.activity_add_contact)

        if (!Utils.isPermissionGranted(mContext!!, Manifest.permission.READ_CONTACTS)) {
            //TODO: request for permission

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS), RC_CONTACT_PERMISSION

            )
        } else {
            setupCursorAdapter()
        }
    }


    private fun setupCursorAdapter() {
        Log.i("setting adapter","")
        // Column data from cursor to bind views from
        val uiBindFrom = arrayOf(ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.HAS_PHONE_NUMBER)
        // View IDs which will have the respective column data inserted
        val uiBindTo = intArrayOf(R.id.tvName, R.id.tvPhoneNumber)

        adapter = SimpleCursorAdapter(
            this, R.layout.itemview_contact,
            null, uiBindFrom, uiBindTo,
            0
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == RC_CONTACT_PERMISSION) {
                //TODO: load contacts here
                setupCursorAdapter()
            }
        } else {
            Toast.makeText(mContext,"Permission not granted",Toast.LENGTH_LONG).show()
        }
    }



    override fun onCreateLoader(p0: Int, p1: Bundle?): Loader<Cursor> {

        val projectionFields = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.PHOTO_URI
        )

        return CursorLoader(
            this,
            ContactsContract.Contacts.CONTENT_URI,
            projectionFields, null, null, null
        )
    }

    override fun onLoadFinished(p0: Loader<Cursor>, p1: Cursor?) {
        adapter?.swapCursor(p1)
    }

    override fun onLoaderReset(p0: Loader<Cursor>) {
        adapter?.swapCursor(null)
    }
}
