package club.imgurl.util.cos;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.CopyObjectRequest;
import com.qcloud.cos.model.CopyObjectResult;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

/**
 * 
 * qcloud cos 基于 V5.0 sdk
 *
 */
public class CosOperate {

	private static final Logger logger = LoggerFactory.getLogger(CosOperate.class);

	private String secretId;

	private String secretKey;

	private String region;

	private String bucket;

	public CosOperate(long appId, String secretId, String secretKey, String region, String bucketName) {
		this.secretId = secretId;
		this.secretKey = secretKey;
		this.region = region;
		this.bucket = bucketName + "-" + String.valueOf(appId);
	}

	/**
	 * 上传文件
	 * 
	 * @param localFile
	 * @param cosPath
	 * @return PutObjectResult
	 */
	public PutObjectResult uploadFile(String localFile, String cosPath) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, cosPath, new File(localFile));
			PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			return putObjectResult;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("cos 上传文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param cosPath
	 * @param bytes
	 * @return PutObjectResult
	 */
	public PutObjectResult uploadFile(String cosPath, InputStream inputSteam) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(inputSteam.available());
			// 设置 Content type, 默认是 application/octet-stream
			objectMetadata.setContentType("application/octet-stream");
			PutObjectResult putObjectResult = cosclient.putObject(bucket, cosPath, inputSteam, objectMetadata);
			return putObjectResult;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("cos 上传文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param cosPath
	 * @param bytes
	 * @return PutObjectResult
	 */
	public PutObjectResult uploadFile(String cosPath, byte[] bytes) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(bytes.length);
			// 设置 Content type, 默认是 application/octet-stream
			objectMetadata.setContentType("application/octet-stream");
			PutObjectResult putObjectResult = cosclient.putObject(bucket, cosPath, new ByteArrayInputStream(bytes),
					objectMetadata);
			return putObjectResult;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("cos 上传文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param cosPath
	 * @return COSObjectInputStream
	 */
	public COSObjectInputStream downFile(String cosPath) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, cosPath);
			COSObject cosObject = cosclient.getObject(getObjectRequest);
			COSObjectInputStream cosObjectInput = cosObject.getObjectContent();
			return cosObjectInput;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("cos 下载文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param cosPath
	 * @param localPath
	 * @return ObjectMetadata
	 */
	public ObjectMetadata downFile(String cosPath, String localPath) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, cosPath);
			ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, new File(localPath));
			return downObjectMeta;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("cos 下载文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param cosPath
	 * @return ObjectMetadata
	 */
	public void deleteObject(String cosPath) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			cosclient.deleteObject(bucket, cosPath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("删除 cos上的文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceBucket
	 * @param sourceFilePath
	 * @param targetBucket
	 * @param targetFilePath
	 * @return CopyObjectResult
	 */
	public CopyObjectResult copyObject(String sourceBucket, String sourceFilePath, String targetBucket,
			String targetFilePath) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosclient = new COSClient(cred, clientConfig);
		try {
			CopyObjectRequest copyObjectRequest = new CopyObjectRequest(sourceBucket, sourceFilePath, targetBucket,
					targetFilePath);
			CopyObjectResult copyObjectResult = cosclient.copyObject(copyObjectRequest);
			return copyObjectResult;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("复制 cos上的文件出错。", e);
		} finally {
			cosclient.shutdown();
		}
	}

}
