package com.appspot.mydoctor.controller;

import com.appspot.mydoctor.controller.base.PcBaseController;
import org.slim3.controller.Navigation;

public class MedicalController extends PcBaseController {

    @Override
    public Navigation run() throws Exception {
        return forward("medical.jsp");
    }
}
