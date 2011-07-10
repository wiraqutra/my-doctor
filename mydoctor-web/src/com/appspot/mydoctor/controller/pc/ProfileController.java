package com.appspot.mydoctor.controller.pc;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.controller.base.PcLoginBaseController;

public class ProfileController extends PcLoginBaseController {

	protected Navigation execute() throws Exception {

		return forward("profile.jsp");
	}
}
