package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.Vector;

import org.junit.Test;

import PictureAction.SearchPicture;

public class TestPicture {

	private String mPath = "F:\\picture";

	@Test
	public void testPicture() { // 测试文件收索方法
		Vector<String> pictures = SearchPicture.SearchPName("C:\\Users\\lin\\Pictures");// ("c:"+System.getProperty("file.separator")
		Vector<String> picturesPath = SearchPicture.SearchPPath("C:\\Users\\lin\\Pictures");
		// +"Pictures");
		File file = new File("D:\\Mypicture");
		String writePath = "D:\\Mypicture\\";
		String readPath = "C:\\Users\\lin\\Pictures\\";
		for (String fileName : pictures) { // 这里的fileName其实是绝对路径
			File f = new File(fileName.toString());
			System.out.println(fileName);
			// save(readPath + fileName, writePath + fileName);
		}
		for (String fileName : picturesPath) { // 这里的fileName其实是绝对路径
			File f = new File(fileName.toString());
			System.out.println(fileName);
			// save(readPath + fileName, writePath + fileName);
		}
	}

	@Test
	public void testPath() throws IOException { // 测试获取对象数组

		DirectoryStream<Path> paths = SearchPicture.GetPath(mPath);

		for (Path p : paths) {
			System.out.println(p.toString() + "-----" + p.getFileName().toString());
		}
	}

	@Test
	public void testGetAllFile() throws IOException {

		DirectoryStream<Path> paths = SearchPicture.getAllfile(mPath);
		System.out.println("显示图片scssccscs！");
		
			for (Path p : paths) {
				System.out.println(p.toString() + "-----" + p.getFileName().toString());
			
		}
	}

}
