package com.appspot.mydoctor.model.inquiry;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.Sort;

import com.appspot.mydoctor.enumeration.InquiryTypeEnum;
import com.appspot.mydoctor.meta.inquiry.AnswerDataModelMeta;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;

@Model(schemaVersion = 1)
public class InquiryDataPackModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	private String packageCode;
	private String questionTitle;
	private Integer questionNumber;
	private InquiryTypeEnum inquiryType;

	private ModelRef<InquiryModel> inquiryModelRef = new ModelRef<InquiryModel>(InquiryModel.class);

	// @Attribute(persistent = false)
	// private InverseModelRef<InquiryModel, InquiryDataPackModel>
	// inquiryModelRef = new InverseModelRef<InquiryModel,
	// InquiryDataPackModel>(InquiryModel.class, "inquiryDataPackRef", this);

	@Attribute(persistent = false)
	private InverseModelListRef<AnswerDataModel, InquiryDataPackModel> answerListRef = new InverseModelListRef<AnswerDataModel, InquiryDataPackModel>(AnswerDataModel.class, "inquiryDataPackRef",
			this, new Sort(AnswerDataModelMeta.get().questionNumber.getName(), SortDirection.ASCENDING), new Sort(AnswerDataModelMeta.get().id.getName(), SortDirection.ASCENDING));

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
		InquiryDataPackModel other = (InquiryDataPackModel) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public InverseModelListRef<AnswerDataModel, InquiryDataPackModel> getAnswerListRef() {
		return answerListRef;
	}

	public InquiryTypeEnum getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(InquiryTypeEnum inquiryType) {
		this.inquiryType = inquiryType;
	}

	public ModelRef<InquiryModel> getInquiryModelRef() {
		return inquiryModelRef;
	}

}
