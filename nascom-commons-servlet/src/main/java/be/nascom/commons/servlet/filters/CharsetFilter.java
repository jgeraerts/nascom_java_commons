package be.nascom.commons.servlet.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * This is a Servlet Filter which is capable of setting the character encoding of the ServletRequest.
 * To configure, set the "requestEncoding" parameter, if not set, the default is "utf-8"
 *
 * Original Source Code by: Sergey Astakhov
 * Found on: http://wiki.apache.org/tomcat/Tomcat/UTF-8
 *
 * User: bart
 * Date: Apr 24, 2009
 * Time: 12:23:57 PM
 */
public class CharsetFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
