package com.appspot.mydoctor.service.inquiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.appspot.mydoctor.model.inquiry.AnswerDataModel;

public class InquiryInputService {

	public void addInquiryData(Map<String, AnswerDataModel> resultMap, Integer questionNumber, List<AnswerDataModel> answer) {

	}

	public List<String> getQuestionNameList(Integer step, Integer rownum) {
		List<String> result = new ArrayList<String>();
		int start = step * rownum + 1;
		for (int i = 0; i < rownum; i++) {
			result.add("q" + Integer.toString(start + i));
		}
		return result;
	}
}
