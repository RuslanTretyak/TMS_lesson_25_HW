package task2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AgeChecker extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        BufferedReader reader = req.getReader();
        StringBuilder lines = new StringBuilder();
        String tempLine;
        while ((tempLine = reader.readLine()) != null){
            lines.append(tempLine);
        }
        JSONObject requestBody = (JSONObject) JSONValue.parse(lines.toString());
        try {
            int age = Integer.parseInt(requestBody.get("age").toString());
            if (age >= 18) {
                printWriter.write("совершеннолетний");
            } else {
                printWriter.write("несовершеннолетний");
            }
        } catch (Exception e) {
            printWriter.write("неверный запрос");
        }
        printWriter.close();
    }
}
