package kh.lclass.db1.common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

	// @return : 저장한 파일명
	public Map<String, String> saveFile(MultipartFile multi, HttpServletRequest req) throws Exception {
		Map<String, String> result = null;
		String renameFilePath = null;
		String renameByTime = null;
		
		String realPath = req.getSession().getServletContext().getRealPath("");
		String savePath = "resources/upload";
		if(multi != null && !multi.equals("")) {
			result = new HashMap<String, String>();
			String originalFileName = multi.getOriginalFilename();
			
			File folder = new File(savePath);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			renameByTime = System.currentTimeMillis()+"_"+originalFileName;
			renameFilePath = savePath+"\\"+renameByTime;
			multi.transferTo(new File(savePath+"\\"+renameByTime));
			
			result.put("original", originalFileName);
			result.put("rename", renameByTime);
		}
		return result;
		
	}
}
