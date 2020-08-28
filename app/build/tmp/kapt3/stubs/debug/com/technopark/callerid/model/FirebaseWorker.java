package com.technopark.callerid.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/technopark/callerid/model/FirebaseWorker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "firebaseStorage", "Lcom/google/firebase/storage/FirebaseStorage;", "getFirebaseStorage", "()Lcom/google/firebase/storage/FirebaseStorage;", "setFirebaseStorage", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "nameDB", "", "result", "", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "download", "app_debug"})
public final class FirebaseWorker {
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.FirebaseStorage firebaseStorage;
    private com.google.firebase.storage.StorageReference storageReference;
    private final java.lang.String nameDB = "CloudPhoneDB.db";
    private boolean result;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.FirebaseStorage getFirebaseStorage() {
        return null;
    }
    
    public final void setFirebaseStorage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage p0) {
    }
    
    public final boolean download() {
        return false;
    }
    
    public FirebaseWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}