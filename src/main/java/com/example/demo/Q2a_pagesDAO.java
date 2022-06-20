package com.example.demo;

import java.util.List;

import javax.sql.DataSource;



public interface Q2a_pagesDAO {
	
	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<Q2a_pages> listq2a_pages(String sql);

}
