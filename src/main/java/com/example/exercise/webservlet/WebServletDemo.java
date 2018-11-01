package com.example.exercise.webservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

@WebServlet(name = "webservlet", urlPatterns = "/servlet", loadOnStartup = 1)
public class WebServletDemo extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("userName");
        if (StringUtils.isEmpty(userName)) {
            userName = "guest";
        }
        writer.append(userName + ":=========Servlet doGet ===========");
        logger.info("=========Servlet doGet ===========");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.append("=========Servlet doPost ===========");
        logger.info("=========Servlet doPost ===========");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.info("=========Servlet init ===========");
    }
}
