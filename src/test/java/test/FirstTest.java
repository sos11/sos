package test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import dao.DatabaseDao;
import dao.GoodDao;
import javabean.Good;
import tools.Page;

//测试GoodDao中的所有方法，红色字体的为junit的代码。GoodDao有3个方法，因此在测试类中也要写3个方法（方法前必须有注解@test，junit的部分注解见附录1），分别用于测试GoodDao的3个方法
public class FisrtTest {	
	@Test
	public void testCount() throws Exception {
		GoodDao goodDao=new GoodDao();
		Page page=new Page();
		DatabaseDao databaseDao=new DatabaseDao();
		
		int count=goodDao.count(page, databaseDao);
		//假设数据库中有12条数据，assertEquals是junit提供的用于判断 实际值 与 期望值 是否相等的断言，junit还有其他断言，参见附录2或百度
		assertEquals(count,12);				
	}
	
	@Test
	public void testListAll() throws Exception {
		GoodDao goodDao=new GoodDao();
		DatabaseDao databaseDao=new DatabaseDao();
		
		List<Good> goodList=goodDao.listAll(databaseDao);
		//假设数据库中有12条数据
		assertNotNull(goodList);				
	}	
	
	@Test
	public void testGetPage() throws Exception {
		GoodDao goodDao=new GoodDao();
		Page page=new Page();
		page.setPage(1);
		page.setPageSize(2);
		//假设数据库中有12条数据
		page.setTotalrecord(12);
		DatabaseDao databaseDao=new DatabaseDao();		
		List<Good> goodList=goodDao.getPage(page,databaseDao);		
		assertEquals(new Integer(goodList.size()),page.getPageSize());				
	}		

}