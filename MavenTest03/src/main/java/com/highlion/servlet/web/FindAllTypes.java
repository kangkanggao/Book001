package com.highlion.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highlion.domain.TypeVO;
import com.highlion.service.BookAllTypesService;
import com.highlion.service.impl.BooKAllTypesService;

@WebServlet("/findAllTypes")
public class FindAllTypes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            BookAllTypesService bats=new BooKAllTypesService();
            List<TypeVO>list=bats.findAllTypes();
            response.setCharacterEncoding("utf-8");
	        response.getWriter().write("<script>");
			String js="[";
			for (int i=0;i<list.size();i++) {
				js+="{id:"+list.get(i).getid()+",name:'"+list.get(i).getName()+"'}";
				if (i<list.size()-1) {
					js+=",";
				}
			}
			js+="]";
			//fillSel在父窗口定义，要告诉到父窗口找
			response.getWriter().write("window.parent.fillSel("+js+");");
			response.getWriter().write("</script>");
	}
}
