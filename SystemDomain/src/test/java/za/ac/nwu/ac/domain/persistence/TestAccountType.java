package za.ac.nwu.ac.domain.persistence;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAccountType {

    @Test
    public void getMnemonic() {
        AccountType accountType = new AccountType();
        assertNull(accountType.getMnemonic());

    }
}
