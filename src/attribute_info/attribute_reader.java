package attribute_info;

import java.io.FileInputStream;
import java.io.IOException;

import cp_info.cp_info;

public class attribute_reader {
	public static attribute_info read(FileInputStream FIS, cp_info[] constant_pool) throws IOException {
		return new attribute_info(FIS,constant_pool);
		
	}
}
