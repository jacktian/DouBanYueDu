package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public final class JumpToBizWebview {

    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene;
        public String toUserName;
        public int webType;

        public Req() {
            this.scene = 1;
        }

        public boolean checkArgs() {
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                a.a(TAG, "checkArgs fail, toUserName is invalid");
                return false;
            } else if (this.extMsg == null || this.extMsg.length() <= EXT_MSG_LENGTH) {
                return true;
            } else {
                a.a(TAG, "ext msg is not null, while the length exceed 1024 bytes");
                return false;
            }
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
