package com.technopark.callerid.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/technopark/callerid/app/App;", "Landroid/app/Application;", "()V", "firebaseWorker", "Lcom/technopark/callerid/model/FirebaseWorker;", "generateAppComponent", "Lcom/technopark/callerid/app/AppComponent;", "generateAppDataBase", "Lcom/technopark/callerid/model/room/AppDatabase;", "onCreate", "", "tryDownloadDBFromfirebase", "Companion", "app_debug"})
public final class App extends android.app.Application {
    private com.technopark.callerid.model.FirebaseWorker firebaseWorker;
    private static com.technopark.callerid.app.App instance;
    private static com.technopark.callerid.model.room.AppDatabase appDatabase;
    private static com.technopark.callerid.app.AppComponent appComponent;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String APP_PREFERENCES = "callerIDPreferences";
    public static final com.technopark.callerid.app.App.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final com.technopark.callerid.app.AppComponent generateAppComponent() {
        return null;
    }
    
    private final com.technopark.callerid.model.room.AppDatabase generateAppDataBase() {
        return null;
    }
    
    private final void tryDownloadDBFromfirebase() {
    }
    
    public App() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/technopark/callerid/app/App$Companion;", "", "()V", "APP_PREFERENCES", "", "getAPP_PREFERENCES", "()Ljava/lang/String;", "appComponent", "Lcom/technopark/callerid/app/AppComponent;", "appDatabase", "Lcom/technopark/callerid/model/room/AppDatabase;", "instance", "Lcom/technopark/callerid/app/App;", "getAppComponent", "getAppDatabase", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAPP_PREFERENCES() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.technopark.callerid.app.App getInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.technopark.callerid.model.room.AppDatabase getAppDatabase() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.technopark.callerid.app.AppComponent getAppComponent() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}