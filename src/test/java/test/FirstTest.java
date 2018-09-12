package test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import dao.DatabaseDao;
import dao.GoodDao;
import javabean.Good;
import tools.Page;

//����GoodDao�е����з�������ɫ�����Ϊjunit�Ĵ��롣GoodDao��3������������ڲ�������ҲҪд3������������ǰ������ע��@test��junit�Ĳ���ע�����¼1�����ֱ����ڲ���GoodDao��3������
public class FisrtTest {	
	@Test
	public void testCount() throws Exception {
		GoodDao goodDao=new GoodDao();
		Page page=new Page();
		DatabaseDao databaseDao=new DatabaseDao();
		
		int count=goodDao.count(page, databaseDao);
		//�������ݿ�����12�����ݣ�assertEquals��junit�ṩ�������ж� ʵ��ֵ �� ����ֵ �Ƿ���ȵĶ��ԣ�junit�����������ԣ��μ���¼2��ٶ�
		assertEquals(count,12);				
	}
	
	@Test
	public void testListAll() throws Exception {
		GoodDao goodDao=new GoodDao();
		DatabaseDao databaseDao=new DatabaseDao();
		
		List<Good> goodList=goodDao.listAll(databaseDao);
		//�������ݿ�����12������
		assertNotNull(goodList);				
	}	
	
	@Test
	public void testGetPage() throws Exception {
		GoodDao goodDao=new GoodDao();
		Page page=new Page();
		page.setPage(1);
		page.setPageSize(2);
		//�������ݿ�����12������
		page.setTotalrecord(12);
		DatabaseDao databaseDao=new DatabaseDao();		
		List<Good> goodList=goodDao.getPage(page,databaseDao);		
		assertEquals(new Integer(goodList.size()),page.getPageSize());				
	}		

}