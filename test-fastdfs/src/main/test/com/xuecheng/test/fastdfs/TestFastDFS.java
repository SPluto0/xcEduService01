package com.xuecheng.test.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Date 2019/9/23 9:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFastDFS {

    @Test
    public void testFDS(){
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient,用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建storageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "D:/accp/mysql.txt";
            //上传成功后拿到文件Id
            String file1Id = storageClient1.upload_file1(filePath, "txt", null);
            System.out.println(file1Id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testDownloadFile()throws Exception{
//加载fastdfs-client.properties配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        //定义TrackerClient,用于请求TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        //连接tracker
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Stroage
        StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
        //创建storageClient
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
        String fileId = "group1/M00/00/00/wKgZhV2IXpKAEo2iAAA5KzeA-H0067.txt";
        byte[] result = storageClient1.download_file1(fileId);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:520.txt"));
        fileOutputStream.write(result);
        fileOutputStream.close();
    }
}
