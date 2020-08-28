package com.technopark.callerid.view.ui.checkNumber;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010\u0011\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/technopark/callerid/view/ui/checkNumber/CheckNumberFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/technopark/callerid/view/ui/checkNumber/CheckNumberView;", "()V", "appContext", "Landroid/content/Context;", "checkBtn", "Lcom/google/android/material/button/MaterialButton;", "checkNumberPresenter", "Lcom/technopark/callerid/presenter/CheckNumberPresenter;", "fireBaseWorker", "Lcom/technopark/callerid/model/FirebaseWorker;", "isSpamTextfield", "Landroid/widget/TextView;", "numberOfPhoneEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "updateDB", "validNumber", "", "initViews", "", "view", "Landroid/view/View;", "invalidNumber", "isSpam", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "setOnCheckBtnClickListener", "setOnUpdateDBClickListener", "app_debug"})
public final class CheckNumberFragment extends androidx.fragment.app.Fragment implements com.technopark.callerid.view.ui.checkNumber.CheckNumberView {
    private android.content.Context appContext;
    private com.technopark.callerid.presenter.CheckNumberPresenter checkNumberPresenter;
    private com.google.android.material.button.MaterialButton checkBtn;
    private com.google.android.material.textfield.TextInputEditText numberOfPhoneEditText;
    private android.widget.TextView isSpamTextfield;
    private boolean validNumber;
    private com.google.android.material.button.MaterialButton updateDB;
    private com.technopark.callerid.model.FirebaseWorker fireBaseWorker;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    private final void setOnCheckBtnClickListener() {
    }
    
    private final void setOnUpdateDBClickListener() {
    }
    
    @java.lang.Override()
    public void validNumber() {
    }
    
    @java.lang.Override()
    public void invalidNumber() {
    }
    
    @java.lang.Override()
    public void isSpam(@org.jetbrains.annotations.NotNull()
    java.lang.String isSpam) {
    }
    
    public CheckNumberFragment() {
        super();
    }
}