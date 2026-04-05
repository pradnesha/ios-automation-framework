package utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackNotifier {



    public static void sendMessage(String text) {
        try {
            String webhookUrl = ConfigReader.getProperty("slack.webhook.url");

            URL url = new URL(webhookUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String payload = "{ \"text\": \"" + text + "\" }";

            OutputStream os = conn.getOutputStream();
            os.write(payload.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Slack response: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
