package com.appspot.mydoctor.model.base;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.appspot.mydoctor.enumeration.OAuthServiceEnum;
import com.appspot.mydoctor.model.FacebookAccessModel;
import com.appspot.mydoctor.model.TwitterAccessModel;
import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class AccountModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	private String loginId;
	private String nickName;
	private String email;
	private String loginPasswordHash;
	private OAuthServiceEnum oauthType;

	private ModelRef<TwitterAccessModel> twitterAccessModelRef = new ModelRef<TwitterAccessModel>(TwitterAccessModel.class);

	private ModelRef<FacebookAccessModel> facebookAccessModelRef = new ModelRef<FacebookAccessModel>(FacebookAccessModel.class);

	/**
	 * Returns the key.
	 * 
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * Returns the version.
	 * 
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AccountModel other = (AccountModel) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OAuthServiceEnum getOauthType() {
		return oauthType;
	}

	public void setOauthType(OAuthServiceEnum oauthType) {
		this.oauthType = oauthType;
	}

	public String getLoginPasswordHash() {
		return loginPasswordHash;
	}

	public void setLoginPasswordHash(String loginPasswordHash) {
		this.loginPasswordHash = loginPasswordHash;
	}

	public ModelRef<TwitterAccessModel> getTwitterAccessModelRef() {
		return twitterAccessModelRef;
	}

	public ModelRef<FacebookAccessModel> getFacebookAccessModelRef() {
		return facebookAccessModelRef;
	}

}
