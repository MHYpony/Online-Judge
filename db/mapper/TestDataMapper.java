package db.mapper;

import db.model.TestData;

public interface TestDataMapper {
	
     int deleteTestData(TestData testData);
     int insertTestData(TestData testData);
     TestData selectTestData(TestData testData);
    
     
}
