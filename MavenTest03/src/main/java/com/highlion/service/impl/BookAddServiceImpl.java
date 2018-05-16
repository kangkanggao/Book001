package com.highlion.service.impl;

import com.highlion.dao.BookAddDao;
import com.highlion.dao.impl.BookAddDaoimpl;
import com.highlion.domain.BookVO;
import com.highlion.service.BookAddService;

public class BookAddServiceImpl implements BookAddService {
    BookAddDao bd=new BookAddDaoimpl();
	@Override
	public Boolean add(BookVO book) {
		// TODO Auto-generated method stub
		return bd.add(book);
	}

}
