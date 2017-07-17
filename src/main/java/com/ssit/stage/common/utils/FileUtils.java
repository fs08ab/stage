package com.ssit.stage.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.ssit.stage.common.constant.ExceptionType;
import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.SystemException;
import com.ssit.stage.common.exception.subtype.ParamInvalidException;
import com.ssit.stage.common.holder.PropertiesHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文件工具类
 *
 * @author Fs
 * @since 2017/5/30 13:33
 */
public class FileUtils {
    private static final Log LOGGER = LogFactory.getLog(FileUtils.class);

    public static String uploadFile(MultipartFile file, String directory) {
        if (file == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("file is null"));
            throw exception;
        }

        String originalFilename = file.getOriginalFilename();
        LOGGER.debug("文件原始名称为:" + originalFilename);

        String contentType = file.getContentType();
        String fileType = contentType.substring(contentType.indexOf("/") + 1);
        String savedFileName = System.currentTimeMillis() + new Random().nextInt(100) + "." + fileType;

        String pathname = System.getProperty("stage.root") + getFilePath(directory) + savedFileName;
        // 通过org.apache.commons.io.FileUtils的writeByteArrayToFile对图片进行保存
        try {
            org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(pathname), file.getBytes());
        } catch (IOException e) {
            BaseException exception = new SystemException(ExceptionType.FILE_EXCEPTION, e);
            LOGGER.error(exception.getLogMessage());
            throw exception;
        }

        return pathname;
    }

    public static List<String> uploadFiles(Map<String, MultipartFile> fileMap, String directory) {
        if (fileMap == null || fileMap.isEmpty()) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("fileMap", JSONObject.toJSONString(fileMap)));
            throw exception;
        }
        Iterator<Map.Entry<String, MultipartFile>> iterator = fileMap.entrySet().iterator();
        MultipartFile file;
        List<String> rlt = new ArrayList<>();
        while (iterator.hasNext()) {
            file = iterator.next().getValue();
            rlt.add(uploadFile(file, directory));
        }

        return rlt;
    }

    public static String getFilePath(String directory) {
        String relationPath = PropertiesHolder.DEFAULT_FILE_DIRECTORY;

        if (StringUtils.isBlank(directory)) {
            directory = relationPath;
        } else {
            directory = relationPath + directory;
        }
        if (!StringUtils.endsWith(directory, "/")) {
            directory += "/";
        }

        return directory;
    }
}
