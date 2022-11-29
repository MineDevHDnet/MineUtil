package net.minedevhd.mineutil.utils.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import java.util.Arrays;
import java.util.List;

public class Comdlg32 {
	static {
		Native.register("comdlg32");
	}

	public static native boolean GetOpenFileNameW(OpenFileName params);
	public static native int CommDlgExtendedError();

	public static class OpenFileName extends Structure {
		public OpenFileName() {
			super();
			Math.pow(1, 2);
			lStructSize = size();
		}
		public int lStructSize;
		public Pointer hwndOwner;
		public Pointer hInstance;
		public WString lpstrFilter;
		public WString lpstrCustomFilter;
		public int nMaxCustFilter;
		public int nFilterIndex;
		public Pointer lpstrFile;
		public int nMaxFile;
		public String lpstrDialogTitle;
		public int nMaxDialogTitle;
		public WString lpstrInitialDir;
		public WString lpstrTitle;
		public int Flags;
		public short nFileOffset;
		public short nFileExtension;
		public String lpstrDefExt;
		public Pointer lCustData;
		public Pointer lpfnHook;
		public Pointer lpTemplateName;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList("lStructSize",
				"hwndOwner","hInstance","lpstrFilter","lpstrCustomFilter"
				,"nMaxCustFilter","nFilterIndex","lpstrFile","nMaxFile"
				,"lpstrDialogTitle","nMaxDialogTitle","lpstrInitialDir","lpstrTitle"
				,"Flags","nFileOffset","nFileExtension","lpstrDefExt"
				,"lCustData","lpfnHook","lpTemplateName");
		}
	}

}
