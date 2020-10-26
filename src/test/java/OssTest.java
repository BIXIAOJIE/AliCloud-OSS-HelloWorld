import com.aliyun.oss.OSS;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class OssTest {


    // OSS展示所有文件
    @Test
    public void showAllFiles(){
        OssConfig ossConfig = new OssConfig();
        System.out.println("展示所有文件");
        OSS ossClient = ossConfig.getOssClient();
        ObjectListing objectListing = ossClient.listObjects("adsfcyybf");
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        ossClient.shutdown();
    }

    // OSS上传文件
    @Test
    public void uploadFile(){
        OssConfig ossConfig = new OssConfig();
        String objectName = "1.txt";
        OSS ossClient = ossConfig.getOssClient();
        String content = "Hello OSS";
        ossClient.putObject("adsfcyybf", objectName, new ByteArrayInputStream(content.getBytes()));
        ossClient.shutdown();
    }

    // OSS创建Bucket
    @Test
    public void createBucket(){
        OssConfig ossConfig = new OssConfig();
        OSS ossClient = ossConfig.getOssClient();
        Bucket test = ossClient.createBucket("testcatblogcreate");
        ossClient.shutdown();
    }

    // OSS删除Bucket
    @Test
    public void deleteBucket(){
        OssConfig ossConfig = new OssConfig();
        OSS ossClient = ossConfig.getOssClient();
        ossClient.deleteBucket("testcatblogcreate");
        ossClient.shutdown();
    }

    // OSS删除文件
    @Test
    public  void deleteObject(){
        String objectName = "1.txt";
        OssConfig ossConfig = new OssConfig();
        OSS ossClient = ossConfig.getOssClient();
        ossClient.deleteObject("adsfcyybf", objectName);
        ossClient.shutdown();
    }
}
