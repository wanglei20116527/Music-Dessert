package com.MusicDessert.DAOTest;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.MusicDessert.DAO.implement.MusicDAO;
import com.MusicDessert.ORM.MdMusic;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:I:/java workspace/MusicDessert_Software/WebRoot/WEB-INF/applicationContext.xml"})
public class MusicDAOTest {

	@Test
	public void getMusicsByByCategoryID(){
		try{
			MusicDAO musicDAO = new MusicDAO();
			Integer categoryID = 100;
			List<MdMusic> musics = musicDAO.getMusicsByCategoryID(categoryID);
			Assert.notNull(musics);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
