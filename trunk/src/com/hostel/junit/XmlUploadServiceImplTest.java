package com.hostel.junit;

import com.hostel.service.impl.XmlUploadServiceImpl;

import junit.framework.TestCase;

public class XmlUploadServiceImplTest extends TestCase {

	String s;
	XmlUploadServiceImpl xmlUploadServiceImpl;

	public void setUp() throws Exception {
		s = "my_file";
		xmlUploadServiceImpl = new XmlUploadServiceImpl();
	}

	public void testUploadXmlByPath() {
		String res = xmlUploadServiceImpl.uploadXmlByPath(s);
		assertEquals("This message is not going to be used", res);
	}

}
