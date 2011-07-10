package com.appspot.mydoctor.controller.admin.collection;

import com.appspot.mydoctor.controller.base.PcBaseController;
import org.slim3.controller.Navigation;

public class QnaController extends PcBaseController {

    @Override
    public Navigation run() throws Exception {
        return forward("qna.jsp");
    }
}
