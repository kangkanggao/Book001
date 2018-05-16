package com.highlion.service.impl;

import java.util.List;

import com.highlion.dao.BookAllTypesDao;
import com.highlion.dao.impl.BookAllTypesDaoImpl;
import com.highlion.domain.TypeVO;
import com.highlion.service.BookAllTypesService;

public class BooKAllTypesService implements BookAllTypesService {
    BookAllTypesDao batd=new BookAllTypesDaoImpl();
	@Override
	public List<TypeVO> findAllTypes() {
	
		return batd.findAllTypes();
	}

}
