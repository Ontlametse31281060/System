package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Embeddable
@Table(name = "Acc_Transaction", schema = "James")
public class AccountTransaction implements Serializable{

    private static final long serialID = 563847899;

    private LocalDate TransDate;
    private long AccTypeID;
    private long TransID;
    private long MembershipID;
    private long Amount;

    public AccountTransaction()
    {

    }

    public AccountTransaction (long TransID, LocalDate TransDate, long AccTypeID, long MembershipID, long Amount)
    {
        this.TransID = TransID;
        this.TransDate = TransDate;
        this.AccTypeID = AccTypeID;
        this.MembershipID = MembershipID;
        this.Amount = Amount;
    }

    @Id
    @SequenceGenerator(name = "System_sequence", sequenceName = "System_SEQ", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "Gen.System_SEQ")

    @Column(name = "TransID")
    public Long getTransID(){return TransID;}

    @Column(name = "TransDate")
    public LocalDate getTransDate(){return TransDate;}

    @Column(name = "AccType")
    public Long getAccTypeID(){return AccTypeID;}

    @Column(name = "MembershipID")
    public Long getMembershipID(){return MembershipID;}

    @Column(name = "Amount")
    public Long getAmount(){return Amount;}


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccTypeID")
    public long getAccountID(){return AccTypeID;}

    public void setTransID(long TransID){this.TransID = TransID;}
    public void setTransDate(LocalDate TransDate){this.TransDate = TransDate;}
    public void setAccTypeID(long AccTypeID){this.AccTypeID = AccTypeID;}
    public void setMembershipID(long MembershipID){this.MembershipID = MembershipID;}
    public void setAmount(long Amount){this.Amount = Amount;}

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
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(TransID,that.TransID) && Objects.equals(AccTypeID, that.AccTypeID) && Objects.equals(MembershipID, that.MembershipID) && Objects.equals(Amount, that.Amount) && Objects.equals(TransDate, that.TransDate);

    }


    @Override
    public String toString()
    {
        return "AccountTransaction{" +
                "TransactionID ='" + TransID + '\''+
                "TransactionDate ='" + TransDate + '\''+
                "AccountTypeID ='" + AccTypeID + '\''+
                "MembershipID ='" + MembershipID + '\''+
                "Amount ='" + Amount + '\''+
                '}';
    }

}
