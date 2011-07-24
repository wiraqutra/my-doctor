package com.appspot.mydoctor.model.inquiry;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AnswerDataModelTest extends AppEngineTestCase {

    private AnswerDataModel model = new AnswerDataModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
