package com.appspot.mydoctor.model.inquiry;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InquiryDataPackModelTest extends AppEngineTestCase {

    private InquiryDataPackModel model = new InquiryDataPackModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
