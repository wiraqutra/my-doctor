package com.appspot.mydoctor.controller;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.controller.base.PcLoginBaseController;

public class MedicalController extends PcLoginBaseController {

	@Override
	protected Navigation execute() throws Exception {
		return forward("medical.jsp");
	}
}
