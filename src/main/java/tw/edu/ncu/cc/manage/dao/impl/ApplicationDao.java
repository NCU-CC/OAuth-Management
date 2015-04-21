package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.converter.ApplicationConverter;

@Repository
public class ApplicationDao implements IApplicationDao {
	
	private static final Logger logger = Logger.getLogger(ApplicationDao.class);
	
	public static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	@Override
	public List<IdApplication> findAll(String userId) {
		List<IdApplication> applicationList = Collections.emptyList();
		try {
			String response = IOUtils.toString(new URL(USER_SERVICE_URL + userId + "/application"), "UTF-8");
			applicationList = ApplicationConverter.convetList(response);
		} catch (IOException e) {
			logger.info(e);
		}
		return applicationList;
	}
}
