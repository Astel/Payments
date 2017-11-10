package com.epam.lab.payments.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account", schema = "public", catalog = "srv105242_pay2")
public class BankAccountEntity {
    private int id;
    private String ownerName;
    private int balance;
    private boolean isBlocked;

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner_name", nullable = false, length = -1)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "balance", nullable = false)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "is_blocked", nullable = false)
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountEntity that = (BankAccountEntity) o;

        if (id != that.id) return false;
        if (balance != that.balance) return false;
        if (isBlocked != that.isBlocked) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + (isBlocked ? 1 : 0);
        return result;
    }
}

