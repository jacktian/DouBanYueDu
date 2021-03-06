package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AppNameMacro extends FunctionCallImplementation {
    private static final String ID;
    private final Context mContext;

    static {
        ID = FunctionType.APP_NAME.toString();
    }

    public static String getFunctionId() {
        return ID;
    }

    public AppNameMacro(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean isCacheable() {
        return true;
    }

    public Value evaluate(Map<String, Value> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return Types.objectToValue(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (NameNotFoundException e) {
            Log.e("App name is not found.", e);
            return Types.getDefaultValue();
        }
    }
}
