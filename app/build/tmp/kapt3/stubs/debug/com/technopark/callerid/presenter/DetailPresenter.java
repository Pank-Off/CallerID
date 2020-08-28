package com.technopark.callerid.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/technopark/callerid/presenter/DetailPresenter;", "", "detailView", "Lcom/technopark/callerid/view/ui/callLog/DetailView;", "(Lcom/technopark/callerid/view/ui/callLog/DetailView;)V", "getDetailView", "()Lcom/technopark/callerid/view/ui/callLog/DetailView;", "setDetailView", "model", "Lcom/technopark/callerid/model/Model;", "getModel", "()Lcom/technopark/callerid/model/Model;", "setModel", "(Lcom/technopark/callerid/model/Model;)V", "addRecord", "", "number", "", "isSpam", "", "comment", "removeRecord", "app_debug"})
public final class DetailPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.technopark.callerid.model.Model model;
    @org.jetbrains.annotations.NotNull()
    private com.technopark.callerid.view.ui.callLog.DetailView detailView;
    
    @org.jetbrains.annotations.NotNull()
    public final com.technopark.callerid.model.Model getModel() {
        return null;
    }
    
    public final void setModel(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.model.Model p0) {
    }
    
    public final void addRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number, boolean isSpam, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
    }
    
    public final void removeRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.technopark.callerid.view.ui.callLog.DetailView getDetailView() {
        return null;
    }
    
    public final void setDetailView(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.view.ui.callLog.DetailView p0) {
    }
    
    public DetailPresenter(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.view.ui.callLog.DetailView detailView) {
        super();
    }
}