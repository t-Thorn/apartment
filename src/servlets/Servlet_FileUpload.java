package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

@WebServlet(name = "Servlet_FileUpload",value = "/File")
//@MultipartConfig(location="d:/upload", maxFileSize = 8388608, fileSizeThreshold = 819200)
@MultipartConfig
public class Servlet_FileUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("get1");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("get");
        //单,多文件上传通用
       // System.out.println("1");
        Collection<Part> parts = request.getParts();// 多文件上传   获取part对象 part对象存储文件内容返回集合类型
        //System.out.println("1");
        System.out.println("size:"+parts.size());
        for(Part part:parts){
            //固定写法
            //System.out.println("1");
            String value=part.getHeader("Content-Disposition");//提取请求头
            int begin = value.indexOf("filename=");
            begin=begin+10;
            int end = value.lastIndexOf("\"");
            String name=value.substring(begin, end);
            //System.out.println(name);
            //给文件名后追加数字
            Date date=new Date();//java.util.Date
            long time=date.getTime();//获取1970年到现在的毫秒数
            name="E:\\upload\\temp\\"+name;
            System.out.println(name);
            part.write(name);
            part.delete();//删除临时文件
        }


        /*请求头  根据它找到上传文件名
         * Content-Disposition: form-data; name="upload"; filename="servlet2.docx"
            Content-Type: application/vnd.openxmlformats-officedocument.wordprocessingml.document
         */


    }

}
