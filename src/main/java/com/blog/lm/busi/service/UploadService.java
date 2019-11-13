package com.blog.lm.busi.service;

import cn.hutool.core.io.FileUtil;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 操作图片服务器接口
 */
@Component
public class UploadService {
    @Resource
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 上传接口
     * @param file
     * @return
     * @throws IOException
     */
    public String save(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String extName = FileUtil.extName(file.getOriginalFilename());
        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, bytes.length, extName, null);
        return storePath.getFullPath();
    }

    /**
     * 删除接口
     * @param uri
     * @return
     */
    public String del(@RequestParam String uri) {
        StorePath storePath = fromUri(uri);
        fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        return "删除成功";
    }
    /**
     * 从uri生成StorePath对象.
     */
    private StorePath fromUri(String uri) {
        String group = uri.replaceFirst("/.*$", "");
        String path = uri.replaceFirst("^.*?/", "");
        return new StorePath(group, path);
    }

    /**
     * 下载
     * @param fullPath
     * @return
     */
    public byte[] getBin(String fullPath) {
        try {
            StorePath storePath = fromUri(fullPath);
            String group = storePath.getGroup();
            String path = storePath.getPath();
            return fastFileStorageClient.downloadFile(group, path, new DownloadByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
