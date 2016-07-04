package io.britto.dto;

/**
 * Created by tfulton on 7/4/16.
 */
public class TransactionKey
        extends AbstractKey {

    @Override
    public DATA_TYPE getDataType() {
        return DATA_TYPE.TRANS;
    }
}
