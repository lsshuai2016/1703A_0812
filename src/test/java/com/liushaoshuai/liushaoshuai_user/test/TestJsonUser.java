package com.liushaoshuai.liushaoshuai_user.test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liushaoshuai.liushaoshuai_user.domain.User;
import com.liushaoshuai.liushaoshuai_user.utils.DateUtil;
import com.liushaoshuai.liushaoshuai_user.utils.RandomUitl;
import com.liushaoshuai.liushaoshuai_user.utils.StringUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class TestJsonUser {
	
	@Autowired
	private RedisTemplate<String,Serializable> redisTemplate;
	
	@Test
	public void testJson() throws ParseException {
		
		List<User> users = new ArrayList<User>();
		
		for(int i = 0 ; i < 100000 ; i++) {
			users.add(new User(i, StringUtil.generateChineseName()+StringUtil.randomChineseString(2), StringUtil.randomSex(), "13"+RandomUitl.randomString(9), RandomUitl.randomEmail(), DateUtil.randomDate(new SimpleDateFormat("yyyy-MM-dd").parse("1949-01-01")).toString()));
		}
		
		long startTimes = System.currentTimeMillis();
		for(User user : users) {
			redisTemplate.opsForValue().set("u_"+user.getId(), user);
		}
		long endTimes = System.currentTimeMillis();
		System.out.println("jdk序列化10万个对象需要时间:"+(endTimes-startTimes));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
