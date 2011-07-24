package com.appspot.mydoctor.model.account;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserAccountModelTest extends AppEngineTestCase {

    private UserAccountModel model = new UserAccountModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
