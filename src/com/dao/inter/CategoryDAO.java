package com.dao.inter;
import java.util.List;
import com.vo.Category;
//一个接口，接口中主要放对数据库增删改查的方法，用于被继承和实现此接口中的所有方法
public interface CategoryDAO {
	//增加商品种类的方法，他返回增加商品受影响的行数
	public int addCategory(Category category);
	//删除商品，返回也是受影响的行数
	public int deleteCategory(Category category);
	//修改商品信息
	public int updateCategory(Category category);
	//通过ID查看商品
	public Category selectCategoryById(int id);
	//通过sql语句查看商品
	public List<Category> selectCategoryBySQL(String sql);
	//通过sql语句查询商品总记录
	public int selectTotalRecordBySQL(String sql);
	//通过两个id查询中间值
	public List<Category> selectCategoryBy2Id(int id1,int id2);
	//通过商品名称查询
	public List<Category> selectCategoryByName(String cname);
	//通过商品描述查询
	public List<Category> selectCategoryByCdec(String cdec);
	//查询大于某一个Id的所有商品
	public List<Category> selectCategoryByBigId(int id);
	//通过Cid修改id
	public int updateCategoryById(int id);
}
