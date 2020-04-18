package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u4;

public class CONSTANT_Long_Info extends cp_info {
	public u4 high;
	public u4 low;
	public long value;
	public CONSTANT_Long_Info(FileInputStream FIS) throws IOException {
		this.high = new u4(FIS);
		this.low = new u4(FIS);
		this.value = ((long) high.d << 32) + low.d;
	}
	public String toString() {
		return "CONSTANT_Long : high = " + high.d + "low : " + low.d + "value:" + value;
	}
}
