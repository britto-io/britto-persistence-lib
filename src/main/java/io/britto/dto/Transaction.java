package io.britto.dto;

/**
 * Created by tfulton on 7/3/16.
 */
public class Transaction
    implements Data<TransactionKey>{

    private String merchantId;
    private String merchantTransactionReferenceId;

    @Override
    public TransactionKey getKey() {
        return new TransactionKey(merchantId, merchantTransactionReferenceId);
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTransactionReferenceId() {
        return merchantTransactionReferenceId;
    }

    public void setMerchantTransactionReferenceId(String merchantTransactionReferenceId) {
        this.merchantTransactionReferenceId = merchantTransactionReferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null) return false;
        return merchantTransactionReferenceId != null ? merchantTransactionReferenceId.equals(that.merchantTransactionReferenceId) : that.merchantTransactionReferenceId == null;

    }

    @Override
    public int hashCode() {
        int result = merchantId != null ? merchantId.hashCode() : 0;
        result = 31 * result + (merchantTransactionReferenceId != null ? merchantTransactionReferenceId.hashCode() : 0);
        return result;
    }
}
