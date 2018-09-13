package com.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.connect.util.PageInfo;
import com.dao.imple.DaoImple;
import com.dao.inter.CategoryDAO;
import com.vo.Category;
public class Test {
//	public static void main(String[] args) {
//		int[] array = new int[6];
//		int a = (int)(Math.random()*23);
//		array[0]=a;
//		for(int i=1;i<=23;i++){
//			int b = (int)(Math.random()*23);
//			
//		}
//		
//		
//		System.out.println(a);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String name;
	private String ps;

	
	
	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + ", ps=" + ps + "]";
	}

	public static void main(String[] args) {
		CategoryDAO dao = new DaoImple();
		List<Category> listCategory = dao.selectCategoryBySQL("select * from category");
		List<Category> temp = new <Category>ArrayList();
		for(int i =0;i<listCategory.size();i++){
			//取出每个商品的图片路径，并将绝对路径处理成相对路径
			String path = listCategory.get(i).getPsPath();
			
		}
		//String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
	}
	
	// TODO Auto-generated method stub
	public Object[] deleteSubString(String str1,String str2) {
		StringBuffer sb = new StringBuffer(str1);
		int delCount = 0;
		Object[] obj = new Object[2];
 
		while (true) {
			int index = sb.indexOf(str2);
			if(index == -1) {
				break;
			}
			sb.delete(index, index+str2.length());
			delCount++;
			
		}
		if(delCount!=0) {
			obj[0] = sb.toString();
			obj[1] = delCount;
		}else {
			//不存在返回-1
			obj[0] = -1;
			obj[1] = -1;
		}
		
		return obj;
	}
}
