package MyPackage;

import jakarta.servlet.ServletException;
import java.util.Date;
import java.text.SimpleDateFormat;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@WebServlet("/weather") 
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String myApiKey = "Use your API "; // Use your actual API key here
		
		String city = request.getParameter("city");
		
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + myApiKey;
		
		try {
		
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			InputStream inpStream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(inpStream);
			
			
			StringBuilder responseContent = new StringBuilder();
			
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNext()) {
				responseContent.append(scanner.nextLine());
			}
			scanner.close();
			
			
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
			
			
			
			
			double tempInKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
			int tempInCelsius = (int)(tempInKelvin - 273.15);
			
		
			int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
			
		
			double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
			
		
			int visibilityInMeter = jsonObject.get("visibility").getAsInt();
			int visibility = visibilityInMeter / 1000;
			
			
			String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
			
			
			int cloudCover = jsonObject.getAsJsonObject("clouds").get("all").getAsInt();
			
			
			long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
			SimpleDateFormat sdfDate = new SimpleDateFormat("EEE MMM dd yyyy");
			String date = sdfDate.format(new Date(dateTimestamp));
			
		
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			String formattedTime = sdfTime.format(new Date());
			
		
			request.setAttribute("date", date);
			request.setAttribute("city", city);
			request.setAttribute("visibility", visibility);
			request.setAttribute("temperature", tempInCelsius);
			request.setAttribute("weatherCondition", weatherCondition); 
			request.setAttribute("humidity", humidity);    
			request.setAttribute("windSpeed", windSpeed);
			request.setAttribute("cloudCover", cloudCover);
			request.setAttribute("currentTime", formattedTime);
			request.setAttribute("weatherData", responseContent.toString());
			
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
