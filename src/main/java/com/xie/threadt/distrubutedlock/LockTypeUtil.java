package com.xie.threadt.distrubutedlock;

public class LockTypeUtil {
    public static String generatePrefix(LockType lockType) {
        return lockType.toString();
    }

    public static String keyCompound(LockType lockType, String originKey) {
        return LockTypeUtil.generatePrefix(lockType) + "-" + originKey;
    }
}
