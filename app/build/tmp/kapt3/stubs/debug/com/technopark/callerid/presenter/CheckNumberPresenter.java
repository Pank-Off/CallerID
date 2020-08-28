package com.technopark.callerid.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/technopark/callerid/presenter/CheckNumberPresenter;", "", "checkNumberView", "Lcom/technopark/callerid/view/ui/checkNumber/CheckNumberView;", "(Lcom/technopark/callerid/view/ui/checkNumber/CheckNumberView;)V", "correctPhone", "", "model", "Lcom/technopark/callerid/model/Model;", "getModel", "()Lcom/technopark/callerid/model/Model;", "setModel", "(Lcom/technopark/callerid/model/Model;)V", "util", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "checkValidNumber", "", "context", "Landroid/content/Context;", "number", "getSingleUserInfo", "app_debug"})
public final class CheckNumberPresenter {
    private io.michaelrocks.libphonenumber.android.PhoneNumberUtil util;
    private java.lang.String correctPhone;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.technopark.callerid.model.Model model;
    private com.technopark.callerid.view.ui.checkNumber.CheckNumberView checkNumberView;
    
    @org.jetbrains.annotations.NotNull()
    public final com.technopark.callerid.model.Model getModel() {
        return null;
    }
    
    public final void setModel(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.model.Model p0) {
    }
    
    public final void checkValidNumber(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
    
    public final void getSingleUserInfo() {
    }
    
    public CheckNumberPresenter(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.view.ui.checkNumber.CheckNumberView checkNumberView) {
        super();
    }
}