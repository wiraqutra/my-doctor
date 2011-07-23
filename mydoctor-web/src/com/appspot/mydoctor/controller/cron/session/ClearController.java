package com.appspot.mydoctor.controller.cron.session;

import java.util.Date;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.mydoctor.controller.base.CronBaseController;
import com.appspot.mydoctor.meta.LoginSessionModelMeta;
import com.appspot.mydoctor.meta.TemporaryAccountModelMeta;
import com.appspot.mydoctor.meta.base.AuthSessionModelMeta;
import com.google.appengine.api.datastore.Key;

public class ClearController extends CronBaseController {

	@Override
	public Navigation run() throws Exception {

		Date now = new Date();
		LoginSessionModelMeta lsm = LoginSessionModelMeta.get();
		List<Key> lsmList = Datastore.query(lsm).filter(lsm.expireDate.lessThan(now)).asKeyList();
		if (lsmList != null && !lsmList.isEmpty()) {
			Datastore.deleteWithoutTxAsync(lsmList);
		}
		AuthSessionModelMeta asm = AuthSessionModelMeta.get();
		List<Key> asmList = Datastore.query(asm).filter(asm.expireDate.lessThan(now)).asKeyList();
		if (asmList != null && !asmList.isEmpty()) {
			Datastore.deleteWithoutTxAsync(asmList);
		}
		TemporaryAccountModelMeta tam = TemporaryAccountModelMeta.get();
		List<Key> tamList = Datastore.query(tam).filter(tam.expireDate.lessThan(now)).asKeyList();
		if (tamList != null && !tamList.isEmpty()) {
			Datastore.deleteWithoutTxAsync(tamList);
		}
		return null;
	}
}
