package com.technopark.callerid.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/technopark/callerid/app/AppComponent;", "", "inject", "", "callLogPresenter", "Lcom/technopark/callerid/presenter/CallLogPresenter;", "checkNumberPresenter", "Lcom/technopark/callerid/presenter/CheckNumberPresenter;", "detailPresenter", "Lcom/technopark/callerid/presenter/DetailPresenter;", "settingsPresenter", "Lcom/technopark/callerid/presenter/SettingsPresenter;", "spamProtectionPresenter", "Lcom/technopark/callerid/presenter/SpamProtectionPresenter;", "app_debug"})
@dagger.Component(modules = {com.technopark.callerid.app.AppModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.CallLogPresenter callLogPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.SettingsPresenter settingsPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.CheckNumberPresenter checkNumberPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.SpamProtectionPresenter spamProtectionPresenter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.DetailPresenter detailPresenter);
}