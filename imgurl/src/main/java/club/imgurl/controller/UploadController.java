package club.imgurl.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import club.imgurl.common.ResponseResult;
import club.imgurl.util.DateUtil;
import club.imgurl.util.IPUtil;
import club.imgurl.util.UUIDUtil;
import club.imgurl.util.cos.UploadMedia;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/api/upload")
@Slf4j
public class UploadController {

	@Value("${img.path}")
	private String imgPath;

	@Value("${img.url}")
	public String imgUrl;

	@Value("${upload.type}")
	private Integer uploadType;

	@Autowired
	private UploadMedia uploadMedia;

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public ResponseResult uploadImg(MultipartFile file, HttpServletRequest request) {
		ResponseResult rr = new ResponseResult().fail();
		if (!"POST".equalsIgnoreCase(request.getMethod())) {
			return rr.message("仅支持POST请求。").build();
		}

		if (file.isEmpty()) {
			return rr.message("图片不能为空。").build();
		}
		try {
			if (uploadType == 1) {
				return rr.success().data(new ModelMap().addAttribute("url", this.localUpload(file, request)))
						.message("图片上传成功。").build();
			} else if (uploadType == 2) {
				return rr.success().data(new ModelMap().addAttribute("url", this.qcloudUpload(file, request))).build();

			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return rr.message("图片上传失败。").build();
		}
		return rr.fail().build();

	}

	/**
	 * 腾讯云cos上传
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String qcloudUpload(MultipartFile file, HttpServletRequest request) throws IOException {

		String originalFileName = file.getOriginalFilename();
		String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		String path = DateUtil.getDate(DateUtil.YEAR) + "/" + DateUtil.getDate(DateUtil.MONTH) + "/"
				+ DateUtil.getDate(DateUtil.DAY) + "/" + UUIDUtil.getUUID() + suffix;
		log.info("图片上传成功，客户端IP：" + IPUtil.getIpAddr(request) + "，图片地址：" + path + "，外网访问地址：" + imgUrl + path);
		return imgUrl + uploadMedia.uploadFile(path, file.getInputStream());
	}

	/**
	 * 本地上传
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	private String localUpload(MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String originalFileName = file.getOriginalFilename();
		String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		String path = DateUtil.getDate(DateUtil.YEAR) + "/" + DateUtil.getDate(DateUtil.MONTH) + "/"
				+ DateUtil.getDate(DateUtil.DAY) + "/";
		if (!new File(imgPath + path).exists()) {
			new File(imgPath + path).mkdirs();
		}
		String fileName = UUIDUtil.getUUID() + suffix;
		String imgPaths = imgPath + path + fileName;
		File dest = new File(imgPaths);

		file.transferTo(dest);
		log.info("图片上传成功，客户端IP：" + IPUtil.getIpAddr(request) + "，图片地址：" + imgPaths + "，外网访问地址：" + imgUrl + path
				+ fileName);
		return imgUrl + path + fileName;
	}

}
