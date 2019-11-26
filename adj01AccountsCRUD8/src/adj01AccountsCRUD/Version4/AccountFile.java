package adj01AccountsCRUD.Version4;

import java.io.File;
import java.nio.file.Path;

public class AccountFile {

	public static String enterFilePath() {
		// 1. enter file path
		// 2. if filePath is invalid print error 
		// 3. repeat steps 1 and 2 until filePath is valid
		
		String filePath ="C:\\Users\\Marcial\\Documents\\javaxxx";
		File files = new File(filePath);
		if (!files.exists()) {
			System.out.println("File path does not exist");
		} else {
			System.out.println("File path exist");
		}
		return filePath;
	}


}
