package com.pru.cleanArc.di

import android.app.Activity
import com.kaopiz.kprogresshud.KProgressHUD
import com.pru.cleanArc.presentation.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun provideProgressDialog(activity : Activity) : KProgressHUD {
        return KProgressHUD.create(activity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel("Please wait")
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
    }
}