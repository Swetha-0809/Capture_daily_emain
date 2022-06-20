package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DataBaseConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseConnectApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Q2a_pageJDBCTemplate studentJDBCTemplate = (Q2a_pageJDBCTemplate)context.getBean("Q2a_pageJDBCTemplate");
	    String sql="select count(*) from q2a_posts where updated > '2022-05-02 00:00:00' or created > '2022-05-02 00:00:00'";;  
	    List<Q2a_pages> Q2a_pagess = studentJDBCTemplate.listq2a_pages(sql);
	    for(Q2a_pages s: Q2a_pagess){
	         System.out.print("Count  : " + s.getPageid());
	        
	      }
		
		String sql1="select count(*) from q2a_posts where updated > '2022-05-02 00:00:00' or created > '2022-05-02 00:00:00';";;
		Q2a_pagess = studentJDBCTemplate.listq2a_pages(sql1);
	    for(Q2a_pages s: Q2a_pagess){
	         System.out.print("Count  : " + s.getPageid());
	        
	      }
	    
	    String sql2="select count(*) from q2a_posts where acount>0 AND selchildid IS NULL";
		Q2a_pagess = studentJDBCTemplate.listq2a_pages(sql2);
	    for(Q2a_pages s: Q2a_pagess){
	         System.out.print("Count  : " + s.getPageid());
	        
	      }
	    String sql3="select count(*) from q2a_posts where title!='NULL' and acount=0";
		Q2a_pagess = studentJDBCTemplate.listq2a_pages(sql3);
	    for(Q2a_pages s: Q2a_pagess){
	         System.out.print("Count  : " + s.getPageid());
	        
	      }
		
	        
	      
	  	
	}

}
