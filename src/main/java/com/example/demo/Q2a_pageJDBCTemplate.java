package com.example.demo;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.GetMapping;

public class Q2a_pageJDBCTemplate implements Q2a_pagesDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

@Override
@GetMapping(path = "/q2a_pages")
public List<Q2a_pages> listq2a_pages(String sql) {
	 String SQL = sql;//"select count(*) from q2a_posts where updated > '2022-05-02 00:00:00' or created > '2022-05-02 00:00:00'";//"select * from q2a_pages";
     List <Q2a_pages> students = jdbcTemplateObject.query(SQL, 
        new ResultSetExtractor<List<Q2a_pages>>(){
        public List<Q2a_pages> extractData(ResultSet rs) throws SQLException, DataAccessException {
           List<Q2a_pages> list = new ArrayList<Q2a_pages>();  
           while(rs.next()){  
        	   Q2a_pages Q2a_page = new Q2a_pages();
           	//q2a_pages_obj.setPageid(rs.getInt("id"));
        	   Q2a_page.setPageid(rs.getInt(1));
           /*	Q2a_page.setPageid(rs.getInt("pageid"));
           	Q2a_page.setTitle(rs.getString("title"));
           	Q2a_page.setNav(rs.getString("nav"));
           	Q2a_page.setPosition(rs.getInt("position"));
           	Q2a_page.setFlags(rs.getInt("flags"));
           	Q2a_page.setPermit(rs.getInt("permit"));
           	Q2a_page.setTags(rs.getString("tags"));
           	Q2a_page.setHeading(rs.getString("heading"));
           	Q2a_page.setContent(rs.getString("content"));*/
              list.add(Q2a_page);  
           }
           return list;  
        }    	  
     });
     return students;
  }
}