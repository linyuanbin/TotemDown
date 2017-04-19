package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.hibernate.Session;
import org.junit.Test;

import PictureAction.SearchPicture;
import dao.PictureDao;
import daoimplement.PictureImplement;
import hibernateutil.SessionAnnotation;
import model.Picture;

public class TestPicture {

	private static PictureDao pd = new PictureImplement();
	private String mPath = "F:\\picture\\photo";// \\餐厅

	@Test
	public void testPicture() { // 测试文件收索方法
		Vector<String> pictures = SearchPicture.SearchPName("F:\\picture\\photo");// ("c:"+System.getProperty("file.separator")
		Vector<String> picturesPath = SearchPicture.SearchPPath("F:\\picture\\photo");
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
	public void testGetAllFile() throws IOException { // 从服务器读取

		DirectoryStream<Path> paths = SearchPicture.getAllfileFList(mPath);
		System.out.println("显示图片scssccscs！");

		for (Path p : paths) {
			System.out.println(p.toString() + "-----" + p.getFileName().toString());

		}
	}

	@Test
	public void testGetAPicture() { // 从数据库获得

		/*Set<Picture> Pictures = new HashSet<Picture>();
		System.out.println("查找");
		Pictures = pd.selectAllPicture();
		System.out.println("------picture" + Pictures);
		for (Picture p : Pictures) {
			System.out.println(p.getPName());
		}*/
		 
//		Picture p=pd.selectSinglePictureFN("餐厅");
//		System.out.println(p.getPAddress());

		/*Set<Picture> Pictures = new HashSet<Picture>(); //名字相似查找 成功
		System.out.println("查找");
		Pictures = pd.selectPicturesFN("餐厅");
		System.out.println("------picture" + Pictures);
		for (Picture p : Pictures) {
			System.out.println(p.getPName());
		}*/
		
		/*
		 * Session s = SessionAnnotation.getSession(); s.beginTransaction();
		 * String sql = "select PID from Picture"; List<String> list =
		 * (List<String>) s.createQuery(sql).list();
		 * s.getTransaction().commit(); for (String li : list) {
		 * s.beginTransaction(); Picture p = (Picture) s.get(Picture.class, li);
		 * s.getTransaction().commit(); System.out.println(p.getPName());
		 * System.out.println(li); }
		 */

	}
	
	@Test
	public void selectAllPictureOnDB(){
		Set<Picture> pictures= pd.selectPicturesFM("餐"); //pd.selectAllPicture();
		for(Picture p:pictures){
			System.out.println(p.getPAddress()+" "+p.getMarkName());
		}
	}
	

}
