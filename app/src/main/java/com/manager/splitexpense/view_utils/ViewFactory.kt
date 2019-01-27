package com.manager.splitexpense.view_utils

import android.content.Context
import android.view.View
import com.manager.splitexpense.utils.Constants


class ViewFactory {


    companion object {

        fun getView(type: String, context: Context): View? {

            when (type) {
                Constants.VIEW_TYPE_PARTICIPANT -> {
                    return CustomParticipantView(context)

                }
            }

            return null
        }
    }
}