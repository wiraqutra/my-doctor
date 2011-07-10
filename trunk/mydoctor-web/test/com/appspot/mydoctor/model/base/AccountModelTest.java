package com.appspot.mydoctor.model.base;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AccountModelTest extends AppEngineTestCase {

    private AccountModel model = new AccountModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
