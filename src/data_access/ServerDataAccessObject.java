package data_access;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

public class ServerDataAccessObject {
    private static final String BASE_URL = "utcssa24regisytm.org/records";

    public ServerDataAccessObject() {

    }

//    public List<Ticket> fetch() throws IOException {
//        List<Ticket> ticketList = new ArrayList<>();
//        URL url = new URL(BASE_URL);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        int responseCode = connection.getResponseCode();
//
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    Ticket ticket = new Ticket(parts[0], parts[1], parts[2], parts[3], LocalDate.parse(parts[4]));
//                    ticketList.add(ticket);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Failed to fetch from remote. Code" + responseCode);
//        }
//        connection.disconnect();
//        return ticketList;
//    }

    public static void uploadCsvFile(File localCsvFile) {
        /**
         * upload the local csv file to remote.
         * should be call everytime FileDataAccessObject.saveTicket() is called.
         */
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                 BufferedReader reader = new BufferedReader(new FileReader(localCsvFile))) {

                // Read the local CSV file and write it to the server
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                // Handle server error or other response codes
                System.out.println("Failed to upload CSV file. Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void push(Ticket ticket) throws DuplicateNameException {
//        try {
//            URL url = new URL(BASE_URL);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//
//            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))) {
//                writer.write(ticket.toCSV());
//            }
//
//            int responseCode = connection.getResponseCode();
//
//            if (responseCode != HttpURLConnection.HTTP_OK) {
//                // Handle server error or other response codes
//                System.out.println("Failed to save ticket. Response Code: " + responseCode);
//            }
//
//            connection.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
