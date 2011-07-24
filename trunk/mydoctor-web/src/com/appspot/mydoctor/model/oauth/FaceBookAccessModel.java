package com.appspot.mydoctor.model.oauth;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelRef;
import org.slim3.datastore.Model;

import com.appspot.mydoctor.model.base.AccountModel;
import com.appspot.mydoctor.model.base.OAuthAccessModel;

@Model(schemaVersion = 1)
public class FaceBookAccessModel extends OAuthAccessModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(persistent = false)
	private InverseModelRef<AccountModel, FaceBookAccessModel> accountModelRef = new InverseModelRef<AccountModel, FaceBookAccessModel>(AccountModel.class, "facebookAccessModelRef", this);

	public InverseModelRef<AccountModel, FaceBookAccessModel> getAccountModelRef() {
		return accountModelRef;
	}

}
