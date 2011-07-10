package com.appspot.mydoctor.controller.callback;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/callback/tw");
        TwController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/callback/tw.jsp"));
    }
}
