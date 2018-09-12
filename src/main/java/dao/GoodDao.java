package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabean.Good;
import tools.Page;
public class GoodDao {	
	public List<Good> getPage(Page page,DatabaseDao databaseDao)throws SQLException, Exception{		
		//计算总页数
		if(page.getTotalrecord() % page.getPageSize() ==0)// 如果是当前页码的整数倍
			page.setTotalPage( page.getTotalrecord() / page.getPageSize()); 
		else  // 如果最后还空余一页
			page.setTotalPage(  (int) Math.floor(page.getTotalrecord() / page.getPageSize())+1); 
					
		if(page.getTotalrecord() == null || page.getTotalrecord() == 0) 
			page.setTotalPage( 1); 		
		
		Integer from=(page.getPage()-1) * page.getPageSize() ;		
		String sql="select * from goods  limit "+from.toString()+","+page.getPageSize().toString();
		
		databaseDao.query(sql);
		List<Good> goodList=new ArrayList<Good>();
		while(databaseDao.next()){
			Good good=new Good();
			good.setName(databaseDao.getString("name"));
			good.setPrice(databaseDao.getDouble("price"));
			
			goodList.add(good);
		}		
		return goodList;		
	}
	
	//总记录数
	public Integer count(Page page,DatabaseDao databaseDao)throws SQLException, Exception{
		String strSQL = "select count(*) as recordcount from goods";
		databaseDao.query(strSQL);
		if (databaseDao.next()) 
			return databaseDao.getInt("recordcount");		
		return 0;
	}	
	
	public List<Good> listAll(DatabaseDao databaseDao)throws SQLException, Exception{
		String sql="select * from goods";
		databaseDao.query(sql);
		List<Good> goodList=new ArrayList<Good>();
		while(databaseDao.next()){
			Good good=new Good();
			good.setName(databaseDao.getString("name"));
			good.setPrice(databaseDao.getDouble("price"));	
			goodList.add(good);
			}		
			return goodList;		
		}
	}

