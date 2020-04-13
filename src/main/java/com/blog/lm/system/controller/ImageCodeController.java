package com.blog.lm.system.controller;

import com.blog.lm.common.constant.CommonConstant;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author xus
 * @Date 2019/11/21 14:27
 * @Description TODO
 **/
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class ImageCodeController {

    private final DefaultKaptcha defaultKaptcha;

    private final RedisTemplate redisTemplate;

    /**
     * 生成验证码
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/api/code")
    public void getCode(HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        //生成验证码
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);

        //保存验证码信息
        redisTemplate.opsForValue().set(CommonConstant.DEFAULT_CODE_KEY + text, text, 60, TimeUnit.SECONDS);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        ImageIO.write(image, "jpg", jpegOutputStream);
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
