package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();

	//Пользователь запрашивыет все не прочитаные сообщения мы их вычитываем
	// и отправляем в виде JSON массива
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fromStr = req.getParameter("from");
		int from = 0;
		try {
			from = Integer.parseInt(fromStr);
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}

		//Отправка данных пользователю
		String json = msgList.toJSON(from);
		if (json != null) {
			OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);
		}
	}
}
