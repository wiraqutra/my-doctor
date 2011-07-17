package com.appspot.mydoctor.util;

import java.util.ConcurrentModificationException;

import org.apache.commons.lang.RandomStringUtils;

import com.appspot.mydoctor.exception.TimeoutException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

public class UniqueEntityUtil {
	public static boolean isUnique(String kindName, String value) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey(kindName, value);
		Transaction tx = ds.beginTransaction();
		try {
			ds.get(tx, key);
			// 既にエントリが存在する
			return false;
		} catch (EntityNotFoundException e) {
			// 見つからなかったのでputする
			Entity entity = new Entity(key);
			try {
				ds.put(tx, entity);
				tx.commit();
				// ユニークな値が確保できた
				return true;
			} catch (ConcurrentModificationException e2) {
				// getしてからcommitする間に他の誰かがputしている場合は例外になる
				if (tx.isActive()) {
					tx.rollback();
				}
				return false;
			}
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}

	public static String getSessionKey(String kindName, int length) throws TimeoutException {
		String sessionKey = RandomStringUtils.randomAlphanumeric(length);
		int i = 0;
		while (!isUnique(kindName, sessionKey)) {
			sessionKey = RandomStringUtils.randomAlphanumeric(length);
			i++;
			if (i > 10) {
				throw new TimeoutException();
			}
		}
		return sessionKey;
	}

}
