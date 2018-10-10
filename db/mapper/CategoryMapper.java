package db.mapper;

import db.model.Category;

public interface CategoryMapper {
	int updateCategory(Category category);
	int deleteCategory(Category category);
	int insertCategory(Category category);
	Category selectCategory(Category category);//only one Category will be select

}
