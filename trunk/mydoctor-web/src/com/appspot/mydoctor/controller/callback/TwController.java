package com.appspot.mydoctor.controller.callback;

import org.apache.commons.lang.StringUtils;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.model.TwitterAuthSessionModel;

public class TwController extends PcBaseController {

	@Override
	public Navigation run() throws Exception {
		String key = requestScope("key");
		if (StringUtils.isNotEmpty(key)) {
			TwitterAuthSessionModel authModel = Datastore.get(TwitterAuthSessionModel.class, Datastore.stringToKey(key));
			if (authModel != null) {

			}
		}
		return forward("tw.jsp");
	}
}
