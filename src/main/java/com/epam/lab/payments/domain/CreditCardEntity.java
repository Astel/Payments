package com.epam.lab.payments.domain;

import lombok.Data;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "credit_card", schema = "public", catalog = "srv105242_pay2")
public class CreditCardEntity {
    private int id;
    private String cardholderName;
    private Date expiration;
    private int securityCode;
    private BankAccountEntity bankAccountByAccountId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cardholder_name", nullable = false, length = -1)
    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    @Basic
    @Column(name = "expiration", nullable = false)
    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Basic
    @Column(name = "security_code", nullable = false)
    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCardEntity that = (CreditCardEntity) o;

        if (id != that.id) return false;
        if (securityCode != that.securityCode) return false;
        if (cardholderName != null ? !cardholderName.equals(that.cardholderName) : that.cardholderName != null)
            return false;
        if (expiration != null ? !expiration.equals(that.expiration) : that.expiration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cardholderName != null ? cardholderName.hashCode() : 0);
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        result = 31 * result + securityCode;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public BankAccountEntity getBankAccountByAccountId() {
        return bankAccountByAccountId;
    }

    public void setBankAccountByAccountId(BankAccountEntity bankAccountByAccountId) {
        this.bankAccountByAccountId = bankAccountByAccountId;
    }
}
