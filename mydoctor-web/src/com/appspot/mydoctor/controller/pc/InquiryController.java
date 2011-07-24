package com.appspot.mydoctor.controller.pc;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.meta.inquiry.InquiryModelMeta;
import com.appspot.mydoctor.model.inquiry.AnswerSessionModel;
import com.appspot.mydoctor.model.inquiry.InquiryDataPackModel;
import com.appspot.mydoctor.model.inquiry.InquiryModel;
import com.appspot.mydoctor.util.RequestUtil;

public class InquiryController extends PcBaseController {

	private static Integer ROW_NUM = 2;
	private Integer step;
	private String answerSessionKey;
	private AnswerSessionModel answerSession;

	@Override
	public Navigation run() throws Exception {

		this.step = RequestUtil.getInt((String) requestScope("step"), 0);
		this.answerSessionKey = requestScope("answerSessionKey");
		if (StringUtils.isNotEmpty(answerSessionKey)) {
			answerSession = Datastore.get(AnswerSessionModel.class, Datastore.stringToKey(answerSessionKey));
		} else {
			answerSession = new AnswerSessionModel();
			answerSession.setKey(Datastore.put(answerSession));

		}

		InquiryModelMeta meta = InquiryModelMeta.get();
		InquiryModel model = Datastore.query(meta).filter(meta.inquiryCode.equal("AA")).asSingle();
		List<InquiryDataPackModel> list = model.getInquiryDataPackListRef().getModelList();
		requestScope("inquiry", model);
		requestScope("step", step);
		requestScope("answerSessionKey", Datastore.keyToString(answerSession.getKey()));
		return forward("inquiry.jsp");
	}

}
