# Weather Application Using OpenWeather API

## Overview
**WeatherApplictaion** is a user-friendly Java web application designed to provide real-time weather information for any city around the globe. Built with Java Servlets, JSP (JavaServer Pages), HTML, CSS, and JavaScript, this application integrates seamlessly with the **OpenWeatherMap API** to deliver current weather conditions, ensuring that users have access to up-to-date meteorological data. 

## Features
- **City Input**: Users can enter the name of any city to retrieve its current weather data.
- **Current Weather Display**: The application shows detailed weather information, including:
  - Temperature (in Celsius)
  - Humidity levels
  - Wind speed and direction
  - Visibility metrics
  - Cloud cover percentage
  - Weather condition description (e.g., sunny, rainy)
- **User-Friendly Interface**: Designed with HTML and CSS for an intuitive experience.
- **Responsive Design**: The app is accessible across various devices with an aesthetically pleasing layout.

## Technologies Used
- **Java Servlets**: For backend logic and processing user requests.
- **JavaServer Pages (JSP)**: To render dynamic web content.
- **HTML & CSS**: For structuring and styling the web pages.
- **JavaScript**: To enhance user interactions and dynamically update the interface.
- **Gson Library**: For parsing JSON responses from the **OpenWeatherMap API**.
- **OpenWeatherMap API**: A powerful API that provides accurate and real-time weather data globally.

## Setup Instructions
Follow these steps to set up the WeatherApp on your local machine:

### Prerequisites
1. **Eclipse IDE** or **IntelliJ IDEA** installed on your system.
2. **Apache Tomcat 10.1.1** server.

### Steps
1. **Configure Apache Tomcat**:
   - Open **Eclipse IDE**.
   - Navigate to `Window` -> `Preferences`.
   - Go to `Server` -> `Runtime Environments`.
   - Click `Add`, select **Apache Tomcat v10.1.1**, and specify the installation directory.

2. **Clone the Repository**:
   - Use the command: 
     ```bash
     git clone <repository_url>
     ```

3. **Import the Project**:
   - In Eclipse, go to `File` -> `Import`.
   - Select `Existing Projects into Workspace`.
   - Choose the cloned project directory and import it.

4. **Add Gson Library**:
   - Ensure the **Gson library** is included in the `src/webapp/WEB-INF/lib` directory. If not, add it to your build path manually.

5. **Obtain API Key**:
   - Sign up at the **OpenWeatherMap** website and obtain an API key.
   - Replace the placeholder `myApiKey` in **MyServlet.java** with your actual API key.

6. **Run the Application**:
   - Right-click the project in Eclipse and select `Run As` -> `Run on Server`.
   - Choose your configured Tomcat server and click `Finish`.

7. **Access the Application**:
   - Open your web browser and navigate to: 
     ```
     http://localhost:8080/WeatherApp
     ```

## Screenshots
Here are some screenshots of the WeatherApp in action:

1. ![WeatherApp Screenshot 1](screenshots/1l.jpeg)
2. ![WeatherApp Screenshot 2](screenshots/2l.jpeg)
3. ![WeatherApp Screenshot 3](screenshots/3s.jpeg)

## Created by:
**Vaishnavi Rana**  
[LinkedIn](https://www.linkedin.com/in/vaishnavi-rana-535853213/) | [GitHub](https://github.com/vaishnavi242002)

---

Feel free to reach out if you have any questions or need further assistance!
