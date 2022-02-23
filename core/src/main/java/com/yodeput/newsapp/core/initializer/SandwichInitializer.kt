/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */


package com.yodeput.newsapp.core.initializer

import android.content.Context
import androidx.startup.Initializer
import com.skydoves.sandwich.SandwichInitializer
import com.yodeput.newsapp.core.operator.GlobalResponseOperator

class SandwichInitializer : Initializer<Unit> {

  override fun create(context: Context) {

    // initialize global sandwich operator
    SandwichInitializer.sandwichOperator = GlobalResponseOperator<Unit>(context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
