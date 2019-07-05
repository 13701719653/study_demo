package com.study.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by xwg on 2019/6/19.
 * describe TODO
 *
 */
class  BackService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}