package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountType", schema = "RIVER")
public class AccountType implements Serializable{

    private Long accTypeID;
    private String mnemonic;
    private String AccountTypeName;
    private LocalDate DateCreated;

    private Set<AccountTransaction> AccountTransaction;

    public AccountType()
    {

    }

    public AccountType(long accTypeID, String mnemonic, String AccountTypeName, LocalDate DateCreated)
    {
        this.accTypeID = accTypeID;
        this.mnemonic = mnemonic;
        this.AccountTypeName = AccountTypeName;
        this.DateCreated = DateCreated;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate DateCreated)
    {
        this.mnemonic = mnemonic;
        this.AccountTypeName = accountTypeName;

    }
    @Id
    @SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")
    @Column(name = "Account_Type_ID")
    public long getAccountID() {return accTypeID;}

    @Column(name = "AccountTypeName")
    public String getAccountTypeName(){return AccountTypeName;}

    @Column(name = "mnemonic")
    public String getMnemonic(){return mnemonic;};

    @Column(name = "creation_Date")
    public LocalDate getDateCreated(){return  DateCreated;}

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY,mappedBy = "accTypeID", orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction>getAccountTransaction()
    {
        return AccountTransaction;
    }

    public void setAccountTypeID(long accountTypeID)
    {
        this.accTypeID =accTypeID;
    }

    public void setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName)
    {
        this.AccountTypeName = accountTypeName;
    }

    public void setDateCreated(LocalDate DateCreated)
    {
        this.DateCreated = DateCreated;
    }


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
        AccountType that = (AccountType) o;
        return Objects.equals(mnemonic,that.mnemonic) && Objects.equals(AccountTypeName, that.AccountTypeName) && Objects.equals(DateCreated, that.DateCreated);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(accTypeID,mnemonic,AccountTypeName,DateCreated);
    }

    @Override
    public String toString()
    {
        return "AccountType{" +
                "accountTypeID ='"+ accTypeID + '\''+
                "mnemonic='" + mnemonic + '\'' +
                ",AccountTypeName='"+ AccountTypeName + '\'' +
                ", creation_Date=" + DateCreated +
                '}';
    }




}
