package com.xiajw.tess4j.program;

import java.io.File;
import java.util.Scanner;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestOcr {

	public static void main(String[] args) {
		System.out.print("please input image path:");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		File file = new File(path);
		if(!file.exists()) {
			System.err.println("file not exist!");
			scanner.close();
			return;
		}
		System.out.print("please setLanguage(eng/chi_sim):");
		String language = scanner.nextLine();
		scanner.close();
		if(!("chi_sim".equals(language) || "eng".equals(language))) {
			System.err.println("language must be chi_sim or eng!");
			return;
		}
		ITesseract instance = new Tesseract();
		instance.setDatapath(System.getProperty("user.dir") + "\\tessdata"); // 语言库位置
		instance.setLanguage(language);// chi_sim:简体中文,eng:英文
		String result = null;
		try {
			result = instance.doOCR(file);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		System.out.println("result: ");
		System.out.println(result);
	}

}
