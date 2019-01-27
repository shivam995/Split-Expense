package com.manager.splitexpense.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.manager.splitexpense.R
import com.manager.splitexpense.add_expense.AddExpenseActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(R.layout.activity_dashboard)

        initViews()
    }

    private fun initViews() {

        fabAddExpense.setOnClickListener {
            startActivity(Intent(mContext, AddExpenseActivity::class.java))
        }
    }
}
