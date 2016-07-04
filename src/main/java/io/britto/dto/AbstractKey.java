package io.britto.dto;

/**
 * Created by tfulton on 7/4/16.
 */
public abstract class AbstractKey
        implements Key {

    private String merchantId;
    private String objectId;

    public AbstractKey() {
    }

    protected AbstractKey(String merchantId, String objectId) {
        this.merchantId = merchantId;
        this.objectId = objectId;
    }

    @Override
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
