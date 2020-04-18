package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u1;
import javaDisassembly.u2;

public class CONSTANT_MethodHandle_Info extends cp_info {
	public static final String[] possible_kinds = {"REF_getField","REF_putField","REF_invokeVirtual","REF_invokeStatic","REF_invokeSpecial","REF_newInvokeSpecial","REF_invokeInterface"};
	public u1 reference_kind;
	public String reference_kind_str;
    public u2 reference_index;
	public CONSTANT_MethodHandle_Info(FileInputStream FIS) throws IOException {
		this.reference_kind  = new u1(FIS);
		this.reference_kind_str = possible_kinds[reference_kind.d - 1];
		this.reference_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_MethodHandle : ref = " + reference_kind.d + " ("  + reference_kind_str +  ") ri=" + reference_index.d;
	}
}
