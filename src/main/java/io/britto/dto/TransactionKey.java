package io.britto.dto;

/**
 * Created by tfulton on 7/4/16.
 */
public class TransactionKey
        extends AbstractKey {

    public TransactionKey() {}

    public TransactionKey(String merchantId, String objectId) {
        super(merchantId, objectId);
    }

    @Override
    public DATA_TYPE getDataType() {
        return DATA_TYPE.TRANS;
    }
}
