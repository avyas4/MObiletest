package dataProviders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;

public class JsonDataReader {
	/*
	################################################################################################################################
    Description: The function deserializes the Json to the generic class object 
    Example usage: To deserialize LoginDetails.json, the class having objects (to which it is to be converted) should have same name as json(LoginDetails.java)
    Argument: Pass the class as an argument
    ReturnType: The json is deserialized into class object which is of the data type generic and is returned by the function
	################################################################################################################################
    */	
	public static synchronized <T> T getTestDataFromJson(Class<T> testData) {
		String testDataFilePath="src/test/resources/testData/";
		String jsonFileName = null;
		Gson gson = new Gson();
        try {
        	//Get JSON file name as it should have the same name as testData class
        	jsonFileName=testData.getSimpleName()+".json";;
			return gson.fromJson(new FileReader(testDataFilePath+jsonFileName), testData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path:- "+testDataFilePath+jsonFileName);
		}
    }
}