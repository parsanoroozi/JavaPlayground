package volumeII.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * In the GET command, you simply attach query parameters to the end of the URL.
 * The URL has the form
 * http://host/path?query
 * Each parameter has the form name=value. Parameters are separated by & characters.
 * Parameter values are encoded using the URL encoding scheme, following these rules:
 * • Leave the characters A through Z, a through z, 0 through 9, and . - ~ _
 * unchanged.
 * • Replace all spaces with + characters.
 * • Encode all other characters into UTF-8 and encode each byte by a %, followed
 * by a two-digit hexadecimal number.
 * */
public class Client {
    public static void main() throws IOException {

        URL url = new URL("https://www.usps.com/zip4/");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print("name1" + "=" + URLEncoder.encode("value1", StandardCharsets.UTF_8) + "&");
        out.print("name2" + "=" + URLEncoder.encode("value2", StandardCharsets.UTF_8));
        out.close();

    }
}
