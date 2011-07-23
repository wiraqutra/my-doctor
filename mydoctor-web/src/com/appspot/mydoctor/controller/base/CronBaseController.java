package com.appspot.mydoctor.controller.base;

import org.slim3.controller.Navigation;

import com.appspot.mydoctor.exception.InvalidArgumentException;

public abstract class CronBaseController extends BaseController {

	@Override
	protected String getJspDir() {
		throw new RuntimeException(new InvalidArgumentException());
	}

	@Override
	protected Navigation forward(String path) {
		throw new RuntimeException(new InvalidArgumentException());
	}

	@Override
	protected Navigation redirect(String path) {
		throw new RuntimeException(new InvalidArgumentException());
	}
}
