package io.britto.dto;

import static com.google.common.base.Preconditions.*;

/**
 * Created by tfulton on 7/3/16.
 */
public interface Key {

    enum DATA_TYPE {
        TRANS
    }

    default String getKey() {
        checkArgument( getDataType() != null, "DATA_TYPE must not be null.");
        checkArgument(getMerchantId() != null && getMerchantId().length() > 0, "Merchant ID must exist and not be an empty string.");
        checkArgument(getObjectId() != null && getObjectId().length() > 0, "Object ID must exist and not be an empty string.");
        return getDataType().toString() + ":" + getMerchantId() + ":" + getObjectId();
    }

    DATA_TYPE getDataType();

    String getMerchantId();

    String getObjectId();
}
