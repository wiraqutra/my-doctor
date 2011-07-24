package com.appspot.mydoctor.model.oauth;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FaceBookAccessModelTest extends AppEngineTestCase {

    private FaceBookAccessModel model = new FaceBookAccessModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
