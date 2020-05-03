package club.imgurl.util.cos;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UploadMedia {

	@Autowired
	private UploadMediaQcloudCos uploadMediaQcloudCos;

	public String uploadFile(String cosPath, InputStream inputSteam) {
		return uploadMediaQcloudCos.uploadFile(cosPath, inputSteam);
	}

	public String uploadFile(String cosPath, byte[] bytes) {
		return uploadMediaQcloudCos.uploadFile(cosPath, bytes);
	}

	public String uploadFile(String cosPath, String localFile) {
		return uploadMediaQcloudCos.uploadFile(cosPath, localFile);
	}

	public byte[] downFile(String cosPath) {
		return uploadMediaQcloudCos.downFile(cosPath);
	}

	public void deleteObject(String cosPath) {
		uploadMediaQcloudCos.deleteObject(cosPath);
	}

	public String copyObject(String sourceFilePath, String targetFilePath) {
		return uploadMediaQcloudCos.copyObject(sourceFilePath, targetFilePath);
	}
}
