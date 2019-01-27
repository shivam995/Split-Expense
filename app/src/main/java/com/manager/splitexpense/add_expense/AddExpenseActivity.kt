package com.manager.splitexpense.add_expense

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.manager.splitexpense.R
import com.manager.splitexpense.add_contact.AddContactActivity
import com.manager.splitexpense.dao.Participant
import kotlinx.android.synthetic.main.activity_add_expense.*

class AddExpenseActivity : AppCompatActivity() {

    private var mContext: Context? = null
    private val RC_ADD_CONTACT = 101
    private var selectedContactList = ArrayList<Participant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(R.layout.activity_add_expense)



        btnAddContact.setOnClickListener {
            //            var countIndex = containerParticipants.childCount
//            countIndex = if (countIndex == 0) 0 else countIndex - 1
//            val view = ViewFactory.getView(
//                Constants.VIEW_TYPE_PARTICIPANT,
//                mContext!!
//            )
//            view?.tag = countIndex
//            Log.i("child added with tag", countIndex.toString())
//            containerParticipants.addView(view)


            startActivityForResult(Intent(mContext, AddContactActivity::class.java), RC_ADD_CONTACT)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_ADD_CONTACT && resultCode == Activity.RESULT_OK){
            //todo: get selected contact data here
        }
    }
}
