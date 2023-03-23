package com.jpaul.pointofsale;

import com.jpaul.pointofsale.dao.DAOManager;
import com.jpaul.pointofsale.model.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PointofsaleApplication {

	public static void main(String[] args) {
		/*DAOManager daoManager = new DAOManager();
		try{
			Category category = new Category();
			//category.setIdCategory(4);
			category.setName("les");
			//category.setIdCatalogStatus(1);
			System.out.println(daoManager.getDAOCategory().search(category).toString());
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		*/

		SpringApplication.run(PointofsaleApplication.class, args);
	}

}
