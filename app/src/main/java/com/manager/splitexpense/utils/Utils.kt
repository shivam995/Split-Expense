package com.manager.splitexpense.utils

import android.content.Context
import android.content.pm.PackageManager

class Utils {


    companion object {



        fun isPermissionGranted(context: Context, permission: String): Boolean {

            return context.packageManager.checkPermission(permission,
                context.packageName) == PackageManager.PERMISSION_GRANTED
        }

    }


}