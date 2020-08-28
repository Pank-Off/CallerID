package com.technopark.callerid.model.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003H\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u000e\u001a\u00020\tH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/technopark/callerid/model/room/SpamerDao;", "", "delete", "Lio/reactivex/Single;", "", "phoneNumber", "", "getAll", "", "Lcom/technopark/callerid/model/room/Spamer;", "getSingleUserInfo", "Landroid/database/Cursor;", "insert", "", "spamer", "app_debug"})
public abstract interface SpamerDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert()
    public abstract io.reactivex.Single<java.lang.Long> insert(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.model.room.Spamer spamer);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "DELETE FROM table_spamers WHERE phoneNumber = :phoneNumber")
    public abstract io.reactivex.Single<java.lang.Integer> delete(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM table_spamers")
    public abstract io.reactivex.Single<java.util.List<com.technopark.callerid.model.room.Spamer>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM table_spamers WHERE phoneNumber = :phoneNumber")
    public abstract android.database.Cursor getSingleUserInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber);
}