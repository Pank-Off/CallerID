package com.technopark.callerid.view.ui.callLog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/technopark/callerid/view/ui/callLog/CallLogView;", "", "setCallLog", "", "contacts", "Ljava/util/ArrayList;", "Lcom/technopark/callerid/view/ui/callLog/PhoneBook;", "Lkotlin/collections/ArrayList;", "app_debug"})
public abstract interface CallLogView {
    
    public abstract void setCallLog(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.technopark.callerid.view.ui.callLog.PhoneBook> contacts);
}