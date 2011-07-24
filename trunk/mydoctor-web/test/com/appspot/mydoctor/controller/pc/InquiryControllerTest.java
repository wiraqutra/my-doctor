package com.appspot.mydoctor.controller.pc;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InquiryControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/pc/inquiry");
        InquiryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/pc/inquiry.jsp"));
    }
}
