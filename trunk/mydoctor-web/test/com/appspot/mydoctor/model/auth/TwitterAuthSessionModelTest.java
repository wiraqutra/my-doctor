package com.appspot.mydoctor.model.auth;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterAuthSessionModelTest extends AppEngineTestCase {

    private TwitterAuthSessionModel model = new TwitterAuthSessionModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
