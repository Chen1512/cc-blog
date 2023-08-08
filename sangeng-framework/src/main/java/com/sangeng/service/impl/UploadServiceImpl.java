package com.sangeng.service.impl;

import com.sangeng.domain.ResponseResult;
import com.sangeng.enums.AppHttpCodeEnum;
import com.sangeng.service.UploadService;
import com.sangeng.utils.AliOssUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2023--08-10:54
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    @Autowired
    private AliOssUtil aliOssUtil;
    /**
     * @Description:上传文件到OSS
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/8 10:55
     */
    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        log.info("文件上传：{}",img);

        try {
            //原始文件名
            String originalFilename = img.getOriginalFilename();
            //截取原始文件名的后缀   dfdfdf.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;

            //文件的请求路径
            String filePath = aliOssUtil.upload(img.getBytes(), objectName);
            return ResponseResult.okResult(filePath);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }

        return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_FAILED);
    }
}
