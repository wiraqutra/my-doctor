package com.appspot.mydoctor.model.oauth;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterAccessModelTest extends AppEngineTestCase {

    private TwitterAccessModel model = new TwitterAccessModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
