package com.technopark.callerid.view.ui.callLog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\u0012\u0010&\u001a\u00020$2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006."}, d2 = {"Lcom/technopark/callerid/view/ui/callLog/DetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/technopark/callerid/view/ui/callLog/DetailView;", "()V", "call", "Landroid/widget/ImageView;", "getCall", "()Landroid/widget/ImageView;", "setCall", "(Landroid/widget/ImageView;)V", "detailPresenter", "Lcom/technopark/callerid/presenter/DetailPresenter;", "getDetailPresenter", "()Lcom/technopark/callerid/presenter/DetailPresenter;", "setDetailPresenter", "(Lcom/technopark/callerid/presenter/DetailPresenter;)V", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "setNameView", "(Landroid/widget/TextView;)V", "numberView", "getNumberView", "setNumberView", "spamerDao", "Lcom/technopark/callerid/model/room/SpamerDao;", "getSpamerDao", "()Lcom/technopark/callerid/model/room/SpamerDao;", "thisIsSpamBtn", "Lcom/google/android/material/button/MaterialButton;", "getThisIsSpamBtn", "()Lcom/google/android/material/button/MaterialButton;", "setThisIsSpamBtn", "(Lcom/google/android/material/button/MaterialButton;)V", "addSuccessful", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeSuccessful", "setOnImageClickListener", "setOnSpamBtnClickListener", "setText", "Companion", "app_debug"})
public final class DetailActivity extends androidx.appcompat.app.AppCompatActivity implements com.technopark.callerid.view.ui.callLog.DetailView {
    @org.jetbrains.annotations.NotNull()
    public com.technopark.callerid.presenter.DetailPresenter detailPresenter;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView nameView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView numberView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView call;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.material.button.MaterialButton thisIsSpamBtn;
    @org.jetbrains.annotations.NotNull()
    private final com.technopark.callerid.model.room.SpamerDao spamerDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA = "EXTRA";
    public static final com.technopark.callerid.view.ui.callLog.DetailActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.technopark.callerid.presenter.DetailPresenter getDetailPresenter() {
        return null;
    }
    
    public final void setDetailPresenter(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.presenter.DetailPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getNameView() {
        return null;
    }
    
    public final void setNameView(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getNumberView() {
        return null;
    }
    
    public final void setNumberView(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getCall() {
        return null;
    }
    
    public final void setCall(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.button.MaterialButton getThisIsSpamBtn() {
        return null;
    }
    
    public final void setThisIsSpamBtn(@org.jetbrains.annotations.NotNull()
    com.google.android.material.button.MaterialButton p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.technopark.callerid.model.room.SpamerDao getSpamerDao() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setOnSpamBtnClickListener() {
    }
    
    private final void setOnImageClickListener() {
    }
    
    private final void setText() {
    }
    
    private final void initViews() {
    }
    
    @java.lang.Override()
    public void addSuccessful() {
    }
    
    @java.lang.Override()
    public void removeSuccessful() {
    }
    
    public DetailActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/technopark/callerid/view/ui/callLog/DetailActivity$Companion;", "", "()V", "EXTRA", "", "getEXTRA", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEXTRA() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}