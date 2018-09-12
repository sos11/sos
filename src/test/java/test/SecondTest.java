package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import dao.DatabaseDao;
import dao.GoodDao;
import javabean.Good;
import tools.Page;

//测试GoodDao中的所有方法
public class SecondTest {
	static protected GoodDao goodDao;
	static protected Page page;
	static protected DatabaseDao databaseDao;

	// 首先执行（在所有@test方法之前执行），并且只执行一次，多个@Test只执行一次
	@BeforeClass
	static public void beforeClass() throws Exception {
		goodDao = new GoodDao();
		page = new Page();
		databaseDao = new DatabaseDao();
	}

	// 最后执行（在所有@test方法之后执行），并且只执行一次，多个@Test只执行一次
	@AfterClass
	static public void AfterClass() throws Exception {
		databaseDao.close();
	}

	@Test
	public void testCount() throws Exception {
		int count = goodDao.count(page, databaseDao);
		// 假设数据库中有12条数据
		assertEquals(count, 12);
	}

	@Test
	public void testListAll() throws Exception {
		List<Good> goodList = goodDao.listAll(databaseDao);
		// 假设数据库中有12条数据
		assertNotNull(goodList);
	}

	@Test
	public void testGetPage() throws Exception {
		page.setPage(1);
		page.setPageSize(2);
		// 假设数据库中有12条数据
		page.setTotalrecord(12);
		List<Good> goodList = goodDao.getPage(page, databaseDao);
		assertEquals(new Integer(goodList.size()), page.getPageSize());
	}
}