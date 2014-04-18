package com.MusicDessert.Service.implement;

import java.util.List;

import com.MusicDessert.DAO.implement.MdRecommandedmusicDAO;
import com.MusicDessert.ORM.MdRecommandedmusic;

public class Recommandedmusic implements
		com.MusicDessert.Service.Recommandedmusic {
	
	private MdRecommandedmusicDAO recommandedmusicDAO;
	
	public void setRecommandedmusicDAO(MdRecommandedmusicDAO recommandedmusicDAO) {
		this.recommandedmusicDAO = recommandedmusicDAO;
	}

	@Override
	public List<MdRecommandedmusic> getAllRecommandedmusics() {
		return this.recommandedmusicDAO.findAllRecommandedmusics();
	}

}
