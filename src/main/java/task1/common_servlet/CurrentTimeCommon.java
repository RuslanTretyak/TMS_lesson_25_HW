package task1.common_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task1.util.CurrentTime;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/time/common_servlet")
public class CurrentTimeCommon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentTime time = new CurrentTime();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (req.getParameter("time") != null && time.getTimeZonesKeys().contains(req.getParameter("time"))) {
            printWriter.write(time.getCurrentTime(req.getParameter("time")));
        } else {
            printWriter.write("wrong parameter");
        }
        printWriter.close();
    }


}
