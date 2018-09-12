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

//����GoodDao�е����з���
public class SecondTest {
	static protected GoodDao goodDao;
	static protected Page page;
	static protected DatabaseDao databaseDao;

	// ����ִ�У�������@test����֮ǰִ�У�������ִֻ��һ�Σ����@Testִֻ��һ��
	@BeforeClass
	static public void beforeClass() throws Exception {
		goodDao = new GoodDao();
		page = new Page();
		databaseDao = new DatabaseDao();
	}

	// ���ִ�У�������@test����֮��ִ�У�������ִֻ��һ�Σ����@Testִֻ��һ��
	@AfterClass
	static public void AfterClass() throws Exception {
		databaseDao.close();
	}

	@Test
	public void testCount() throws Exception {
		int count = goodDao.count(page, databaseDao);
		// �������ݿ�����12������
		assertEquals(count, 12);
	}

	@Test
	public void testListAll() throws Exception {
		List<Good> goodList = goodDao.listAll(databaseDao);
		// �������ݿ�����12������
		assertNotNull(goodList);
	}

	@Test
	public void testGetPage() throws Exception {
		page.setPage(1);
		page.setPageSize(2);
		// �������ݿ�����12������
		page.setTotalrecord(12);
		List<Good> goodList = goodDao.getPage(page, databaseDao);
		assertEquals(new Integer(goodList.size()), page.getPageSize());
	}
}