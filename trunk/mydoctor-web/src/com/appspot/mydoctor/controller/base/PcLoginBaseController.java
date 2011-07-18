package com.appspot.mydoctor.controller.base;

import org.apache.commons.lang.StringUtils;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.meta.LoginSessionModelMeta;
import com.appspot.mydoctor.model.LoginSessionModel;
import com.appspot.mydoctor.util.UrlUtil;

public abstract class PcLoginBaseController extends PcBaseController {

	private LoginSessionModel loginSession;

	@Override
	protected final Navigation run() throws Exception {
		String requestURL = UrlUtil.getRequestURL(request);
		String sid = requestScope("sid");
		if (StringUtils.isEmpty(sid)) {
			return redirect("/pc/login?ret=" + requestURL);
		}
		LoginSessionModelMeta meta = LoginSessionModelMeta.get();
		loginSession = Datastore.query(meta).filter(meta.sessionKey.equal(sid)).asSingle();
		if (loginSession == null || loginSession.getUserAccountModelRef().getModel() == null) {
			return redirect("/pc/login?ret=" + requestURL);
		}
		return execute();
	}

	protected abstract Navigation execute() throws Exception;
}
