package com.dao.inter;
import java.util.List;
import com.vo.Category;
//һ���ӿڣ��ӿ�����Ҫ�Ŷ����ݿ���ɾ�Ĳ�ķ��������ڱ��̳к�ʵ�ִ˽ӿ��е����з���
public interface CategoryDAO {
	//������Ʒ����ķ�����������������Ʒ��Ӱ�������
	public int addCategory(Category category);
	//ɾ����Ʒ������Ҳ����Ӱ�������
	public int deleteCategory(Category category);
	//�޸���Ʒ��Ϣ
	public int updateCategory(Category category);
	//ͨ��ID�鿴��Ʒ
	public Category selectCategoryById(int id);
	//ͨ��sql���鿴��Ʒ
	public List<Category> selectCategoryBySQL(String sql);
	//ͨ��sql����ѯ��Ʒ�ܼ�¼
	public int selectTotalRecordBySQL(String sql);
	//ͨ������id��ѯ�м�ֵ
	public List<Category> selectCategoryBy2Id(int id1,int id2);
	//ͨ����Ʒ���Ʋ�ѯ
	public List<Category> selectCategoryByName(String cname);
	//ͨ����Ʒ������ѯ
	public List<Category> selectCategoryByCdec(String cdec);
	//��ѯ����ĳһ��Id��������Ʒ
	public List<Category> selectCategoryByBigId(int id);
	//ͨ��Cid�޸�id
	public int updateCategoryById(int id);
}
