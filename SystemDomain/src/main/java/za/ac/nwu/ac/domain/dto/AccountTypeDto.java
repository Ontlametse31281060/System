package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;
import java.util.Objects;


public class AccountTypeDto {

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto()
    {

    }
    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate)
    {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate =creationDate;
    }
    public AccountTypeDto(AccountType accountType)
    {
        this.setAccountName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getDateCreated());
        this.setMnemonic(accountType.getMnemonic());
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    public void setAccountName(String accountTypeName)
    {
        this.accountTypeName = accountTypeName;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @ApiModelProperty(position = 1,
            value = "mnemonic",
            name = "mnemonic",
            notes = "This value identifies the account type",
            dataType = "String",
            example = "Cheque",
            required = true)
    public String getMnemonic() {return mnemonic;}

    @ApiModelProperty(position = 2,
            value = "AccountTypeName",
            name = "Name",
            notes = "This is the name of the type of the account",
            dataType = "String",
            example = "Gold Account",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {return accountTypeName;}

    @ApiModelProperty(position = 3,
            value = "CreationDate",
            name = "CreationDate",
            notes = "This is the date that the account was created",
            dataType = "LocalDate",
            example = "2000-01-21",
            allowEmptyValue = true,
            required = false)
    public LocalDate getCreationDate() {return creationDate;}


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic,that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName)&& Objects.equals(creationDate,that.creationDate);


    }

    public AccountType getAccountType() {
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mnemonic,accountTypeName,creationDate);
    }
    @Override
    public String toString()
    {
        return "AccountTypeDto{" +
                "mnemonic= '" +mnemonic+ '\''+
                ",accountTypeName= '" +accountTypeName+ '\''+
                ", creationDate=" + creationDate +
                '}';

    }


}


