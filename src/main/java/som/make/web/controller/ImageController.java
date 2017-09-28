package som.make.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("/easy")
    public void getEasyImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("=======================");
        String path = httpServletRequest.getServletContext().getRealPath("image/meinv.jpg");
        System.out.println(path);
        File file = new File(path);
        System.out.println("file exists is " + file.exists());
        FileInputStream fileInputStream = new FileInputStream(file);
        //FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        int allLength = fileInputStream.available();
        byte[] bytes = new byte[allLength];
        fileInputStream.read(bytes, 0, bytes.length);
        System.out.println("allLength is " + allLength);
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        httpServletResponse.setHeader("Content-Type","image/jped");
        httpServletResponse.setHeader("content-disposition", "attachment;filename=abv.jpg");
        servletOutputStream.write(bytes);
        servletOutputStream.close();
    }
}
