package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userFilter" ,urlPatterns = {"/*"},initParams={@WebInitParam(name
        ="EXCLUDED_PAGESSES" , value = "/User;/userlogin;/mainpage")})
public class userFilter implements Filter {
    private String excludedPages;
    private String[] excludedPageArray;

    public void destroy() {
        this.excludedPages = null;
        this.excludedPageArray = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      // System.out.println("过滤器起作用了");


       HttpServletRequest request=(HttpServletRequest)req;
        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {// 遍历例外url数组
            //System.out.println("page:"+request.getServletPath());
            // 判断当前URL是否与例外页面相同
            if(request.getServletPath().indexOf(page)!=-1){ // 从第2个字符开始取（把前面的/去掉）
               // System.out.println(page + ", you're excluded.");
                isExcludedPage = true;
                break;
            }
        }
        HttpServletResponse hsr = (HttpServletResponse) resp;
        hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        hsr.setDateHeader("Expires", 0); // Proxies.
        if (isExcludedPage) {//在过滤url之外
            //request.getSession().setAttribute("user",new model.User());
            chain.doFilter(req, resp);
        }
        else {// 不在过滤url之外
          // System.out.println("fuckf");
            String user=(String) request.getSession().getAttribute("UID");
            if(user!=null)
                chain.doFilter(req, resp);
            else
                request.getRequestDispatcher("/mainpage/index.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
        excludedPages = config.getInitParameter("EXCLUDED_PAGESSES");
        if (null != excludedPages && excludedPages.length() != 0) { // 例外页面不为空
            excludedPageArray = excludedPages.split(String.valueOf(';'));
        }
        for(String s:excludedPageArray){
            System.out.println(s);
        }
    }
}
