package com.appspot.mydoctor.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TokenModelTest extends AppEngineTestCase {

    private TokenModel model = new TokenModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
