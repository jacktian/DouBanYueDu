package com.tencent.wxop.stat;

import android.content.Context;

final class h implements Runnable {
    final /* synthetic */ Context e;
    final /* synthetic */ int g;

    h(Context context) {
        this.e = context;
        this.g = -1;
    }

    public final void run() {
        try {
            e.p(this.e);
            t.s(this.e).b(this.g);
        } catch (Throwable th) {
            e.aV.b(th);
            e.a(this.e, th);
        }
    }
}
