package za.ac.nwu.ac.Logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.Translator.impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.Logic.flow.impl.CreateAccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountType   {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlowImpl.class);

    private final AccountTranslator accountTranslator;

    public CreateAccountTypeFlowImpl(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }



    @Override
    public AccountTypeDto create(AccountTypeDto accountType)
    {
        LOGGER.info("This create Object{}",accountType);

        if (null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
            LOGGER.info("The account was created on this date{}", accountType.getCreationDate());
        }
        AccountTypeDto results = accountTranslator.create(accountType);
        LOGGER.info("The results of creation Date{}", results);
        return results;
    }
}
