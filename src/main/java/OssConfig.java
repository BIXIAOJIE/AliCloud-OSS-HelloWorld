import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

public class OssConfig {
    public OSS getOssClient(){
        String endpoint = "endpoint";
        String accessKeyId = "填写你的accessKeyId";
        String accessKeySecret = "填写你的accessKeySecret";
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
