/*
 * Copyright (c) 2002-2012 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tim.test.login.module.screen.sss;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tim.test.login.module.vo.Person;

/**
 * Screen方法可带有返回值。
 * <p/>
 * 这个screen所返回的对象将被转换成json格式，并输出到用户浏览器。
 *
 * @author Michael Zhou
 */
public class Login {
	
	@Autowired
    private HttpServletRequest request;
    
    @Autowired
    private HttpServletResponse response;
    
    @Autowired
    private LoginService loginService;
    
    
    public Person execute() throws Exception {
    	String method = request.getParameter("method");
    	String userName = request.getParameter("userName");
//    	System.out.println((String)request.getAttribute("decompression"));
//    	System.out.println((String)request.getAttribute("decode"));
//    	byte[] newRequest = (byte[]) request.getAttribute("newRequest");
//    	System.out.println(new String(newRequest));
//    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/manager.xml");
    	
    	/** 测试路径的代码 */
//    	File file = new File("test.properties");
//		if(!file.exists()) {
//			file.createNewFile();
//			System.out.println("文件创立成功");
//		}
//		System.out.println("file的绝对路径" + file.getAbsolutePath());
    	
//    	LoginService loginService = (LoginService)context.getBean("loginService");
    	if ("login".equals(method)) {
    		loginService.excute();
    		return new Person(userName, 21);
		} else {
			return new Person("common", 21);
		}
    }
    
    /** 英文 */
    public Person doHandleLogin() {
    	String method = request.getParameter("method");
    	if ("login".equals(method)) {
    		return new Person(request.getParameter("method"), 21);
		} else {
			return new Person("common", 21);
		}
    }
    
    /** 英文 */
    public Person doEnglish() {
        return new Person(request.getParameter("method"), 21);
    }

    /** 中文 */
    public Hello doChinese() {
        return new Hello("Chinese", "你好");
    }

    /** 法语 */
    public Hello doFrench() {
        return new Hello("French", "Bonjour");
    }

    /** 西班牙语 */
    public Hello doSpanish() {
        return new Hello("Spanish", "Hola");
    }
    
    /** 怪兽语 */
    public Hello doMointer() {
    	return new Hello("xiaoguaishou", "guaishou");
    }

    public static class Hello {
        private String language;
        private String howToSay;

        public Hello(String language, String howToSay) {
            this.language = language;
            this.howToSay = howToSay;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getHowToSay() {
            return howToSay;
        }

        public void setHowToSay(String howToSay) {
            this.howToSay = howToSay;
        }
    }
}

