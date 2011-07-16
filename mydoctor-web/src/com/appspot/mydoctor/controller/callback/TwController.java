package com.appspot.mydoctor.controller.callback;

import org.apache.commons.lang.StringUtils;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.controller.base.PcBaseController;
import com.appspot.mydoctor.meta.TwitterAuthSessionModelMeta;
import com.appspot.mydoctor.model.TwitterAuthSessionModel;
import com.appspot.mydoctor.service.UserAccountService;

public class TwController extends PcBaseController {

	@Override
	public Navigation run() throws Exception {
		String verifier = requestScope("oauth_verifier");
		String sessionKey = requestScope("tid");
		if (StringUtils.isNotEmpty(sessionKey)) {
			TwitterAuthSessionModelMeta meta = TwitterAuthSessionModelMeta.get();
			TwitterAuthSessionModel tas = Datastore.query(meta).filter(meta.sessionKey.equal(sessionKey)).asSingle();
			if (tas != null) {
				UserAccountService uas = new UserAccountService();
				String skey = uas.createLoginSession(tas, verifier);
				requestScope("sessionKey", skey);
			}
		}
		return forward("callback/tw.jsp");
	}
}
