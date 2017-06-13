package demo.servlet;

import demo.util.Db;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by zhushuai.net@gmail.com
 * 06/10/2017 09:14.
 * https://github.com/ZhuShuai1992
 */

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String content = req.getParameter("content");
        if (content.length() == 0) {
            req.setAttribute("message", "请输入一IP地址");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT location FROM study.cz88_ip WHERE inet_aton(?) BETWEEN inet_aton (minIp) AND inet_aton(maxIp)";
        try {
            // 3、预编译 SQL 语句
            preparedStatement = connection.prepareStatement(sql);
            // 3.1 set（语句中含有问号，用set 设置参数）
            preparedStatement.setString(1, content);
            // 3.2 当select 时，有 Result 结果集
            // 3.3　当UPDATE/INSERT/DELETE 时，没有结果集
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String location = resultSet.getString("location");

            req.setAttribute("message",location); // K,V
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("message", "数据库异常");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }finally {
            Db.close(resultSet, preparedStatement, connection);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }
}
