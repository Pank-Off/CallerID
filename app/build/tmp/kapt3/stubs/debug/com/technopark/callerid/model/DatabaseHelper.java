package com.technopark.callerid.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/technopark/callerid/model/DatabaseHelper;", "", "()V", "COL1", "", "COL2", "COL3", "COL4", "spamerDao", "Lcom/technopark/callerid/model/room/SpamerDao;", "addRecord", "", "number", "isSpam", "", "comment", "getData", "getSingleUserInfo", "removeRecord", "app_debug"})
public final class DatabaseHelper {
    private final java.lang.String COL1 = "ID";
    private final java.lang.String COL2 = "phoneNumber";
    private final java.lang.String COL3 = "isSpam";
    private final java.lang.String COL4 = "comment";
    private com.technopark.callerid.model.room.SpamerDao spamerDao;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSingleUserInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
        return null;
    }
    
    public final void addRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number, boolean isSpam, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
    }
    
    public final void getData() {
    }
    
    public final void removeRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
    
    public DatabaseHelper() {
        super();
    }
}