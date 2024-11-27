package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JsonUtility {

	public static Environment readJson(Env env)  {
		File jsonFile = new File(System.getProperty("user.dir") + "\\Config\\Config.json");
		FileReader jsonFileReader = null;
		try {
			jsonFileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Config config = gson.fromJson(jsonFileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
		

	}

}
