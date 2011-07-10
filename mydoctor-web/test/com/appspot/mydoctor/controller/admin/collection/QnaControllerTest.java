package com.appspot.mydoctor.controller.admin.collection;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class QnaControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/collection/qna");
        QnaController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/collection/qna.jsp"));
    }
}
