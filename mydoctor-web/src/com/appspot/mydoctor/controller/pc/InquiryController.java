package com.appspot.mydoctor.controller.pc;

import com.appspot.mydoctor.controller.base.PcBaseController;
import org.slim3.controller.Navigation;

public class InquiryController extends PcBaseController {

    @Override
    public Navigation run() throws Exception {
        return forward("inquiry.jsp");
    }
}