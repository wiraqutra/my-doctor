package com.appspot.mydoctor.controller;

import com.appspot.mydoctor.controller.base.PcBaseController;
import org.slim3.controller.Navigation;

public class ContactController extends PcBaseController {

    @Override
    public Navigation run() throws Exception {
        return forward("contact.jsp");
    }
}
