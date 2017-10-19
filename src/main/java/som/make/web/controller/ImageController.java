package som.make.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/image")
public class ImageController {

    @CrossOrigin
    @RequestMapping
    public String getImageUrl() {
        return null;
    }

    /**
     * @CrossOrigin注解用来处理跨域
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     */
    @CrossOrigin()
    @RequestMapping("/easy")
    public void getEasyImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String path = httpServletRequest.getServletContext().getRealPath("image/meinv.jpg");
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        int allLength = fileInputStream.available();
        byte[] bytes = new byte[allLength];
        fileInputStream.read(bytes, 0, bytes.length);
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        httpServletResponse.setHeader("Content-Type","image/jped");
        httpServletResponse.setHeader("content-disposition", "attachment;filename=abv.jpg");
        //httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        servletOutputStream.write(bytes);
        servletOutputStream.close();
    }
}
