package com.appspot.mydoctor.model.account;

import java.io.Serializable;

import org.slim3.datastore.Model;

import com.appspot.mydoctor.model.base.AccountModel;

@Model(schemaVersion = 1)
public class UserAccountModel extends AccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

}
