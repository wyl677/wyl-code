package com.wyl.io;

import java.io.InputStream;

/**
 * @auther yanl.wang
 * @date 2023/2/12
 **/
public class Resources {

    /**
     * 根据配置文件的路径，加载配置文件成字节输入流，存到内存中
     * @param path
     * @return
     */
    public static InputStream getResourceAsSteam(String path){
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }


}
