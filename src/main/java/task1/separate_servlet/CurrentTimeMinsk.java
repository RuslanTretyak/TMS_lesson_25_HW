package task1.separate_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task1.util.CurrentTime;

import java.io.IOException;
import java.io.PrintWriter;

public class CurrentTimeMinsk extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentTime time = new CurrentTime();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(time.getCurrentTime("minsk"));
        printWriter.close();
    }
}
