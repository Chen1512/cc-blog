package com.sangeng.service;

import com.sangeng.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shkstart
 * @create 2023--08-10:54
 */
public interface UploadService {
    /**
     * @Description:上传文件到OSS
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/8 10:54
     */
    ResponseResult uploadImg(MultipartFile img);
}
