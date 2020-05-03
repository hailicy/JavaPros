package club.imgurl.util.cos;

import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.CopyObjectResult;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.utils.IOUtils;

@Component
public class UploadMediaQcloudCos {

	@Value("${qcloud.cos.appid}")
	private long appId;
	@Value("${qcloud.cos.secretid}")
	private String secretId;
	@Value("${qcloud.cos.secretkey}")
	private String secretKey;
	@Value("${qcloud.cos.bucket}")
	private String bucketName;
	@Value("${qcloud.cos.region}")
	private String region;

	private static final Logger logger = LoggerFactory.getLogger(UploadMediaQcloudCos.class);

	/**
	 * 上传文件
	 * 
	 * @param cosPath
	 * @param bytes
	 * @return cosPath
	 */
	public String uploadFile(String cosPath, InputStream inputSteam) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			PutObjectResult putObjectResult = cosOperate.uploadFile(cosPath, inputSteam);
			if (putObjectResult != null && StringUtils.isNotBlank(putObjectResult.getETag())) {
				return cosPath;
			} else {
				throw new RuntimeException("文件上传到cos出现错误");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param cosPath
	 * @param bytes
	 * @return cosPath
	 */
	public String uploadFile(String cosPath, byte[] bytes) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			PutObjectResult putObjectResult = cosOperate.uploadFile(cosPath, bytes);
			if (putObjectResult != null && StringUtils.isNotBlank(putObjectResult.getETag())) {
				return cosPath;
			} else {
				throw new RuntimeException("文件上传到cos出现错误");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param cosPath
	 * @param localFile
	 * @return cosPath
	 */
	public String uploadFile(String cosPath, String localFile) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			PutObjectResult putObjectResult = cosOperate.uploadFile(localFile, cosPath);
			if (putObjectResult != null && StringUtils.isNotBlank(putObjectResult.getETag())) {
				return cosPath;
			} else {
				throw new RuntimeException("文件上传到cos出现错误");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param cosPath
	 * @return byte[]
	 */
	public byte[] downFile(String cosPath) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			COSObjectInputStream inputStream = cosOperate.downFile(cosPath);
			return IOUtils.toByteArray(inputStream);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param cosPath
	 */
	public void deleteObject(String cosPath) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			cosOperate.deleteObject(cosPath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceFilePath
	 *            旧的文件
	 * @param targetFilePath
	 *            新的文件
	 * @return targetFilePath 新的文件
	 */
	public String copyObject(String sourceFilePath, String targetFilePath) {
		try {
			CosOperate cosOperate = new CosOperate(appId, secretId, secretKey, region, bucketName);
			String buck = bucketName + "-" + String.valueOf(appId);
			CopyObjectResult copyObjectResult = cosOperate.copyObject(buck, sourceFilePath, buck, targetFilePath);
			if (copyObjectResult != null && StringUtils.isNotBlank(copyObjectResult.getETag())) {
				return targetFilePath;
			} else {
				throw new RuntimeException("cos文件复制出现错误");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
