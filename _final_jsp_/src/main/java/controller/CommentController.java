package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImple;

@WebServlet("/cmtCtrl/*")
public class CommentController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommentController.class);
	private final CommentService csv;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public CommentController() {
		csv = new CommentServiceImple();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		
		String uri = req.getRequestURI();
		String path = uri.substring("/cmtCtrl/".length());
		
		String pathVar = "";
		if(path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/")+1);
			path = path.substring(0, path.lastIndexOf("/"));
		}
		
		switch (path) {
		case "post":
			
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> {}", sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				isUp = csv.register(new CommentVO(
												Long.parseLong(jsonObj.get("pno").toString()),
												jsonObj.get("writer").toString(),
												jsonObj.get("content").toString()));
				log.info(">>> Cmt Post > {}", isUp > 0 ? "Success" : "Fail");
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				List<CommentVO> list = csv.getList(Long.parseLong(pathVar));
				// 자바 객체를 자바스크립트 객체 형식으로 변환하는 로직이 필요
				// json simple 라이브러리에서 제공하는 객체들을 활용하여 변환
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray(); // ArrayList
				
				for (int i = 0; i < list.size(); i++) {					
					jsonObjArr[i] = new JSONObject(); // K : V => Map
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("modAt", list.get(i).getModAt());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
			}
			break;
		case "erase":
			isUp = csv.remove(Long.parseLong(pathVar));
			log.info(">>> Cmt Remove > {}", isUp > 0 ? "Success" : "Fail");
			PrintWriter out = res.getWriter();
			out.print(isUp);
			break;
		case "edit":
			
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> {}", sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				isUp = csv.modify(new CommentVO(
												Long.parseLong(jsonObj.get("cno").toString()),
												jsonObj.get("content").toString()));
				log.info(">>> Cmt Modify > {}", isUp > 0 ? "Success" : "Fail");
				PrintWriter out2 = res.getWriter();
				out2.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
