package com.appspot.mydoctor.service.inquiry;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InquiryInputServiceTest extends AppEngineTestCase {

    private InquiryInputService service = new InquiryInputService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
