package io.fluentqa.mindmap.xmind;

import cn.hutool.core.compress.ZipReader;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ZipUtil;
import io.fluentqa.mindmap.exception.MindMapException;
import io.fluentqa.mindmap.xmind.model.XmindRawData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipFile;

public class XMindUtil {
    private static String XML_FILE_NAME = "content.xml";
    private static String JSON_FILE_NAME = "content.json";

    public static XmindRawData readXMindFile(String filePath) {
        XmindRawData.XmindRawDataBuilder builder = XmindRawData.builder();
        try (ZipFile zipFile = ZipUtil.toZipFile(FileUtil.file(filePath), StandardCharsets.UTF_8)) {
            ZipUtil.read(zipFile, zipEntry -> {
                // 读取到content.xml,存储起来
                if (XML_FILE_NAME.equalsIgnoreCase(zipEntry.getName())) {
                    try (InputStream zipStream = ZipUtil.getStream(zipFile, zipEntry)) {
                        builder.contentXml(new String(IoUtil.readBytes(zipStream)));
                    } catch (IOException e) {
                        throw new MindMapException(e);
                    }
                }
                // 读取到content.json,存储起来,说明当前读取的xmind是zen格式
                if (JSON_FILE_NAME.equalsIgnoreCase(zipEntry.getName())) {
                    try (InputStream zipStream = ZipUtil.getStream(zipFile, zipEntry)) {
                        builder.contentJson(new String(IoUtil.readBytes(zipStream)));
                    } catch (IOException e) {
                        throw new MindMapException(e);
                    }
                }
            });
        } catch (Exception e) {
            throw new MindMapException("解析失败!" + e.getLocalizedMessage());
        }
        return builder.build();
    }

    public static XmindRawData readXmindFile(InputStream in) {
        XmindRawData.XmindRawDataBuilder builder = XmindRawData.builder();
        ZipReader reader = new ZipReader(in, Charset.defaultCharset());
        reader.read(zipEntry -> {
            // 读取到content.xml,存储起来
            if (XML_FILE_NAME.equalsIgnoreCase(zipEntry.getName())) {
                builder.contentXml(new String(IoUtil.readBytes(in)));
            }
            // 读取到content.json,存储起来,说明当前读取的xmind是zen格式
            if (JSON_FILE_NAME.equalsIgnoreCase(zipEntry.getName())) {
                builder.contentJson(new String(IoUtil.readBytes(in)));
            }
        });
        return builder.build();
    }
}
