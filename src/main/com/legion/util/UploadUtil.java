package legion.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UploadUtil {

    public static String upload(MultipartFile[] files, String path,Integer id) throws IOException{
//        String name = file.getOriginalFilename();//上传文件的真实名称
//        String suffixName= name.substring(name.lastIndexOf("."));  //获取后缀名
//        String hash = Integer.toHexString(new Random().nextInt());  //自定义随机数作为文件名
//        String fileName= hash+suffixName;
//        File tempFile = new File(path,fileName);
//        if(!tempFile.getParentFile().exists()){
//            tempFile.getParentFile().mkdir();
//        }
//        if(tempFile.exists()){
//            tempFile.delete();
//        }
//        tempFile.createNewFile();
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String fileName ="";
        ArrayList<String> list = new ArrayList<>();
        for(MultipartFile file:files){
            String name = file.getOriginalFilename();
            String suffixName= name.substring(name.lastIndexOf("."));
            String hash = Integer.toHexString(new Random().nextInt());
            fileName =id+"-"+dateFormat.format(now)+"-"+hash+suffixName;
            File tempFile = new File(path,fileName);
            if(!tempFile.getParentFile().exists()){
                tempFile.getParentFile().mkdir();
            }

            tempFile.createNewFile();
            file.transferTo(tempFile);
            list.add(tempFile.getName());
        }
        return fileName;
    }

    public static String avatarupload(MultipartFile file,String path,String username) throws IOException{
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName= name.substring(name.lastIndexOf("."));  //后缀名
        String fileName= username+suffixName;
        File tempFile = new File(path,fileName);
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdir();
        }
        if(tempFile.exists()){
            tempFile.delete();
        }
        tempFile.createNewFile();
        file.transferTo(tempFile);
        return tempFile.getName();
    }
}
