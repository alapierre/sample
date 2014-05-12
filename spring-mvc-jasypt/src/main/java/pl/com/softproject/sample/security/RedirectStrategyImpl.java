package pl.com.softproject.sample.security;

import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:gchas@soft-project.pl">Grzegorz Chaś</a>
 *         $Rev: $, $LastChangedBy: $
 *         $LastChangedDate: $
 */
public class RedirectStrategyImpl implements RedirectStrategy {

    private String defaultTargetUrl;

    @Override
    public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {

        String contextPath = request.getContextPath() + "/";

        if (contextPath != null && url.endsWith(contextPath)) {
            response.sendRedirect(url + defaultTargetUrl);
        } else {
            response.sendRedirect(url);
        }
    }

    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }
}
