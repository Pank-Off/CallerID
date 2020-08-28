package com.technopark.callerid.view.ui.callLog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/technopark/callerid/view/ui/callLog/PhoneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/technopark/callerid/view/ui/callLog/PhoneAdapter$ViewHolder;", "contactList", "", "Lcom/technopark/callerid/view/ui/callLog/PhoneBook;", "onItemClickListener", "Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;", "(Ljava/util/List;Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;)V", "contacts", "context", "Landroid/content/Context;", "listener", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class PhoneAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.technopark.callerid.view.ui.callLog.PhoneAdapter.ViewHolder> {
    private java.util.List<com.technopark.callerid.view.ui.callLog.PhoneBook> contacts;
    private android.content.Context context;
    private com.technopark.callerid.view.ui.callLog.OnItemClickListener listener;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.technopark.callerid.view.ui.callLog.PhoneAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.technopark.callerid.view.ui.callLog.PhoneAdapter.ViewHolder holder, int position) {
    }
    
    public PhoneAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.technopark.callerid.view.ui.callLog.PhoneBook> contactList, @org.jetbrains.annotations.NotNull()
    com.technopark.callerid.view.ui.callLog.OnItemClickListener onItemClickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lcom/technopark/callerid/view/ui/callLog/PhoneAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onItemClickListener", "Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;", "(Landroid/view/View;Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;)V", "flagView", "Landroid/widget/ImageView;", "getFlagView", "()Landroid/widget/ImageView;", "setFlagView", "(Landroid/widget/ImageView;)V", "listener", "getListener", "()Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;", "setListener", "(Lcom/technopark/callerid/view/ui/callLog/OnItemClickListener;)V", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "setNameView", "(Landroid/widget/TextView;)V", "numberView", "getNumberView", "setNumberView", "oneItemView", "Landroid/widget/LinearLayout;", "getOneItemView", "()Landroid/widget/LinearLayout;", "setOneItemView", "(Landroid/widget/LinearLayout;)V", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView flagView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView nameView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView numberView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.LinearLayout oneItemView;
        @org.jetbrains.annotations.NotNull()
        private com.technopark.callerid.view.ui.callLog.OnItemClickListener listener;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getFlagView() {
            return null;
        }
        
        public final void setFlagView(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
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
        public final android.widget.LinearLayout getOneItemView() {
            return null;
        }
        
        public final void setOneItemView(@org.jetbrains.annotations.NotNull()
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.technopark.callerid.view.ui.callLog.OnItemClickListener getListener() {
            return null;
        }
        
        public final void setListener(@org.jetbrains.annotations.NotNull()
        com.technopark.callerid.view.ui.callLog.OnItemClickListener p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.technopark.callerid.view.ui.callLog.OnItemClickListener onItemClickListener) {
            super(null);
        }
    }
}