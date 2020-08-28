package com.technopark.callerid.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\u0015J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/technopark/callerid/model/Model;", "", "()V", "mDatabaseHelper", "Lcom/technopark/callerid/model/DatabaseHelper;", "phoneBooks", "Ljava/util/ArrayList;", "Lcom/technopark/callerid/view/ui/callLog/PhoneBook;", "addRecord", "", "number", "", "isSpam", "", "comment", "determineType", "", "type", "Lme/everything/providers/android/calllog/Call$CallType;", "getAllData", "getPhoneBooks", "Lkotlin/collections/ArrayList;", "getSingleUserInfo", "removeRecord", "setPhoneBooks", "context", "Landroid/content/Context;", "app_debug"})
public final class Model {
    private final java.util.ArrayList<com.technopark.callerid.view.ui.callLog.PhoneBook> phoneBooks = null;
    private final com.technopark.callerid.model.DatabaseHelper mDatabaseHelper = null;
    
    public final void setPhoneBooks(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.technopark.callerid.view.ui.callLog.PhoneBook> getPhoneBooks() {
        return null;
    }
    
    private final int determineType(me.everything.providers.android.calllog.Call.CallType type, java.lang.String number) {
        return 0;
    }
    
    public final void addRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number, boolean isSpam, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
    }
    
    public final void removeRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
    
    public final void getAllData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSingleUserInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
        return null;
    }
    
    public Model() {
        super();
    }
}