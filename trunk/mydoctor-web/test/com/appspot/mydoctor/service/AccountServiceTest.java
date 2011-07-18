package com.appspot.mydoctor.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AccountServiceTest extends AppEngineTestCase {

    private AccountService service = new AccountService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
