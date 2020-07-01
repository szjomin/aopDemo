package com.jm.modules.test.service.impl;

import org.springframework.stereotype.Service;

import com.jm.modules.test.service.TestService;


@Service
public class TestServiceImpl implements TestService {

	@Override
	public boolean test() {

		System.out.println("===============log test===============");

		return true;
	}

}
