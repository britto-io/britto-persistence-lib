package io.britto.dto;

/**
 * Created by tfulton on 7/3/16.
 */
public interface Key {

    enum DATA_TYPE {
        TRANS
    }

    default String getKey() {

        return getDataType() + ":" + getMerchantId() + ":" + getObjectId();
    }

    DATA_TYPE getDataType();

    String getMerchantId();

    String getObjectId();
}
